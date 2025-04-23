package com.example.Agenda.Service.Impl;

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

import java.lang.reflect.Type;
import java.util.List;

@Service
@AllArgsConstructor
public class AgendaService implements IAgendaService {
    private final RabbitTemplate rabbitTemplate;
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

        //repository.save(agenda);
        rabbitTemplate.convertAndSend(RabbitConfig.AgendaAddQueue, "agenda");

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
    public AgendaRemoveResponseDto Remove(long id) {
        var agenda = repository.findById(id);
        if (agenda.isEmpty())
            return AgendaRemoveResponseDto.ReturnError("Não existe registro para o id informado.");

        repository.delete(agenda.get());

        return AgendaRemoveResponseDto.ReturnSuccess();
    }
}
