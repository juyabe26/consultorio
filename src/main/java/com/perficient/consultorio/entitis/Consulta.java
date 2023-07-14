package com.perficient.consultorio.entitis;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuidpaciente")
    private Paciente uuidPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuidmedico")
    private Medico uuidNMedico;

    @Column
    private String diagnostico;
}
