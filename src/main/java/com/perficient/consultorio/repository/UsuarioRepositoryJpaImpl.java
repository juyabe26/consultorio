package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UsuarioRepositoryJpaImpl implements UsuarioRepositoryJpa{

  public Usuario buscarUsuario(String login, String password) {
    Usuario usuario = new Usuario();
    usuario.setSegundoNombre("Andres");
    usuario.setPrimerNombre("Julian");
    usuario.setPrimerApellido("Buitron");
    usuario.setSegundoApellido("Rendon");
    usuario.setTipoDocumento("CC");
    usuario.setNumeroDocumento("121212");
    usuario.setEmail("juyabe26@gmail.com");
    return usuario;
  }
}
