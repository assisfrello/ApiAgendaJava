package com.example.Agenda.Service.Impl;

import com.example.Agenda.Domain.Models.Agenda;
import com.example.Agenda.Repository.IAgendaRepository;
import com.example.Agenda.Service.IAgendaReceiveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgendaReceiveService implements IAgendaReceiveService {
    private final IAgendaRepository repository;

    public void Add(Agenda agenda)
    {
        repository.save(agenda);
    }
}
