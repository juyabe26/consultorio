package com.perficient.consultorio.service;

import com.perficient.consultorio.dto.UsuarioDto;

public interface IUsuarioService {

    UsuarioDto buscarUsuario(String login, String password);
}
