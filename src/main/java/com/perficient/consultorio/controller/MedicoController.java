package com.perficient.consultorio.controller;

import com.perficient.consultorio.service.IMedicoService;
import com.perficient.consultorio.dto.CalendarioMedicoDto;
import com.perficient.consultorio.dto.MedicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {


    @Autowired
    private IMedicoService IMedicoService;

    @GetMapping
    public List<MedicoDto> buscarMedicoPorNombresDocumento(@RequestBody MedicoDto medicoDto) {
        return IMedicoService.buscarMedicoPorNombresDocumento(medicoDto);
    }

    @GetMapping("/disponibilidad")
    public CalendarioMedicoDto disponibilidad(@RequestParam(value = "numeroDocumento") int numeroDocumento) {
        return IMedicoService.disponibilidad(numeroDocumento);
    }

    @PostMapping("/crearMedico")
    public MedicoDto crearMedico(@RequestBody MedicoDto medicoDto) {
        return IMedicoService.crearMedico(medicoDto);
    }

    @GetMapping("/validarContrato")
    public Boolean validarContrato(@RequestParam(value = "numeroDocumento") int numeroDocumento) {
        return IMedicoService.validarContrato(numeroDocumento);
    }

    @PutMapping("/activo")
    public ResponseEntity<Boolean> activo(@RequestParam(value = "numeroDocumento") int numeroDocumento, @RequestParam(value = "activo") boolean activo) {
        return ResponseEntity.ok(IMedicoService.activo(numeroDocumento, activo));
    }
}
