package com.perficient.consultorio.web.dto.mapper;

import com.perficient.consultorio.web.dto.UsuarioDto;
import com.perficient.consultorio.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
  UsuarioDto toUsuarioDto(Usuario usuario);
}
