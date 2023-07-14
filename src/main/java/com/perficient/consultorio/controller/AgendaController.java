package com.perficient.consultorio.controller;

import com.perficient.consultorio.service.IAgendaService;
import com.perficient.consultorio.dto.AgendaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    private IAgendaService iAgendaService;

    @PostMapping("/crearAgenda")
    public @ResponseBody AgendaDto crearAgenda(@RequestBody AgendaDto agendaDto) {
        return iAgendaService.crearAgenda(agendaDto);
    }
}
