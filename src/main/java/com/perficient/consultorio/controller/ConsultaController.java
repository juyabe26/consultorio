package com.perficient.consultorio.controller;

import com.perficient.consultorio.service.IConsultaService;

import com.perficient.consultorio.dto.ConsultaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private IConsultaService iConsultaService;

    @PostMapping("/crearConsulta")
    public ConsultaDto crearConsulta(@RequestBody ConsultaDto consultaDto) {
        return iConsultaService.crearConsulta(consultaDto);
    }

}
