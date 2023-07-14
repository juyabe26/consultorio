package com.perficient.consultorio.service;

import com.perficient.consultorio.entitis.Medico;
import com.perficient.consultorio.dto.CalendarioMedicoDto;
import com.perficient.consultorio.dto.MedicoDto;

import java.util.List;

public interface IMedicoService {

    List<MedicoDto> buscarMedicoPorNombresDocumento(MedicoDto medicoDto);

    Medico buscarPorDocumento(Integer numeroDocumento);

    CalendarioMedicoDto disponibilidad(int numeroDocumento);

    MedicoDto crearMedico(MedicoDto medicoDto);

    Boolean validarContrato(int numeroDocumento);

    Boolean activo(int numeroDocumento, boolean activo);
}
