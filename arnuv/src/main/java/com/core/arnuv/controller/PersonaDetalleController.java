package com.core.arnuv.controller;

import com.core.arnuv.model.Personadetalle;
import com.core.arnuv.request.PersonaDetalleRequest;
import com.core.arnuv.response.PersonaDetalleResponse;
import com.core.arnuv.service.ICatalogoDetalleService;
import com.core.arnuv.service.IPersonaDetalleService;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("personas")
public class PersonaDetalleController {

	@Autowired
	private ICatalogoDetalleService servicioCatalogoDetalle;

	@Autowired
	private IPersonaDetalleService servicioPersonaDetalle;
	
	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> getPersonasDetalle() throws Exception {
		var entity = servicioPersonaDetalle.listarTodosPersonaDetalle();
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.setListaDto(entity, PersonaDetalleResponse.PersonaDetalleDto.class, "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles" );
		return new ResponseEntity<>(resp, ArnuvUtils.validaRegeneracionToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearCatalogo(@RequestBody PersonaDetalleRequest persona) {
		var catDetEntity = servicioCatalogoDetalle.buscarPorId(persona.getIdcatalogoidentificacion(), persona.getIddetalleidentificacion());
		Personadetalle personadetalle = persona.mapearDato(persona, Personadetalle.class, "idcatalogoidentificacion", "iddetalleidentificacion");
		personadetalle.setCatalogodetalle(catDetEntity);
		var entity = servicioPersonaDetalle.insertarPersonaDetalle(personadetalle);
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.mapearDato(entity, PersonaDetalleResponse.PersonaDetalleDto.class,  "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizarCatalogo(@RequestBody PersonaDetalleRequest persona) {
		var entity = servicioPersonaDetalle.actualizarPersonaDetalle(persona.mapearDato(persona, Personadetalle.class));
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.mapearDato(entity, PersonaDetalleResponse.PersonaDetalleDto.class,  "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles");
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarPersonaDetallePorId(@PathVariable int id) {
		var entity = servicioPersonaDetalle.buscarPorId(id);
		PersonaDetalleResponse resp = new PersonaDetalleResponse();
		resp.mapearDato(entity, PersonaDetalleResponse.PersonaDetalleDto.class,  "usuariodetalles", "personadireccions", "paseoscliente", "paseospaseador", "mascotaDetalles");
		return new ResponseEntity<>(resp, ArnuvUtils.validaRegeneracionToken(), HttpStatus.OK);
	}
}
