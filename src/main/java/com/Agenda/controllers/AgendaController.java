package com.Agenda.controllers;

import com.Agenda.dto.AgendaAdicionarRequestDto;
import com.Agenda.dto.AgendaAdicionarResponseDto;
import com.Agenda.services.IAgendaService;
import jakarta.validation.ValidationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    private IAgendaService service;

    public AgendaController(IAgendaService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public AgendaAdicionarResponseDto Adicionar(@RequestBody AgendaAdicionarRequestDto request)
    {
        try {
            return service.Adicionar(request);
        } catch (ValidationException e){
            return AgendaAdicionarResponseDto.ReturnError(e.getMessage());
        }
    }
}
