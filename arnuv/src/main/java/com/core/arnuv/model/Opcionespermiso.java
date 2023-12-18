package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Data
@Comment("Tabla que almacena los menus de opciones del sistema")
@Entity
@Table(name = "opcionespermisos")
public class Opcionespermiso {
    @EmbeddedId
    private OpcionespermisoId id;

    @MapsId("idrol")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Comment("Codigo de rol")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idrol", nullable = false)
    private Rol idrol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "idrecurso", referencedColumnName = "idrecurso"),
            @JoinColumn(name = "idmodulo", referencedColumnName = "idmodulo")
    })
    @Comment("Codigo de recurso")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Recurso recursos;

    @Comment("Codigo de opcion permiso Padre para manejar en el menu")
    @Column(name = "idopcionpadre", precision = 10)
    private BigDecimal idopcionpadre;

    @Comment("Nombre del item de menu")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Comment("1 Opcion permiso activo, 0 inactivo")
    @Column(name = "activo", precision = 1)
    private BigDecimal activo;

    @Comment("Muestra el menu")
    @Column(name = "mostar", precision = 1)
    private BigDecimal mostar;

    @Comment("Permiso de crear")
    @Column(name = "crear", precision = 1)
    private BigDecimal crear;

    @Comment("Permiso de editar")
    @Column(name = "editar", precision = 1)
    private BigDecimal editar;

    @Comment("Permiso de eliminar")
    @Column(name = "eliminar", precision = 1)
    private BigDecimal eliminar;

}
