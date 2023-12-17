package com.core.arnuv.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.NumericBooleanConverter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase entity de Catalogo de JPA
 */
@Entity
@Data
public class Catalogo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCatalogo;
	
	@Column(length = 100)
	private String nombre;
	
	@Convert(converter = NumericBooleanConverter.class)
	private Boolean activo;

	@OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<CatalogoDetalle> lcatalogoDetalle = new ArrayList<>();
}
