package com.core.arnuv.service;

import com.core.arnuv.model.Usuariodetalle;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUsuarioDetalleService {

	List<Usuariodetalle> listarTodosUsuariosDetalle();

	public Usuariodetalle insertarUsuarioDetalle(Usuariodetalle data);

	public Usuariodetalle actualizarUsuarioDetalle(Usuariodetalle data);

	public Usuariodetalle buscarPorId(int id);

	public Usuariodetalle buscarPorUsuario(String username);

	UserDetailsService userDetailsService();
}
