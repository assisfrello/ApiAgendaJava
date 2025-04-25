package com.example.Agenda.Service.Impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetRequest;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.example.Agenda.Configurations.RabbitConfig;
import com.example.Agenda.Domain.Dto.AgendaAddRequestDto;
import com.example.Agenda.Domain.Dto.AgendaAddResponseDto;
import com.example.Agenda.Domain.Dto.AgendaGetRespondeDto;
import com.example.Agenda.Domain.Dto.AgendaRemoveResponseDto;
import com.example.Agenda.Domain.Models.Agenda;
import com.example.Agenda.Repository.IAgendaRepository;
import com.example.Agenda.Service.IAgendaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class AgendaService implements IAgendaService {
    private final RabbitTemplate rabbitTemplate;
    private final ElasticsearchClient elasticsearchClient;
    private final IAgendaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public AgendaAddResponseDto Add(AgendaAddRequestDto request)
    {
        var agenda = modelMapper.map(request, Agenda.class);

        if (agenda.getContatos() != null) {
            agenda.getContatos().forEach(contato -> contato.setAgenda(agenda));
        }

        if (agenda.getEnderecos() != null) {
            agenda.getEnderecos().forEach(endereco -> endereco.setAgenda(agenda));
        }

        var possuiDocumentoCadastrado = repository.findByDocumento(request.getDocumento());
        if (possuiDocumentoCadastrado.isPresent())
            return AgendaAddResponseDto.ReturnError("Documento já cadastrado");

        rabbitTemplate.convertAndSend(RabbitConfig.AgendaAddQueue, agenda);

        return AgendaAddResponseDto.ReturnSuccess();
    }

    @Override
    public List<AgendaGetRespondeDto> GetAll() {
        List<Agenda> agendaList = repository.findAll();

        Type listType = new TypeToken<List<AgendaGetRespondeDto>>() {}.getType();

        return modelMapper.map(agendaList, listType);
    }

    @Override
    public AgendaGetRespondeDto Get(long id) {
        var agenda = repository.findById(id);

        return modelMapper.map(agenda, AgendaGetRespondeDto.class);
    }

    @Override
    public AgendaGetRespondeDto GetByDocumento(String documento) {
        try {
            var getRequest = GetRequest.of(g -> g
                    .index("agenda")
                    .id(documento)
            );

            var response = elasticsearchClient.get(getRequest, Agenda.class);

            if (response.found()) {
                return modelMapper.map(response.source(), AgendaGetRespondeDto.class);
            }

            var agenda = repository.findByDocumento(documento).orElse(null);
            SalvarAgendaElastic(agenda);

            return modelMapper.map(agenda, AgendaGetRespondeDto.class);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao buscar agenda no Elasticsearch", e);
        }
    }

    @Override
    public AgendaRemoveResponseDto Remove(long id) {
        var agenda = repository.findById(id);
        if (agenda.isEmpty())
            return AgendaRemoveResponseDto.ReturnError("Não existe registro para o id informado.");

        repository.delete(agenda.get());

        return AgendaRemoveResponseDto.ReturnSuccess();
    }

    //region Métodos privados
    private void SalvarAgendaElastic(Agenda agenda) {
        try {
            IndexRequest<Agenda> request = IndexRequest.of(i -> i
                    .index("agenda")
                    .id(agenda.getDocumento())
                    .document(agenda)
            );

            IndexResponse response = elasticsearchClient.index(request);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar Agenda no Elasticsearch", e);
        }
    }
    //endregion
}
