package com.example.Agenda.Domain.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaEnderecoGetRespondeDto {
    public String logradouro;
    public String numero;
    public String complemento;
    public String bairro;
    public String cidade;
    public String uf;
}
