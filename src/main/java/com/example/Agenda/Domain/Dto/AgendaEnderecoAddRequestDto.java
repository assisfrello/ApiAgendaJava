package com.example.Agenda.Domain.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AgendaEnderecoAddRequestDto {
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
