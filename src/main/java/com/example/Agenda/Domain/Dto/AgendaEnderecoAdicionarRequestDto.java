package com.example.Agenda.Domain.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

public class AgendaEnderecoAdicionarRequestDto {
    @Getter
    @NotBlank
    public String Logradouro;
    @Getter
    @NotBlank
    public String Numero;
    @Getter
    public String Complemento;
    @Getter
    @NotBlank
    public String Bairro;
    @Getter
    @NotBlank
    public String Cidade;
    @Getter
    @NotBlank
    public String Uf;
}
