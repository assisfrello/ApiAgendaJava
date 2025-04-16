package com.example.Agenda.Domain.Dto;

import com.example.Agenda.Domain.Dto.Base.ResponseBase;

public class AgendaRemoveResponseDto extends ResponseBase {
    public static AgendaRemoveResponseDto ReturnSuccess(){
        var retorno = new AgendaRemoveResponseDto();
        retorno.Success = true;
        retorno.Message = "Operação realizada com sucesso";
        return retorno;
    }

    public static AgendaRemoveResponseDto ReturnError(String message){
        var retorno = new AgendaRemoveResponseDto();
        retorno.Success = false;
        retorno.Message = message;
        return retorno;
    }
}
