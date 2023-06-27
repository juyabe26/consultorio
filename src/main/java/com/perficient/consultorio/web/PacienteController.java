package com.perficient.consultorio.web;

import com.perficient.consultorio.service.PacienteService;
import com.perficient.consultorio.web.dto.PacienteDto;
import com.perficient.consultorio.web.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public @ResponseBody PacienteDto buscarPacientePorDocumento(@RequestParam(value = "documento") int documento){
        return  pacienteService.buscarPacientePorDocumento(documento);
    }


}