package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.Paseo;

public interface IPaseoService {
	List<Paseo> listarPaseos();

	public Paseo insertarPaseo(Paseo data);
}
