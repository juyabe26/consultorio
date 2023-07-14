package com.perficient.consultorio.service;

import com.perficient.consultorio.entitis.Paciente;
import com.perficient.consultorio.dto.PacienteDto;

public interface IPacienteService {

    PacienteDto buscarPacientePorDocumento(int documento);

    Paciente buscarPorDocumento(int numeroDocumento);

    PacienteDto crearPaciente(PacienteDto pacienteDto);
}
