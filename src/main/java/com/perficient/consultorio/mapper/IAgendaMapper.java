package com.perficient.consultorio.mapper;

import com.perficient.consultorio.entitis.Agenda;
import com.perficient.consultorio.dto.AgendaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAgendaMapper {
    AgendaDto toAgendaDto(Agenda agenda);
}
