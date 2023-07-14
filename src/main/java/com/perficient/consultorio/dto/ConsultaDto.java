package com.perficient.consultorio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaDto {

    private Integer numeroDocumentoPaciente;
    private Integer numeroDocumentoMedico;
    private String diagnostico;
    private List<String> medicamentos;
}
