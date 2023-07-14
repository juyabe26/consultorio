package com.perficient.consultorio.controller;

import com.perficient.consultorio.service.IPacienteService;
import com.perficient.consultorio.dto.PacienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private IPacienteService IPacienteService;

    @GetMapping
    public @ResponseBody PacienteDto buscarPacientePorDocumento(@RequestParam(value = "documento") int documento) {
        return IPacienteService.buscarPacientePorDocumento(documento);
    }

    @PostMapping("/crearPaciente")
    public @ResponseBody PacienteDto crearPaciente(@RequestBody PacienteDto pacienteDto) {
        return IPacienteService.crearPaciente(pacienteDto);
    }

}
