package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.CatalogoDetalle;

/**
 * Interfaz de metodos que expone el servicio
 */
public interface ICatalogoDetalleService {
	
	public List<CatalogoDetalle> listarPorCatalogo(int idCatalogo);

}
