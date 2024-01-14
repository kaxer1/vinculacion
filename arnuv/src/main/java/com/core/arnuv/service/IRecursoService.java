package com.core.arnuv.service;

import com.core.arnuv.model.Recurso;
import com.core.arnuv.model.RecursoId;

import java.util.List;

/**
 * Interfaz de metodos que expone el servicio
 */
public interface IRecursoService {

	List<Recurso> listarTodos();

	public Recurso insertar(Recurso data);

	public Recurso actualizar(Recurso data);

	public Recurso buscarPorId(RecursoId id);
}
