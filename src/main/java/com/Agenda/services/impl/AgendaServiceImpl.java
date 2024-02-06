package com.Agenda.services.impl;

import com.Agenda.dto.AgendaAdicionarRequestDto;
import com.Agenda.dto.AgendaAdicionarResponseDto;
import com.Agenda.repositories.IAgendaRepository;
import com.Agenda.services.IAgendaService;
import com.Agenda.models.Agenda;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Service;

@Service
public class AgendaServiceImpl implements IAgendaService {
    private IAgendaRepository repository;
    private final ModelMapper modelMapper;

    @ConstructorBinding
    public AgendaServiceImpl(IAgendaRepository repository, ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public AgendaAdicionarResponseDto Adicionar(AgendaAdicionarRequestDto request)
    {
        Agenda agenda = modelMapper.map(request, Agenda.class);

        repository.save(agenda);

        return AgendaAdicionarResponseDto.ReturnSuccess();
    }
}
