package com.perficient.consultorio.service.impl;

import com.perficient.consultorio.dto.CalendarioMedicoDto;
import com.perficient.consultorio.dto.MedicoDto;
import com.perficient.consultorio.entitis.CalendarioMedico;
import com.perficient.consultorio.entitis.Medico;
import com.perficient.consultorio.excepcion.BusinessException;
import com.perficient.consultorio.mapper.ICalendarioMedicoMapper;
import com.perficient.consultorio.mapper.IMedicoMapper;
import com.perficient.consultorio.repository.ICalendarioMedicoRepository;
import com.perficient.consultorio.repository.IMedicoRepository;
import com.perficient.consultorio.repository.IMedicoRepositoryJpa;
import com.perficient.consultorio.service.IMedicoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class MedicoService implements IMedicoService {


    private IMedicoRepositoryJpa medicoRepositoryJpa;
    private IMedicoRepository medicoRepository;
    private ICalendarioMedicoRepository calendarioMedicoRepository;
    private IMedicoMapper medicoMapper;
    private ICalendarioMedicoMapper calendarioMedicoMapper;

    public MedicoService(IMedicoRepositoryJpa medicoRepositoryJpa, IMedicoRepository medicoRepository, ICalendarioMedicoRepository calendarioMedicoRepository, IMedicoMapper medicoMapper, ICalendarioMedicoMapper calendarioMedicoMapper) {
        this.medicoRepositoryJpa = medicoRepositoryJpa;
        this.medicoRepository = medicoRepository;
        this.calendarioMedicoRepository = calendarioMedicoRepository;
        this.medicoMapper = medicoMapper;
        this.calendarioMedicoMapper = calendarioMedicoMapper;
    }

    public List<MedicoDto> buscarMedicoPorNombresDocumento(MedicoDto medicoDto) {
        List<Medico> medicoList = medicoRepositoryJpa.buscarMedicoPorNombresDocumento(medicoDto);
        if (medicoList.isEmpty())
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

    public Boolean validarContrato(int numeroDocumento) {
        Medico medico = medicoRepository.buscarPorDocumento(numeroDocumento);
        Date fechaActual = new Date();
        if (fechaActual.before(medico.getFechaInicioContrato()) && fechaActual.after(medico.getFechaFinContrato()))
            return true;
        return false;
    }

    public Boolean activo(int numeroDocumento, boolean activo) {
        Medico medico = medicoRepository.buscarPorDocumento(numeroDocumento);
        medico.setActivo(activo);
        medicoRepository.save(medico);
        return true;
    }
}
