package com.perficient.consultorio.entitis;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuidpaciente")
    private Paciente uuidPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuidmedico")
    private Medico uuidMedico;

    @Column(name = "fechaconsulta")
    private LocalDate fechaConsulta;

    @Column(name = "horaconsulta")
    private String horaConsulta;
}
