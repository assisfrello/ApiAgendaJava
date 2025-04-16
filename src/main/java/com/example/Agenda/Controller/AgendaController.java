package com.example.Agenda.Controller;

import com.example.Agenda.Domain.Dto.AgendaAddRequestDto;
import com.example.Agenda.Domain.Dto.AgendaAddResponseDto;
import com.example.Agenda.Domain.Dto.AgendaGetRespondeDto;
import com.example.Agenda.Domain.Dto.AgendaRemoveResponseDto;
import com.example.Agenda.Service.IAgendaService;
import jakarta.validation.ValidationException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
    private final IAgendaService service;

    public AgendaController(IAgendaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public AgendaGetRespondeDto Get(@PathVariable long id)
    {
        try {
            return service.Get(id);
        } catch (ValidationException e){
            return AgendaGetRespondeDto.ReturnError(e.getMessage());
        }
    }

    @GetMapping
    public List<AgendaGetRespondeDto> GetAll()
    {
        try {
            return service.GetAll();
        } catch (ValidationException e){
            return null;
        }
    }

    @PostMapping
    @Transactional
    public AgendaAddResponseDto Add(@RequestBody AgendaAddRequestDto request)
    {
        try {
            return service.Add(request);
        } catch (ValidationException e){
            return AgendaAddResponseDto.ReturnError(e.getMessage());
        }
    }

    @RequestMapping
    @Transactional
    public AgendaRemoveResponseDto Remove(@RequestBody long id)
    {
        try {
            return service.Remove(id);
        } catch (ValidationException e){
            return AgendaRemoveResponseDto.ReturnError(e.getMessage());
        }
    }
}
