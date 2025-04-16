package com.example.Agenda.Service;

import com.example.Agenda.Domain.Dto.AgendaAddRequestDto;
import com.example.Agenda.Domain.Dto.AgendaAddResponseDto;
import com.example.Agenda.Domain.Dto.AgendaGetRespondeDto;
import com.example.Agenda.Domain.Dto.AgendaRemoveResponseDto;

import java.util.List;

public interface IAgendaService {
    AgendaAddResponseDto Add(AgendaAddRequestDto request);

    List<AgendaGetRespondeDto> GetAll();

    AgendaGetRespondeDto Get(long id);

    AgendaRemoveResponseDto Remove(long id);
}
