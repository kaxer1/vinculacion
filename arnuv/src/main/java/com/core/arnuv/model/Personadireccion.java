package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Comment("Tabla que almacena las riecciones de la persona")
@Entity
@Table(name = "personadireccion")
public class Personadireccion {
    @EmbeddedId
    private PersonadireccionId id;

    @MapsId("idpersona")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Comment("Codigo de personas")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idpersona", nullable = false)
    private Personadetalle idpersona;

    @Comment("Codigo de usuario de ingreso.")
    @Column(name = "idusuarioing", length = 20)
    private String idusuarioing;

    @Comment("Codigo de usuario de modificacion")
    @Column(name = "idusuariomod", length = 20)
    private String idusuariomod;

    @Comment("Fecha de ingreso del registro")
    @Column(name = "fechaingreso")
    private Instant fechaingreso;

    @Comment("Fecha de modificacion del registro")
    @Column(name = "fechamodificacion")
    private Instant fechamodificacion;

    @Comment("Nombre del barrio")
    @Column(name = "barrio", length = 120)
    private String barrio;

    @Comment("Nombre de la direccion con calles y avenidas")
    @Column(name = "direccion", length = 254)
    private String direccion;

    @Comment("Referencia de la direccion")
    @Column(name = "referencia", length = 254)
    private String referencia;

    @Comment("Si la direccion es principal")
    @Column(name = "principal", precision = 1)
    private BigDecimal principal;

}
