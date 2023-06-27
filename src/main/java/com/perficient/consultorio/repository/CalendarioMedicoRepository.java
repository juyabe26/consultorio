package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.CalendarioMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CalendarioMedicoRepository extends JpaRepository<CalendarioMedico, UUID> {

    @Query("SELECT c FROM CalendarioMedico c " +
            " WHERE c.uuidMedico.uuid = :uuidMedico ")
    CalendarioMedico disponibilidad(@Param("uuidMedico") UUID uuidMedico);

}
