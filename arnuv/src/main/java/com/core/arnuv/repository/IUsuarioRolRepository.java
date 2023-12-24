package com.core.arnuv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.arnuv.model.Usuariorol;

@Repository
public interface IUsuarioRolRepository extends JpaRepository<Usuariorol, Integer> {

}
