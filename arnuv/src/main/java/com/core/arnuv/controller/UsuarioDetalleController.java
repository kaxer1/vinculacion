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

import com.core.arnuv.model.Usuariodetalle;
import com.core.arnuv.service.IUsuarioDetalleService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/usuarios")
@TableGenerator(name = "UsuariosDetalle")
public class UsuarioDetalleController {

	@Autowired
	private IUsuarioDetalleService servicioUsuarioDetalle;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuariodetalle>> getUsuariosDetalle() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioUsuarioDetalle.listarTodosUsuariosDetalle();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearUsuarioDetalle(@RequestBody Usuariodetalle usuario) {
		Object entity;
		try {
			entity = servicioUsuarioDetalle.insertarUsuarioDetalle(usuario);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarUsuarioDetalle(@RequestBody Usuariodetalle usuario) {
		Object entity;
		try {
			entity = servicioUsuarioDetalle.actualizarUsuarioDetalle(usuario);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarCatalogoPorId(@PathVariable int id) {
		Object entity;
		try {
			entity = servicioUsuarioDetalle.buscarPorId(id);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
