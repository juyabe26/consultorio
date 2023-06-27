package com.perficient.consultorio.service;

import com.perficient.consultorio.excepcion.BusinessException;
import com.perficient.consultorio.model.CalendarioMedico;
import com.perficient.consultorio.model.Medico;
import com.perficient.consultorio.model.Paciente;
import com.perficient.consultorio.repository.CalendarioMedicoRepository;
import com.perficient.consultorio.repository.MedicoRepository;
import com.perficient.consultorio.repository.MedicoRepositoryJpa;
import com.perficient.consultorio.web.dto.CalendarioMedicoDto;
import com.perficient.consultorio.web.dto.MedicoDto;
import com.perficient.consultorio.web.dto.mapper.CalendarioMedicoMapper;
import com.perficient.consultorio.web.dto.mapper.MedicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepositoryJpa medicoRepositoryJpa;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private CalendarioMedicoRepository calendarioMedicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    @Autowired
    private CalendarioMedicoMapper calendarioMedicoMapper;

    public List<MedicoDto> buscarMedicoPorNombresDocumento(MedicoDto medicoDto) {
        List<Medico> medicoList = medicoRepositoryJpa.buscarMedicoPorNombresDocumento(medicoDto);
        if(medicoList.isEmpty())
            throw new BusinessException("El usuario no existe");
        return medicoMapper.MedicosDtoList(medicoList);
    }

    public Medico buscarPorDocumento(Integer numeroDocumento) {
        Medico medico = medicoRepository.buscarPorDocumento(numeroDocumento);
        if (Objects.isNull(medico))
            throw new BusinessException("El Medico no existe");
        return medico;
    }

    public CalendarioMedicoDto disponibilidad(int numeroDocumento) {
        Medico medico = medicoRepository.buscarPorDocumento(numeroDocumento);
        CalendarioMedico calendarioMedico = calendarioMedicoRepository.disponibilidad(medico.getUuid());
        if (Objects.isNull(calendarioMedico))
            throw new BusinessException("El Medico no existe");
        return calendarioMedicoMapper.toCalendarioMedicoDto(calendarioMedico);
    }

    public MedicoDto crearMedico(MedicoDto medicoDto) {
        return medicoMapper.toMedicoDto(medicoRepository.save(medicoMapper.toMedico(medicoDto)));
    }
}
