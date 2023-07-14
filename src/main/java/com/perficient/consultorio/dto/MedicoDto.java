package com.perficient.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicoDto {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Character tipoDocumento;
    private int numeroDocumento;
    private Character genero;
    private LocalDate fechaNacimiento;
    private String tarjetaProfecional;
    private String especialidad;
    private Date fechaInicioContrato;
    private Date fechaFinContrato;
    private Boolean activo;
}
