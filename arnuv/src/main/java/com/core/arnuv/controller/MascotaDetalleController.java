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

import com.core.arnuv.model.MascotaDetalle;
import com.core.arnuv.service.IMascotaDetalleService;

import jakarta.persistence.TableGenerator;

@RestController
@Validated
@RequestMapping("/mascotas")
@TableGenerator(name = "Mascota")
public class MascotaDetalleController {

	@Autowired
	private IMascotaDetalleService servicioMascota;

	@GetMapping("/listar")
	public ResponseEntity<List<MascotaDetalle>> listarMascotaDetalle() throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("token", "kldjsfdsfjlksdj");
		var aux = this.servicioMascota.listarMascotasDetalle();
		return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<?> crearCatalogo(@RequestBody MascotaDetalle data) {
		Object entity;
		try {
			entity = servicioMascota.insertarMascotaDetalle(data);
		} catch (Exception e) {
			entity = e.getMessage();
		}
		return new ResponseEntity<>(entity, HttpStatus.OK);
	}
}
