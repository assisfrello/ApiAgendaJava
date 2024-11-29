package com.example.Agenda.Domain.Dto;

import com.example.Agenda.Domain.Dto.Base.ResponseBase;

public class AgendaAdicionarResponseDto extends ResponseBase {
    public static AgendaAdicionarResponseDto ReturnSuccess(){
        AgendaAdicionarResponseDto retorno = new AgendaAdicionarResponseDto();
        retorno.Success = true;
        retorno.Message = "Operação realizada com sucesso";
        return retorno;
    }

    public static AgendaAdicionarResponseDto ReturnError(String message){
        AgendaAdicionarResponseDto retorno = new AgendaAdicionarResponseDto();
        retorno.Success = false;
        retorno.Message = message;
        return retorno;
    }
}
