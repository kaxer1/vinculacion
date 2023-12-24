package com.core.arnuv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.arnuv.model.Seguridadpolitica;
import com.core.arnuv.service.ISeguridadPoliticaService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/seguridad-politica")
@TableGenerator(name = "SeguridadPolitica")
public class SeguridadPoliticaController {

	@Autowired
	private ISeguridadPoliticaService servicioSeguridadPolitica;

	@GetMapping("/listar")
	public ResponseEntity<List<Seguridadpolitica>> getSeguridadPolitica() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioSeguridadPolitica.listarSeguridadPoliticas();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearCatalogo(@RequestBody Seguridadpolitica data) {
		Object entity;
		try {
			entity = servicioSeguridadPolitica.insertarSeguridadPolitica(data);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarSeguridadPolitica(@RequestBody Seguridadpolitica data) {
		Object entity;
		try {
			entity = servicioSeguridadPolitica.actualizarSeguridadPolitica(data);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarSeguridadPolitcaPorId(@PathVariable int id) {
		Object entity;
		try {
			entity = servicioSeguridadPolitica.buscarPorId(id);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
