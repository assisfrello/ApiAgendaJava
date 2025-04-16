package com.example.Agenda.Domain.Dto;

import com.example.Agenda.Domain.Dto.Base.ResponseBase;

public class AgendaAddResponseDto extends ResponseBase {
    public static AgendaAddResponseDto ReturnSuccess(){
        AgendaAddResponseDto retorno = new AgendaAddResponseDto();
        retorno.Success = true;
        retorno.Message = "Operação realizada com sucesso";
        return retorno;
    }

    public static AgendaAddResponseDto ReturnError(String message){
        AgendaAddResponseDto retorno = new AgendaAddResponseDto();
        retorno.Success = false;
        retorno.Message = message;
        return retorno;
    }
}
