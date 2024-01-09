package com.core.arnuv.controller;

import java.util.List;

import com.core.arnuv.request.ModuloRequest;
import com.core.arnuv.response.ModuloResponse;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping("/actualizar")
	public ResponseEntity<?> actualizar(@RequestBody ModuloRequest modulo) throws Exception {
		var entity = servicioModulo.actualizarModulo(modulo.mapearDato(modulo, Modulo.class));
		ModuloResponse resp = new ModuloResponse();
		resp.mapearDato(entity, ModuloResponse.ModuloDto.class, "recursos");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarPorId(@PathVariable int id) throws Exception {
		var entity = servicioModulo.buscarPorId(id);
		ModuloResponse resp = new ModuloResponse();
		resp.mapearDato(entity, ModuloResponse.ModuloDto.class,  "recursos");
		return new ResponseEntity<>(resp, ArnuvUtils.validaRegeneracionToken(), HttpStatus.OK);
	}
}
