package com.perficient.consultorio.service;

import com.perficient.consultorio.repository.UsuarioRepository;
import com.perficient.consultorio.web.dto.UsuarioDto;
import com.perficient.consultorio.web.dto.mapper.UsuarioMapper;
import com.perficient.consultorio.excepcion.BusinessException;
import com.perficient.consultorio.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private UsuarioMapper usuarioMapper;

  /**
   * Servicio encargado de buscar el usuario con los parámetros indicados
   * @param login
   * @param password
   * @return Datos del usuario
   */
  public UsuarioDto buscarUsuario(String login, String password) {
    Usuario usuario = usuarioRepository.buscarUsuario(login,password);
    if(Objects.isNull(usuario))
      throw new BusinessException("El usuario no existe");
    return usuarioMapper.toUsuarioDto(usuario);
  }
}
