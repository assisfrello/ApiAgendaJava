package com.example.Agenda.Configurations;

import com.example.Agenda.Domain.Dto.AgendaAdicionarRequestDto;
import com.example.Agenda.Domain.Dto.AgendaContatoAdicionarRequestDto;
import com.example.Agenda.Domain.Dto.AgendaEnderecoAdicionarRequestDto;
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
        modelMapper.createTypeMap(AgendaAdicionarRequestDto.class, Agenda.class)
                .addMappings(mapper -> {
                    mapper.map(AgendaAdicionarRequestDto::getDocumento, Agenda::setDocumento);
                    mapper.map(AgendaAdicionarRequestDto::getNome, Agenda::setNome);
                    mapper.map(AgendaAdicionarRequestDto::getContato, Agenda::setContato);
                    mapper.map(AgendaAdicionarRequestDto::getEndereco, Agenda::setEndereco);
                });

        modelMapper.createTypeMap(AgendaContatoAdicionarRequestDto.class, AgendaContatos.class);
        modelMapper.createTypeMap(AgendaEnderecoAdicionarRequestDto.class, AgendaEnderecos.class);
    }
}
