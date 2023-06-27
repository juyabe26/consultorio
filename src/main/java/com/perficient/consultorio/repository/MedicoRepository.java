package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MedicoRepository extends JpaRepository<Medico, UUID> {

    @Query("SELECT m FROM Medico m WHERE m.numeroDocumento = :documento")
    Medico buscarPorDocumento(@Param("documento") Integer documento);
}
