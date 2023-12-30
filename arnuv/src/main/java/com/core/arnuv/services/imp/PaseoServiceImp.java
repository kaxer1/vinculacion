package com.core.arnuv.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.core.arnuv.model.Paseo;
import com.core.arnuv.repository.IPaseoRepository;
import com.core.arnuv.service.IPaseoService;

@Service
@Component
public class PaseoServiceImp implements IPaseoService {

	@Autowired
	private IPaseoRepository repo;

	@Override
	public List<Paseo> listarPaseos() {
		return repo.findAll();
	}

	@Override
	public Paseo insertarPaseo(Paseo data) {
		return repo.save(data);
	}

}
