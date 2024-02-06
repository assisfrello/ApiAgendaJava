package com.Agenda.services;

import com.Agenda.dto.AgendaAdicionarRequestDto;
import com.Agenda.dto.AgendaAdicionarResponseDto;

public interface IAgendaService {
    AgendaAdicionarResponseDto Adicionar(AgendaAdicionarRequestDto request);
}
