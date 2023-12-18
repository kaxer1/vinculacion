package com.core.arnuv.service;

import com.core.arnuv.model.CatalogoDetalle;

import java.util.List;

/**
 * Interfaz de metodos que expone el servicio
 */
public interface ICatalogoDetalleService {
	
	public List<CatalogoDetalle> listarPorCatalogo(int idCatalogo);

}
