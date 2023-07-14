package com.perficient.consultorio.service.impl;

import com.perficient.consultorio.dto.UsuarioDto;
import com.perficient.consultorio.entitis.Usuario;
import com.perficient.consultorio.excepcion.BusinessException;
import com.perficient.consultorio.mapper.IUsuarioMapper;
import com.perficient.consultorio.repository.IUsuarioRepository;
import com.perficient.consultorio.service.IUsuarioService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioService implements IUsuarioService {

    private IUsuarioRepository usuarioRepository;
    private IUsuarioMapper usuarioMapper;

    public UsuarioService(IUsuarioRepository usuarioRepository, IUsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    /**
     * Servicio encargado de buscar el usuario con los parámetros indicados
     *
     * @param login
     * @param password
     * @return Datos del usuario
     */
    public UsuarioDto buscarUsuario(String login, String password) {
        Usuario usuario = usuarioRepository.buscarUsuario(login, password);
        if (Objects.isNull(usuario))
            throw new BusinessException("El usuario no existe");
        return usuarioMapper.toUsuarioDto(usuario);
    }
}
