package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository {
}
/*public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}*/
