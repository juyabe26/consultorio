package com.perficient.consultorio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consultamedicamento")
public class ConsultaMedicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuidmedicamento")
    private Medicamento uuidMedicamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuidconsulta")
    private Consulta uuidConsulta;
}
