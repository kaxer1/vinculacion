package com.core.arnuv.controller;

import com.core.arnuv.model.Catalogo;
import com.core.arnuv.service.ICatalogoService;
import jakarta.persistence.TableGenerator;
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

import java.util.List;

@RestController
@Validated
@RequestMapping("/catalogos")
@TableGenerator(name = "Catalogo")
public class CatalogoController {

	@Autowired
	private ICatalogoService servicioCatalogo;

	@GetMapping("/listar")
	public ResponseEntity<List<Catalogo>> getCatalogos() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioCatalogo.listarTodosCatalogos();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearCatalogo(@RequestBody Catalogo catalogo) {
		Object entity;
		try {
			entity = servicioCatalogo.insertarCatalogo(catalogo);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizarCatalogo(@RequestBody Catalogo catalogo) {
		Object entity;
		try {
			entity = servicioCatalogo.actualizarCatalogo(catalogo);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarCatalogoPorId(@PathVariable int id) {
		Object entity;
		try {
			entity = servicioCatalogo.buscarPorId(id);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
