package com.example.Agenda.Domain.Dto;

import com.example.Agenda.Domain.Dto.Base.ResponseBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AgendaGetRespondeDto extends ResponseBase {
    public Long id;
    public String documento;
    public String nome;
    public List<AgendaContatoGetRespondeDto> contato = new ArrayList<>();
    public List<AgendaEnderecoGetRespondeDto> endereco = new ArrayList<>();

    public static AgendaGetRespondeDto ReturnError(String message){
        AgendaGetRespondeDto retorno = new AgendaGetRespondeDto();
        retorno.Success = false;
        retorno.Message = message;
        return retorno;
    }
}