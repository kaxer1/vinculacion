package com.core.arnuv.services.imp;

import com.core.arnuv.model.Opcionespermiso;
import com.core.arnuv.model.OpcionespermisoId;
import com.core.arnuv.repository.IOpcionesPermisoRepository;
import com.core.arnuv.service.IOpcionesPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class OpcionesPermisoServiceImp implements IOpcionesPermisoService {

	@Autowired
	private IOpcionesPermisoRepository repo;

	@Override
	public List<Opcionespermiso> listarTodos() {
		return repo.findAll();
	}

	@Override
	public Opcionespermiso insertar(Opcionespermiso data) {
		return repo.save(data);
	}

	@Override
	public Opcionespermiso actualizar(Opcionespermiso data) {
		Opcionespermiso existe = repo.findById(data.getId()).orElse(null);
		existe.setIdrol(data.getIdrol());
		existe.setIdopcionpadre(data.getIdopcionpadre());
		existe.setRecursos(data.getRecursos());
		existe.setNombre(data.getNombre());
		existe.setActivo(data.getActivo());
		existe.setMostar(data.getMostar());
		existe.setCrear(data.getCrear());
		existe.setEditar(data.getEditar());
		existe.setEliminar(data.getEliminar());

		return repo.save(existe);
	}

	@Override
	public Opcionespermiso buscarPorId(OpcionespermisoId id) {
		return repo.findById(id).orElse(null);
	}
}
