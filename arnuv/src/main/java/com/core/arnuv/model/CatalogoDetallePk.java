package com.core.arnuv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * Clase que contiene los campos de la primary key compuesta de la tabla CatalogoDetalle
 */
@Embeddable
public class CatalogoDetallePk implements Serializable {

	@Column(name = "id_catalogo")
	private int idCatalogo;
	
	@Column(name = "id_detalle", length = 3)
	private String idDetalle;
}
