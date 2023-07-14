package com.perficient.consultorio.repository;

import com.perficient.consultorio.entitis.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, UUID> {
    @Query("SELECT p FROM Paciente p WHERE p.numeroDocumento = :documento")
    Paciente buscarPorDocumento(@Param("documento") Integer documento);
}
