package com.perficient.consultorio.service;

import com.perficient.consultorio.excepcion.BusinessException;
import com.perficient.consultorio.model.Medicamento;
import com.perficient.consultorio.repository.MedicamentoRepositoryJpa;
import com.perficient.consultorio.web.dto.MedicamentoDto;
import com.perficient.consultorio.web.dto.mapper.MedicamentoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService {
    @Autowired
    private MedicamentoRepositoryJpa medicoMedicamentoRepositoryJpa;

    @Autowired
    private MedicamentoMapper medicamentoMapper;
    public List<MedicamentoDto> buscarMedicamento(MedicamentoDto medicamentoDto) {
        List<Medicamento> medicamentoList = medicoMedicamentoRepositoryJpa.buscarMedicamento(medicamentoDto);
        if(medicamentoList.isEmpty())
            throw new BusinessException("El medicamento no existe");
        return medicamentoMapper.MedicamentoDtoList(medicamentoList);
    }
}
