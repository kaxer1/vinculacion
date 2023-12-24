package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.Usuariodetalle;

public interface IUsuarioDetalleService {

	List<Usuariodetalle> listarTodosUsuariosDetalle();

	public Usuariodetalle insertarUsuarioDetalle(Usuariodetalle data);

	public Usuariodetalle actualizarUsuarioDetalle(Usuariodetalle data);

	public Usuariodetalle buscarPorId(int id);
}
