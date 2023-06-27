package com.perficient.consultorio.web.dto.mapper;

import com.perficient.consultorio.model.CalendarioMedico;
import com.perficient.consultorio.web.dto.CalendarioMedicoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CalendarioMedicoMapper {
    CalendarioMedicoDto toCalendarioMedicoDto(CalendarioMedico calendarioMedico);
}
