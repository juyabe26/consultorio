package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.Medico;
import com.perficient.consultorio.web.dto.MedicoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepositoryJpa {

    List<Medico> buscarMedicoPorNombresDocumento(MedicoDto medicoDto);
}
