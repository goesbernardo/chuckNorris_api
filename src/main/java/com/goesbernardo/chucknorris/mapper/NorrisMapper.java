package com.goesbernardo.chucknorris.mapper;

import com.goesbernardo.chucknorris.dto.NorrisDto;
import com.goesbernardo.chucknorris.model.Norris;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NorrisMapper {

    NorrisMapper INSTANCE = Mappers.getMapper(NorrisMapper.class);

    Norris toModel (NorrisDto adviceDto);

    NorrisDto toDTO(Norris advice);
}
