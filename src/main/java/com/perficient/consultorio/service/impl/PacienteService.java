package com.perficient.consultorio.service.impl;

import com.perficient.consultorio.dto.PacienteDto;
import com.perficient.consultorio.entitis.Paciente;
import com.perficient.consultorio.excepcion.BusinessException;
import com.perficient.consultorio.mapper.IPacienteMapper;
import com.perficient.consultorio.repository.IPacienteRepository;
import com.perficient.consultorio.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PacienteService implements IPacienteService {

    private IPacienteRepository pacienteRepository;
    private IPacienteMapper pacienteMapper;

    public PacienteService(IPacienteRepository pacienteRepository, IPacienteMapper pacienteMapper) {
        this.pacienteRepository = pacienteRepository;
        this.pacienteMapper = pacienteMapper;
    }

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
