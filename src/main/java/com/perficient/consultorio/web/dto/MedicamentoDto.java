package com.perficient.consultorio.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicamentoDto {
    private String codigo;
    private String nombreGenerico;
    private String nombreComercial;
    private String laboratorio;
    private String marca;
}
