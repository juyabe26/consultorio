package com.perficient.consultorio.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendaDto {
    private LocalDate fechaConsulta;
    private String horaConsulta;
    private Integer numeroDocumentoPaciente;
    private Integer numeroDocumentoMedico;
}
