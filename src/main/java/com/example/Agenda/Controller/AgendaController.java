package com.example.Agenda.Controller;

import com.example.Agenda.Domain.Dto.AgendaAdicionarRequestDto;
import com.example.Agenda.Domain.Dto.AgendaAdicionarResponseDto;
import com.example.Agenda.Service.IAgendaService;
import jakarta.validation.ValidationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    private IAgendaService service;

    public AgendaController(IAgendaService service) {
        this.service = service;
    }

    @GetMapping
    public String Get()
    {
        return "Teste";
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
