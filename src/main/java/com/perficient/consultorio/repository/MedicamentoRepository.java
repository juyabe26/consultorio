package com.perficient.consultorio.repository;

import com.perficient.consultorio.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, UUID> {
    @Query("SELECT m FROM Medicamento m WHERE m.codigo = :codigoMedicamento")
    Medicamento buscarPorCodigo(@Param("codigoMedicamento") String codigoMedicamento);
}
