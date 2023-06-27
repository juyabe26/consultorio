package com.perficient.consultorio.web;

import com.perficient.consultorio.model.Medico;
import com.perficient.consultorio.service.MedicoService;
import com.perficient.consultorio.web.dto.CalendarioMedicoDto;
import com.perficient.consultorio.web.dto.MedicamentoDto;
import com.perficient.consultorio.web.dto.MedicoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {


    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public @ResponseBody List<MedicoDto> buscarMedicoPorNombresDocumento(@RequestBody MedicoDto medicoDto){
        return  medicoService.buscarMedicoPorNombresDocumento(medicoDto);
    }

    @GetMapping("/disponibilidad")
    public @ResponseBody CalendarioMedicoDto disponibilidad(@RequestParam(value = "numeroDocumento") int numeroDocumento){
        return  medicoService.disponibilidad(numeroDocumento);
    }

    @PostMapping("/crearMedico")
    public @ResponseBody MedicoDto crearMedico(@RequestBody MedicoDto medicoDto) {
        return medicoService.crearMedico(medicoDto);
    }

}
