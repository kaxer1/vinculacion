package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.util.List;

@Data
@Comment("Tabla que almacena roles de usuario")
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @Comment("Codigo de rol")
    @Column(name = "idrol", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("Codigo de politica")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idpolitica")
    private Seguridadpolitica idpolitica;

    @Comment("Nombre del rol")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Comment("Campo para el menu y transaccion activos")
    @Column(name = "activo", precision = 1)
    private BigDecimal activo;

    @OneToMany(mappedBy = "idrol")
    private List<Opcionespermiso> opcionespermisos;

    @OneToMany(mappedBy = "idrol")
    private List<Usuariorol> usuariorols;

}
