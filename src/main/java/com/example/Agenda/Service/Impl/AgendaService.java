package com.example.Agenda.Service.Impl;

import com.example.Agenda.Domain.Dto.AgendaAdicionarRequestDto;
import com.example.Agenda.Domain.Dto.AgendaAdicionarResponseDto;
import com.example.Agenda.Domain.Models.Agenda;
import com.example.Agenda.Domain.Models.AgendaContatos;
import com.example.Agenda.Repository.IAgendaRepository;
import com.example.Agenda.Service.IAgendaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgendaService implements IAgendaService {
    private final IAgendaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public AgendaAdicionarResponseDto Adicionar(AgendaAdicionarRequestDto request)
    {
        Agenda agenda = modelMapper.map(request, Agenda.class);

        var novaagenda = new Agenda();
        novaagenda.setDocumento("000000000000");
        novaagenda.setNome("nome teste");

        var novocontato = new AgendaContatos();
        novocontato.setCelular("99999999");
        novocontato.setAgenda(novaagenda);

        novaagenda.getContatos().add(novocontato);

        repository.save(agenda);

        return AgendaAdicionarResponseDto.ReturnSuccess();
    }
}
