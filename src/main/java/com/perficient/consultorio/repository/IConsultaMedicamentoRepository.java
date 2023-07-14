package com.perficient.consultorio.repository;

import com.perficient.consultorio.entitis.ConsultaMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IConsultaMedicamentoRepository extends JpaRepository<ConsultaMedicamento, UUID> {
}
