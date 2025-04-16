package com.example.Agenda.Domain.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class AgendaAddRequestDto {
    @NotBlank
    public String Documento;
    @NotBlank
    public String Nome;
    @NotNull
    public List<AgendaContatoAddRequestDto> Contato;
    @NotNull
    public List<AgendaEnderecoAddRequestDto> Endereco;
}
