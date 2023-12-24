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

import com.core.arnuv.model.Personadetalle;
import com.core.arnuv.service.IPersonaDetalleService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("personas")
@TableGenerator(name = "PersonaDetalle")
public class PersonaDetalleController {

	@Autowired
	private IPersonaDetalleService servicioPersonaDetalle;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Personadetalle>> getPersonasDetalle() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioPersonaDetalle.listarTodosPersonaDetalle();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearCatalogo(@RequestBody Personadetalle persona) {
		Object entity;
		try {
			entity = servicioPersonaDetalle.insertarPersonaDetalle(persona);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarCatalogo(@RequestBody Personadetalle persona) {
		Object entity;
		try {
			entity = servicioPersonaDetalle.actualizarPersonaDetalle(persona);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPersonaDetallePorId(@PathVariable int id) {
		Object entity;
		try {
			entity = servicioPersonaDetalle.buscarPorId(id);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
