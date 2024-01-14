package com.core.arnuv.services.imp;

import com.core.arnuv.model.Usuariorol;
import com.core.arnuv.repository.IUsuarioRolRepository;
import com.core.arnuv.service.IUsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UsuarioRolServiceImp implements IUsuarioRolService {

	@Autowired
	private IUsuarioRolRepository repo;

	@Override
	public List<Usuariorol> listarTodosUsuariosRol() {
		return repo.findAll();
	}

	@Override
	public Usuariorol insertarUsuarioRol(Usuariorol data) {
		return repo.save(data);
	}

	@Override
	public Usuariorol buscarPorId(int idrol, int idusuario) {
		return repo.buscarbyid(idrol, idusuario);
	}
}