package com.core.arnuv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.arnuv.model.Modulo;
import com.core.arnuv.service.IModuloService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/modulos")
@TableGenerator(name = "Modulo")
public class ModuloController {

	@Autowired
	private IModuloService servicioModulo;

	@GetMapping("/listar")
	public ResponseEntity<List<Modulo>> listar() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioModulo.listarModulos();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Modulo data) {
		Object entity;
		try {
			entity = servicioModulo.insertarModulo(data);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
