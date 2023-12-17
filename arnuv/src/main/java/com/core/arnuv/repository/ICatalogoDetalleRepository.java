package com.core.arnuv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.core.arnuv.model.CatalogoDetalle;
import com.core.arnuv.model.CatalogoDetallePk;

public interface ICatalogoDetalleRepository extends JpaRepository<CatalogoDetalle, CatalogoDetallePk> {

	@Query("Select t from CatalogoDetalle t where t.pk.idCatalogo= ?1")
	List<CatalogoDetalle> buscarPorIdCatalogo(int idCatalogo);
	
}
