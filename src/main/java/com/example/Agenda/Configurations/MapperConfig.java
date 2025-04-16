package com.example.Agenda.Configurations;

import com.example.Agenda.Domain.Dto.*;
import com.example.Agenda.Domain.Models.Agenda;
import com.example.Agenda.Domain.Models.AgendaContatos;
import com.example.Agenda.Domain.Models.AgendaEnderecos;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig extends ModelMapper {
    @Bean()
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static ModelMapper initBaseModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setPropertyCondition(Conditions.isNotNull())
            .setSkipNullEnabled(true)
            .setMatchingStrategy(MatchingStrategies.LOOSE)
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        CreateMaps(modelMapper);

        return modelMapper;
    }

    private static void CreateMaps(ModelMapper modelMapper) {
        //region Adicionar
        modelMapper.createTypeMap(AgendaAddRequestDto.class, Agenda.class);
        modelMapper.createTypeMap(AgendaContatoAddRequestDto.class, AgendaContatos.class);
        modelMapper.createTypeMap(AgendaEnderecoAddRequestDto.class, AgendaEnderecos.class);
        //endregion

        //region GetAll
        modelMapper.createTypeMap(Agenda.class, AgendaGetRespondeDto.class);
        modelMapper.createTypeMap(AgendaContatos.class, AgendaContatoGetRespondeDto.class);
        modelMapper.createTypeMap(AgendaEnderecos.class, AgendaEnderecoGetRespondeDto.class);
        //endregion
    }
}
