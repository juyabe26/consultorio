package com.perficient.consultorio.repository.impl;

import com.perficient.consultorio.entitis.Medicamento;
import com.perficient.consultorio.repository.IMedicamentoRepositoryJpa;
import com.perficient.consultorio.dto.MedicamentoDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Repository
public class MedicamentoRepository implements IMedicamentoRepositoryJpa {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public List<Medicamento> buscarMedicamento(MedicamentoDto medicamentoDto) {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Medicamento> cq = cb.createQuery(Medicamento.class);
        final Root<Medicamento> root = cq.from(Medicamento.class);
        List<Predicate> predicates = new ArrayList<>();

        if (Objects.isNull(medicamentoDto.getCodigo())) {
            predicates.add(cb.and(cb.equal(root.get("codigo"), medicamentoDto.getCodigo())));
        }
        if (Objects.isNull(medicamentoDto.getNombreGenerico())) {
            predicates.add(cb.and(cb.equal(root.get("nombreGenerico"), medicamentoDto.getNombreGenerico())));
        }
        if (Objects.isNull(medicamentoDto.getNombreComercial())) {
            predicates.add(cb.and(cb.equal(root.get("nombreComercial"), medicamentoDto.getNombreComercial())));
        }
        if (Objects.isNull(medicamentoDto.getLaboratorio())) {
            predicates.add(cb.and(cb.equal(root.get("laboratorio"), medicamentoDto.getLaboratorio())));
        }

        if (Objects.isNull(medicamentoDto.getMarca())) {
            predicates.add(cb.and(cb.equal(root.get("marca"), medicamentoDto.getMarca())));
        }

        cq.select(root).where(predicates.toArray(new Predicate[]{}));
        final TypedQuery<Medicamento> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
