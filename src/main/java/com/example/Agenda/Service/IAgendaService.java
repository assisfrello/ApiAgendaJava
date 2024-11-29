package com.example.Agenda.Service;

import com.example.Agenda.Domain.Dto.AgendaAdicionarRequestDto;
import com.example.Agenda.Domain.Dto.AgendaAdicionarResponseDto;

public interface IAgendaService {
    AgendaAdicionarResponseDto Adicionar(AgendaAdicionarRequestDto request);
}
