package com.perficient.consultorio.web;

import com.perficient.consultorio.service.ConsultaService;
import com.perficient.consultorio.web.dto.AgendaDto;
import com.perficient.consultorio.web.dto.ConsultaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/crearConsulta")
    public @ResponseBody ConsultaDto crearConsulta(@RequestBody ConsultaDto consultaDto) {
        return consultaService.crearConsulta(consultaDto);
    }

}
