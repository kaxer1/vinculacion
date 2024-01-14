package com.core.arnuv.repository;

import com.core.arnuv.model.Recurso;
import com.core.arnuv.model.RecursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecursoRepository extends JpaRepository<Recurso, RecursoId> {

}
