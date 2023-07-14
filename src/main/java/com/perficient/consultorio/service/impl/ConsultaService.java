package com.perficient.consultorio.service.impl;

import com.perficient.consultorio.dto.ConsultaDto;
import com.perficient.consultorio.entitis.*;
import com.perficient.consultorio.repository.IConsultaMedicamentoRepository;
import com.perficient.consultorio.repository.IConsultaRepository;
import com.perficient.consultorio.service.IConsultaService;
import com.perficient.consultorio.service.IMedicamentoService;
import com.perficient.consultorio.service.IMedicoService;
import com.perficient.consultorio.service.IPacienteService;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService implements IConsultaService {


    private final IConsultaRepository consultaRepository;
    private final IConsultaMedicamentoRepository consultaMedicamentoRepository;
    private final IPacienteService pacienteService;
    private final IMedicoService medicoService;
    private final IMedicamentoService medicamentoService;

    public ConsultaService(IConsultaRepository consultaRepository, IConsultaMedicamentoRepository consultaMedicamentoRepository, IPacienteService pacienteService, IMedicoService medicoService, IMedicamentoService medicamentoService) {
        this.consultaRepository = consultaRepository;
        this.consultaMedicamentoRepository = consultaMedicamentoRepository;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
        this.medicamentoService = medicamentoService;
    }

    public ConsultaDto crearConsulta(ConsultaDto consultaDto) {
        Paciente paciente = pacienteService.buscarPorDocumento(consultaDto.getNumeroDocumentoPaciente());
        Medico medico = medicoService.buscarPorDocumento(consultaDto.getNumeroDocumentoMedico());
        Consulta consulta = new Consulta();
        consulta.setDiagnostico(consultaDto.getDiagnostico());
        consulta.setUuidNMedico(medico);
        consulta.setUuidPaciente(paciente);
        consulta = consultaRepository.save(consulta);
        for (String codigoMedicamento : consultaDto.getMedicamentos()) {
            Medicamento medicamento = medicamentoService.buscarPorCodigo(codigoMedicamento);
            ConsultaMedicamento consultaMedicamento = new ConsultaMedicamento();
            consultaMedicamento.setUuidConsulta(consulta);
            consultaMedicamento.setUuidMedicamento(medicamento);
            consultaMedicamentoRepository.save(consultaMedicamento);

        }
        return consultaDto;
    }
}