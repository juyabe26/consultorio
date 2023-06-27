package com.perficient.consultorio.web.dto.mapper;

import com.perficient.consultorio.model.Medico;
import com.perficient.consultorio.model.Paciente;
import com.perficient.consultorio.web.dto.MedicoDto;
import com.perficient.consultorio.web.dto.PacienteDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoDto toMedicoDto(Medico medico);
    List<MedicoDto> MedicosDtoList(List<Medico> medicoList);
}
