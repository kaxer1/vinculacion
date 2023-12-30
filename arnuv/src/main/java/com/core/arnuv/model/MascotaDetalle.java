package com.core.arnuv.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Comment("Tabla que almacena el detalle de la mascota")
@Entity
@Table(name = "mascotadetalle")
public class MascotaDetalle implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
    @Comment("Codigo de la mascota")
    @Column(name = "idmascota", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("Codigo de personas")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idpersona")
    private Personadetalle idpersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "idcatalogorasa", referencedColumnName = "iddetalle"),
            @JoinColumn(name = "iddetallerasa", referencedColumnName = "idcatalogo")
    })
    @Comment("Codigo de catalogo")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private CatalogoDetalle catalogodetalle;

    @Comment("Nombre de la mascota")
    @Column(name = "nombre", length = 120)
    private String nombre;

    @Comment("Edad de la mascota")
    @Column(name = "edad", precision = 2)
    private Integer edad;

}
