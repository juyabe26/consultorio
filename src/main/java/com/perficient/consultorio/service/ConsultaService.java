package com.perficient.consultorio.service;

import com.perficient.consultorio.model.*;
import com.perficient.consultorio.repository.ConsultaMedicamentoRepository;
import com.perficient.consultorio.repository.ConsultaRepository;
import com.perficient.consultorio.web.dto.ConsultaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaMedicamentoRepository consultaMedicamentoRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private MedicamentoService medicamentoService;

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