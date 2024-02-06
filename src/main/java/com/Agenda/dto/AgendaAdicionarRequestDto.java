package com.Agenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AgendaAdicionarRequestDto {
    @NotBlank
    public String Documento;
    @NotBlank
    public String Nome;
    @NotNull
    public AgendaContatoAdicionarRequestDto Contato;
    @NotNull
    public AgendaEnderecoAdicionarRequestDto Endereco;
}

