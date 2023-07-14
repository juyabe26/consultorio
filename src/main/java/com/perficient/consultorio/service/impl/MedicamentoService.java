package com.perficient.consultorio.service.impl;

import com.perficient.consultorio.dto.MedicamentoDto;
import com.perficient.consultorio.entitis.Medicamento;
import com.perficient.consultorio.excepcion.BusinessException;
import com.perficient.consultorio.mapper.IMedicamentoMapper;
import com.perficient.consultorio.repository.IMedicamentoRepository;
import com.perficient.consultorio.repository.IMedicamentoRepositoryJpa;
import com.perficient.consultorio.service.IMedicamentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService implements IMedicamentoService {

    private final IMedicamentoRepositoryJpa medicoMedicamentoRepositoryJpa;
    private final IMedicamentoRepository medicamentoRepository;
    private final IMedicamentoMapper medicamentoMapper;

    public MedicamentoService(IMedicamentoRepositoryJpa medicoMedicamentoRepositoryJpa, IMedicamentoRepository medicamentoRepository, IMedicamentoMapper medicamentoMapper) {
        this.medicoMedicamentoRepositoryJpa = medicoMedicamentoRepositoryJpa;
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoMapper = medicamentoMapper;
    }

    public List<MedicamentoDto> buscarMedicamento(MedicamentoDto medicamentoDto) {
        List<Medicamento> medicamentoList = medicoMedicamentoRepositoryJpa.buscarMedicamento(medicamentoDto);
        if (medicamentoList.isEmpty())
            throw new BusinessException("El medicamento no existe");
        return medicamentoMapper.MedicamentoDtoList(medicamentoList);
    }


    public Medicamento buscarPorCodigo(String codigoMedicamento) {
        return medicamentoRepository.buscarPorCodigo(codigoMedicamento);
    }

    public MedicamentoDto crearMedicamento(MedicamentoDto medicamentoDto) {
        return medicamentoMapper.toMedicamentoDto(medicamentoRepository.save(medicamentoMapper.toMedicamento(medicamentoDto)));
    }
}
