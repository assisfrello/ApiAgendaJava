package com.Agenda.dto;

import jakarta.validation.constraints.NotBlank;

public class AgendaContatoAdicionarRequestDto {
    @NotBlank
    public String Celular;
    public String Email;
    public String Telefone;
}
