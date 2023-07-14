package com.perficient.consultorio.service.impl;

import com.perficient.consultorio.dto.AgendaDto;
import com.perficient.consultorio.entitis.Agenda;
import com.perficient.consultorio.entitis.Medico;
import com.perficient.consultorio.entitis.Paciente;
import com.perficient.consultorio.mapper.IAgendaMapper;
import com.perficient.consultorio.repository.IAgendaRepository;
import com.perficient.consultorio.service.IAgendaService;
import com.perficient.consultorio.service.IMedicoService;
import com.perficient.consultorio.service.IPacienteService;
import org.springframework.stereotype.Service;

@Service
public class AgendaService implements IAgendaService {

    private final IAgendaRepository agendaRepository;
    private final IPacienteService pacienteService;
    private final IMedicoService medicoService;
    private final IAgendaMapper agendaMapper;

    public AgendaService(IAgendaRepository agendaRepository, IPacienteService pacienteService, IMedicoService medicoService, IAgendaMapper agendaMapper) {
        this.agendaRepository = agendaRepository;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
        this.agendaMapper = agendaMapper;
    }

    public AgendaDto crearAgenda(AgendaDto agendaDto) {

        Paciente paciente = pacienteService.buscarPorDocumento(agendaDto.getNumeroDocumentoPaciente());
        Medico medico = medicoService.buscarPorDocumento(agendaDto.getNumeroDocumentoMedico());
        Agenda agenda = new Agenda();
        agenda.setUuidPaciente(paciente);
        agenda.setUuidMedico(medico);
        agenda.setFechaConsulta(agendaDto.getFechaConsulta());
        agenda.setHoraConsulta(agendaDto.getHoraConsulta());
        return agendaMapper.toAgendaDto(agendaRepository.save(agenda));

    }
}
