package com.perficient.consultorio.service;

import com.perficient.consultorio.model.Agenda;
import com.perficient.consultorio.model.Medico;
import com.perficient.consultorio.model.Paciente;
import com.perficient.consultorio.repository.AgendaRepository;
import com.perficient.consultorio.repository.PacienteRepository;
import com.perficient.consultorio.web.dto.AgendaDto;
import com.perficient.consultorio.web.dto.mapper.AgendaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private AgendaMapper agendaMapper;

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
