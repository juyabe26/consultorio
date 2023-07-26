package com.perficient.consultorio.controller;

import com.perficient.consultorio.service.IMedicamentoService;
import com.perficient.consultorio.dto.MedicamentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {

    @Autowired
    private IMedicamentoService iMedicamentoService;

    @GetMapping
    public List<MedicamentoDto> buscarMedicamento(@RequestBody MedicamentoDto medicamentoDto){
        return  iMedicamentoService.buscarMedicamento(medicamentoDto);
    }

    @PostMapping("/crearMedicamento")
    public MedicamentoDto crearMedicamento(@RequestBody MedicamentoDto medicamentoDto) {
        return iMedicamentoService.crearMedicamento(medicamentoDto);
    }
}
