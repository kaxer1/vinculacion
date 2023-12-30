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

import com.core.arnuv.model.Tarifario;
import com.core.arnuv.service.ITarifarioService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/tarifarios")
@TableGenerator(name = "Tarifario")
public class TarifarioController {

	@Autowired
	private ITarifarioService servicioTarifario;

	@GetMapping("/listar")
	public ResponseEntity<List<Tarifario>> listar() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioTarifario.listarTarifarios();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Tarifario data) {
		Object entity;
		try {
			entity = servicioTarifario.insertarTarifario(data);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
