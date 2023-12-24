package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.Usuariorol;

public interface IUsuarioRolService {

	List<Usuariorol> listarTodosUsuariosRol();

	public Usuariorol insertarUsuarioRol(Usuariorol data);

	public Usuariorol buscarPorId(int id);
}
