package com.core.arnuv.repository;

import com.core.arnuv.model.Usuariodetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDetalleRepository extends JpaRepository<Usuariodetalle, Integer> {

    @Query("Select t from Usuariodetalle t where t.username= ?1 and t.password= ?2")
    public Usuariodetalle buscarPorCredenciales(String username, String password);

}
