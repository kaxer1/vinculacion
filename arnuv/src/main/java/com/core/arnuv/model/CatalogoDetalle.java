package com.core.arnuv.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.type.NumericBooleanConverter;

import java.io.Serializable;

/**
 * Clase entity de CatalogoDetalle de JPA
 */
@Data
@Entity
public class CatalogoDetalle implements Serializable {

	@EmbeddedId
	private CatalogoDetallePk pk;
	
	@Column(length = 100)
	private String nombre;
	
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean activo;

	@ManyToOne
	@JoinColumn(name = "id_catalogo", insertable = false, updatable = false, nullable = false) // solo sirve de utileria para la relacion
	@MapsId("idCatalogo")
	@JsonBackReference
	@ToString.Exclude
	private Catalogo catalogo;

}
