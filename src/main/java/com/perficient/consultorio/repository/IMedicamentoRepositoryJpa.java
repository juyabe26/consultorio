package com.perficient.consultorio.repository;

import com.perficient.consultorio.entitis.Medicamento;
import com.perficient.consultorio.dto.MedicamentoDto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IMedicamentoRepositoryJpa {
    List<Medicamento> buscarMedicamento(MedicamentoDto medicamentoDto);
}
