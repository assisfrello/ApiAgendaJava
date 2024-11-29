package com.example.Agenda.Domain.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class AgendaAdicionarRequestDto {
    @Getter
    @NotBlank
    public String Documento;
    @Getter
    @NotBlank
    public String Nome;
    @Getter
    @NotNull
    public List<AgendaContatoAdicionarRequestDto> Contato;
    @Getter
    @NotNull
    public List<AgendaEnderecoAdicionarRequestDto> Endereco;
}
