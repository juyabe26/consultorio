package com.perficient.consultorio.mapper;

import com.perficient.consultorio.dto.UsuarioDto;
import com.perficient.consultorio.entitis.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUsuarioMapper {
  UsuarioDto toUsuarioDto(Usuario usuario);
}
