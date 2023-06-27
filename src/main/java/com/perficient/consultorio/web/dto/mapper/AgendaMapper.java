package com.perficient.consultorio.web.dto.mapper;

import com.perficient.consultorio.model.Agenda;
import com.perficient.consultorio.web.dto.AgendaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AgendaMapper {
    AgendaDto toAgendaDto(Agenda agenda);
}
