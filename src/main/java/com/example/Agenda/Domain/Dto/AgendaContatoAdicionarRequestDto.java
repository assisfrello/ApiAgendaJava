package com.example.Agenda.Domain.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class AgendaContatoAdicionarRequestDto {
    @Getter
    @NotBlank
    public String Celular;
    @Getter
    public String Email;
    @Getter
    public String Telefone;
}
