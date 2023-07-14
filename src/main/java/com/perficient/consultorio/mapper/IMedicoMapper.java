package com.perficient.consultorio.mapper;

import com.perficient.consultorio.dto.MedicoDto;
import com.perficient.consultorio.entitis.Medico;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMedicoMapper {
    MedicoDto toMedicoDto(Medico medico);

    Medico toMedico(MedicoDto medicoDto);
    List<MedicoDto> MedicosDtoList(List<Medico> medicoList);
}
