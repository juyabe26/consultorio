package com.perficient.consultorio.web.dto.mapper;

import com.perficient.consultorio.model.Paciente;
import com.perficient.consultorio.model.Usuario;
import com.perficient.consultorio.web.dto.PacienteDto;
import com.perficient.consultorio.web.dto.UsuarioDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteDto toPacienteDto(Paciente paciente);

    Paciente toPaciente(PacienteDto pacienteDto);

}
