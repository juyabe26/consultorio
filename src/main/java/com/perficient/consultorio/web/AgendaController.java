package com.perficient.consultorio.web;

import com.perficient.consultorio.service.AgendaService;
import com.perficient.consultorio.web.dto.AgendaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/crearAgenda")
    public @ResponseBody AgendaDto crearAgenda(@RequestBody AgendaDto agendaDto) {
        return agendaService.crearAgenda(agendaDto);
    }
}
