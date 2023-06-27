package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    @Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario and u.contrasena = :password")
    Usuario buscarUsuario(@Param("usuario") String login,@Param("password") String password);
}
