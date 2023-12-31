package com.core.arnuv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.Personadetalle;

@Repository
public interface IPersonaDetalleRepository extends JpaRepository<Personadetalle, Integer> {

}
