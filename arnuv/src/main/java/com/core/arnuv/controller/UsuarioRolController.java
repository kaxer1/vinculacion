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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.arnuv.model.Usuariorol;
import com.core.arnuv.service.IUsuarioRolService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("usuario-rol")
@TableGenerator(name = "UsuarioRol")
public class UsuarioRolController {
	@Autowired
	private IUsuarioRolService servicioUsuarioRol;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuariorol>> getUsuariosRol() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioUsuarioRol.listarTodosUsuariosRol();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearUsuarioRol(@RequestBody Usuariorol usuarioRol) {
		Object entity;
		try {
			entity = servicioUsuarioRol.insertarUsuarioRol(usuarioRol);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarUsuarioRolPorId(@PathVariable int id) {
		Object entity;
		try {
			entity = servicioUsuarioRol.buscarPorId(id);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
