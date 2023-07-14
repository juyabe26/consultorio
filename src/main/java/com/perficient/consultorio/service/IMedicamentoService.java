package com.perficient.consultorio.service;

import com.perficient.consultorio.entitis.Medicamento;
import com.perficient.consultorio.dto.MedicamentoDto;

import java.util.List;

public interface IMedicamentoService {

    List<MedicamentoDto> buscarMedicamento(MedicamentoDto medicamentoDto);

    Medicamento buscarPorCodigo(String codigoMedicamento);

    MedicamentoDto crearMedicamento(MedicamentoDto medicamentoDto);

}
