package com.core.arnuv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.core.arnuv.model.Catalogo;

public interface ICatalogoRepository extends JpaRepository<Catalogo, Integer> {

	@Query("Select t from Catalogo t where t.activo= ?1")
	List<Catalogo> buscarPorEstado(Boolean estado);
}
