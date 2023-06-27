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
@Table(name = "calendariomedico")
public class CalendarioMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uuidmedico")
    private Medico uuidMedico;

    @Column
    private Boolean lunes;

    @Column
    private Boolean martes;

    @Column
    private Boolean miercoles;

    @Column
    private Boolean jueves;

    @Column
    private Boolean viernes;

    @Column
    private Boolean sabado;

    @Column
    private Boolean domingo;

    @Column(name = "horaingresoam")
    private String horaIngresoAm;

    @Column(name = "horasalidaam")
    private String horaSalidaAm;

    @Column(name = "horaingresopm")
    private String horaIngresoPm;

    @Column(name = "horasalidapm")
    private String horaSalidaPm;

}
