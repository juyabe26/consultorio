package com.perficient.consultorio.mapper;

import com.perficient.consultorio.entitis.CalendarioMedico;
import com.perficient.consultorio.dto.CalendarioMedicoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICalendarioMedicoMapper {
    CalendarioMedicoDto toCalendarioMedicoDto(CalendarioMedico calendarioMedico);
}
