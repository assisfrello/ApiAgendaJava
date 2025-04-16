package com.example.Agenda.Domain.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AgendaContatoAddRequestDto {
    @NotBlank
    public String Celular;
    public String Email;
    public String Telefone;
}
