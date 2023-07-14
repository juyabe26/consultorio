package com.perficient.consultorio.repository;

import com.perficient.consultorio.entitis.Medico;
import com.perficient.consultorio.dto.MedicoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMedicoRepositoryJpa {

    List<Medico> buscarMedicoPorNombresDocumento(MedicoDto medicoDto);
}
