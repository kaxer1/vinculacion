package com.core.arnuv.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.core.arnuv.model.Catalogo;
import com.core.arnuv.repository.ICatalogoRepository;
import com.core.arnuv.service.ICatalogoService;

@Service
@Component
public class ICatalogoServiceImp implements ICatalogoService {
	
	@Autowired
	private ICatalogoRepository repo;

	@Override
	public List<Catalogo> listarCatalogosActivos() {
		return repo.buscarPorEstado(true);
	}

	@Override
	public List<Catalogo> listarCatalogosInactivos() {
		return repo.buscarPorEstado(false);
	}

	@Override
	public List<Catalogo> listarTodosCatalogos() {
		return repo.findAll();
	}


}
