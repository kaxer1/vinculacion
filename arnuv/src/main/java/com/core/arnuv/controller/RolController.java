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

import com.core.arnuv.model.Rol;
import com.core.arnuv.service.IRolService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/roles")
@TableGenerator(name = "Rol")
public class RolController {

	@Autowired
	private IRolService servicioRol;

	@GetMapping("/listar")
	public ResponseEntity<List<Rol>> getRoles() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioRol.listarTodosRoles();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearRol(@RequestBody Rol rol) {
		Object entity;
		try {
			entity = servicioRol.insertarRol(rol);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarRol(@RequestBody Rol rol) {
		Object entity;
		try {
			entity = servicioRol.actualizarRol(rol);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarRolPorId(@PathVariable int id) {
		Object entity;
		try {
			entity = servicioRol.buscarPorId(id);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
