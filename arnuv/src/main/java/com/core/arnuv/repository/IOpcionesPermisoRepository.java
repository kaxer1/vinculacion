package com.core.arnuv.repository;

import com.core.arnuv.model.Opcionespermiso;
import com.core.arnuv.model.OpcionespermisoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOpcionesPermisoRepository extends JpaRepository<Opcionespermiso, OpcionespermisoId> {

}
