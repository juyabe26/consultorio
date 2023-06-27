package com.perficient.consultorio.service;

import com.perficient.consultorio.excepcion.BusinessException;
import com.perficient.consultorio.model.Paciente;
import com.perficient.consultorio.model.Usuario;
import com.perficient.consultorio.repository.PacienteRepository;
import com.perficient.consultorio.web.dto.MedicoDto;
import com.perficient.consultorio.web.dto.PacienteDto;
import com.perficient.consultorio.web.dto.mapper.PacienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    public PacienteDto buscarPacientePorDocumento(int documento) {
        return pacienteMapper.toPacienteDto(buscarPorDocumento(documento));
    }

    public Paciente buscarPorDocumento(int numeroDocumento) {
        Paciente paciente = pacienteRepository.buscarPorDocumento(numeroDocumento);
        if (Objects.isNull(paciente))
            throw new BusinessException("El usuario no existe");
        return paciente;
    }

    public PacienteDto crearPaciente(PacienteDto pacienteDto) {
        return pacienteMapper.toPacienteDto(pacienteRepository.save(pacienteMapper.toPaciente(pacienteDto)));
    }
}
