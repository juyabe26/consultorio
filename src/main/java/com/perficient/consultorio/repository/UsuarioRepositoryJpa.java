package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryJpa {

  Usuario buscarUsuario(String login, String password);
}
