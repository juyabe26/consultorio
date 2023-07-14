package com.perficient.consultorio.mapper;

import com.perficient.consultorio.entitis.Paciente;
import com.perficient.consultorio.dto.PacienteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPacienteMapper {

    PacienteDto toPacienteDto(Paciente paciente);

    Paciente toPaciente(PacienteDto pacienteDto);

}
