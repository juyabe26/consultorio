package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.Medicamento;
import com.perficient.consultorio.web.dto.MedicamentoDto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MedicamentoRepositoryJpa {
    List<Medicamento> buscarMedicamento(MedicamentoDto medicamentoDto);
}
