package com.perficient.consultorio.mapper;

import com.perficient.consultorio.dto.MedicamentoDto;
import com.perficient.consultorio.entitis.Medicamento;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMedicamentoMapper {
    MedicamentoDto toMedicamentoDto(Medicamento medicamento);

    Medicamento toMedicamento(MedicamentoDto medicamentoDto);

    List<MedicamentoDto> MedicamentoDtoList(List<Medicamento> medicamentoListList);
}
