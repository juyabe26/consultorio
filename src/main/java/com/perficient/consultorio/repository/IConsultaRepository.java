package com.perficient.consultorio.repository;

import com.perficient.consultorio.entitis.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, UUID> {
}
