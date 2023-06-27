package com.perficient.consultorio.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.perficient.consultorio.model.Medico;
import com.perficient.consultorio.web.dto.MedicoDto;
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
public class MedicoRepositoryImpl implements MedicoRepositoryJpa{

    @PersistenceContext
    protected EntityManager entityManager;
    @Override
    public List<Medico> buscarMedicoPorNombresDocumento(MedicoDto medicoDto) {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Medico> cq = cb.createQuery(Medico.class);
        final Root<Medico> root = cq.from(Medico.class);
        List<Predicate> predicates = new ArrayList<>();

       /* if(Objects.isNull(medicoDto.getNumerodocumento())){
            predicates.add(cb.and(cb.equal(root.get("numerodocumento"), medicoDto.getNumerodocumento())));
        }*/
        if(Objects.isNull(medicoDto.getPrimerNombre())){
            predicates.add(cb.and(cb.equal(root.get("primerNombre"), medicoDto.getPrimerNombre())));
        }
        if(Objects.isNull(medicoDto.getSegundoNombre())){
            predicates.add(cb.and(cb.equal(root.get("segundoNombre"), medicoDto.getSegundoNombre())));
        }
        if(Objects.isNull(medicoDto.getPrimerApellido())){
            predicates.add(cb.and(cb.equal(root.get("primerApellido"), medicoDto.getPrimerApellido())));
        }
        if(Objects.isNull(medicoDto.getSegundoApellido())){
            predicates.add(cb.and(cb.equal(root.get("segundoApellido"), medicoDto.getSegundoApellido())));
        }
        cq.select(root).where(predicates.toArray(new Predicate[]{}));
        final TypedQuery<Medico> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
