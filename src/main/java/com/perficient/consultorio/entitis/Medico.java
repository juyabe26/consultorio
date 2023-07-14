package com.perficient.consultorio.entitis;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @Column(name = "primernombre")
    private String primerNombre;

    @Column(name = "segundonombre")
    private String segundoNombre;

    @Column(name = "primerapellido")
    private String primerApellido;

    @Column(name = "segundoapellido")
    private String segundoApellido;

    @Column(name = "tipodocumento")
    private Character tipoDocumento;

    @Column(name = "numerodocumento")
    private int numeroDocumento;

    @Column
    private Character genero;

    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "tarjetaprofecional")
    private String tarjetaProfecional;

    @Column
    private String especialidad;

    @Column(name = "fechainiciocontrato")
    private Date fechaInicioContrato;

    @Column(name = "fechafincontrato")
    private Date fechaFinContrato;

    @Column
    private Boolean activo;
}
