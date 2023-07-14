package com.perficient.consultorio.repository;

import com.perficient.consultorio.entitis.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAgendaRepository extends JpaRepository<Agenda, UUID> {
}
