package com.core.arnuv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.NumericBooleanConverter;

import java.util.List;

@Data
@Comment("Tabla que almacena el detalle de cada catalogos que maneja el sistema")
@Entity
@Table(name = "catalogodetalle")
public class CatalogoDetalle {
    @EmbeddedId
    private CatalogoDetalleId id;

    @MapsId("idcatalogo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Comment("Codigo de catalogo")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "idcatalogo", nullable = false)
    @JsonBackReference
    @ToString.Exclude
    private Catalogo idcatalogo;

    @Comment("Nombre del catalogo")
    @Column(name = "nombre", length = 100)
    private String nombre;

    @Comment("1 catalogo activo, 0 Inactivo")
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean activo;

    @OneToMany(mappedBy = "catalogodetalle")
    @JsonIgnore
    private List<MascotaDetalle> mascotaDetalles;

    @OneToMany(mappedBy = "catalogodetalle")
    @JsonIgnore
    private List<Personadetalle> personadetalles;

}
