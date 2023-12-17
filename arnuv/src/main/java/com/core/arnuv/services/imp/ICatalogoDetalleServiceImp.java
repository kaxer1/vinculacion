package com.core.arnuv.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.core.arnuv.model.CatalogoDetalle;
import com.core.arnuv.repository.ICatalogoDetalleRepository;
import com.core.arnuv.service.ICatalogoDetalleService;

@Service
@Component
public class ICatalogoDetalleServiceImp implements ICatalogoDetalleService {
	
	@Autowired
	private ICatalogoDetalleRepository repo;

	@Override
	public List<CatalogoDetalle> listarPorCatalogo(int idCatalogo) {
		return repo.buscarPorIdCatalogo(idCatalogo);
	}



	

}
