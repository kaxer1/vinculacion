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

import com.core.arnuv.model.Usuariosession;
import com.core.arnuv.service.IUsuarioSesionService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/usuario-sesion")
@TableGenerator(name = "UsuarioSesion")
public class UsuarioSesionController {
	
	@Autowired
	private IUsuarioSesionService servicioUsuarioSesion;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuariosession>> getUsuariosSesion() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioUsuarioSesion.listarTodosUsuariosSesion();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearUsuarioSesion(@RequestBody Usuariosession sesion) {
		Object entity;
		try {
			entity = servicioUsuarioSesion.insertarUsuarioSesion(sesion);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarUsuarioSesion(@RequestBody Usuariosession sesion) {
		Object entity;
		try {
			entity = servicioUsuarioSesion.actualizarUsuarioSesion(sesion);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarUsuarioSesionPorId(@PathVariable int id) {
		Object entity;
		try {
			entity = servicioUsuarioSesion.buscarPorId(id);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
