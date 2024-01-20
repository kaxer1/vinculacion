package com.core.arnuv.services.imp;

import com.core.arnuv.model.Usuariodetalle;
import com.core.arnuv.repository.IUsuarioDetalleRepository;
import com.core.arnuv.service.IUsuarioDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UsuarioDetalleServiceImp implements IUsuarioDetalleService {

	@Autowired
	private IUsuarioDetalleRepository repo;

	@Override
	public List<Usuariodetalle> listarTodosUsuariosDetalle() {
		return repo.findAll();
	}

	@Override
	public Usuariodetalle insertarUsuarioDetalle(Usuariodetalle data) {
		return repo.save(data);
	}

	@Override
	public Usuariodetalle actualizarUsuarioDetalle(Usuariodetalle data) {
		Usuariodetalle existeUsuarioDetalle = repo.findById(data.getIdusuario()).orElse(null);
		existeUsuarioDetalle.setIdpersona(data.getIdpersona());
		existeUsuarioDetalle.setIdusuarioing(data.getIdusuarioing());
		existeUsuarioDetalle.setIdusuariomod(data.getIdusuariomod());
		existeUsuarioDetalle.setIdusuarioaprobacion(data.getIdusuarioaprobacion());
		existeUsuarioDetalle.setFechaingreso(data.getFechaingreso());
		existeUsuarioDetalle.setFechamodificacion(data.getFechamodificacion());
		existeUsuarioDetalle.setFechaaprobacion(data.getFechaaprobacion());
		existeUsuarioDetalle.setEstado(data.getEstado());
		existeUsuarioDetalle.setPassword(data.getPassword());
		existeUsuarioDetalle.setCambiopassword(data.getCambiopassword());
		existeUsuarioDetalle.setObservacion(data.getObservacion());
		return repo.save(existeUsuarioDetalle);
	}

	@Override
	public Usuariodetalle buscarPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Usuariodetalle buscarPorUsuario(String username) {
		return repo.buscarPorUsuario(username);
	}
}
