package com.Agenda.dto;

import jakarta.validation.constraints.NotBlank;

public class AgendaEnderecoAdicionarRequestDto {
    @NotBlank
    public String Logradouro;
    @NotBlank
    public String Numero;
    public String Complemento;
    @NotBlank
    public String Bairro;
    @NotBlank
    public String Cidade;
    @NotBlank
    public String Uf;
}
