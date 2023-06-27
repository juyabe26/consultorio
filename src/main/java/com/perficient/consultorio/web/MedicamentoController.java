package com.perficient.consultorio.web;

import com.perficient.consultorio.service.MedicamentoService;
import com.perficient.consultorio.web.dto.ConsultaDto;
import com.perficient.consultorio.web.dto.MedicamentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public @ResponseBody List<MedicamentoDto> buscarMedicamento(@RequestBody MedicamentoDto medicamentoDto){
        return  medicamentoService.buscarMedicamento(medicamentoDto);
    }

    @PostMapping("/crearMedicamento")
    public @ResponseBody MedicamentoDto crearMedicamento(@RequestBody MedicamentoDto medicamentoDto) {
        return medicamentoService.crearMedicamento(medicamentoDto);
    }
}
