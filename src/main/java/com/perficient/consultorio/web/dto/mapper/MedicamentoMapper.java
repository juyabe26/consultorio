package com.perficient.consultorio.web.dto.mapper;

import com.perficient.consultorio.model.Medicamento;
import com.perficient.consultorio.model.Medico;
import com.perficient.consultorio.web.dto.MedicamentoDto;
import com.perficient.consultorio.web.dto.MedicoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper {
    MedicamentoDto toMedicamentoDto(Medicamento medicamento);

    Medicamento toMedicamento(MedicamentoDto medicamentoDto);

    List<MedicamentoDto> MedicamentoDtoList(List<Medicamento> medicamentoListList);
}
