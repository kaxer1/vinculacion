package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Usuariodetalle;
import com.core.arnuv.request.UsuarioDetalleRequest;
import com.core.arnuv.response.UsuarioDetalleResponse;
import com.core.arnuv.service.IPersonaDetalleService;
import com.core.arnuv.service.IUsuarioDetalleService;
import com.core.arnuv.utils.ArnuvNotFoundException;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioDetalleController {

	@Autowired
	private IUsuarioDetalleService servicioUsuarioDetalle;

	@Autowired
	private IPersonaDetalleService servicioPersonaDetalle;

	@Autowired
	private JwtServiceImpl serviceJwt;
	
	@GetMapping("/listar")
	public ResponseEntity<RespuestaComun> getUsuariosDetalle() throws Exception {
		var entity = servicioUsuarioDetalle.listarTodosUsuariosDetalle();
		UsuarioDetalleResponse resp = new UsuarioDetalleResponse();
		resp.setListaDto(entity, UsuarioDetalleResponse.UsuarioDetalleDto.class,  "usuariorols","idpersona");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<RespuestaComun> crearUsuarioDetalle(@RequestBody UsuarioDetalleRequest usuario) throws Exception {
		var personaentity = servicioPersonaDetalle.buscarPorId(usuario.getIdpersona());
		Usuariodetalle usuariodetalle = usuario.mapearDato(usuario, Usuariodetalle.class);
		usuariodetalle.setIdpersona(personaentity);
		Usuariodetalle entity = null;
		try {
			entity = servicioUsuarioDetalle.insertarUsuarioDetalle(usuariodetalle);
		} catch (DataIntegrityViolationException e) {
			throw new ArnuvNotFoundException("Error al guardar datos: {0}", e.getMessage().split("Detail:")[1].split("]")[0]);
		}
		UsuarioDetalleResponse resp = new UsuarioDetalleResponse();
		resp.mapearDato(entity, UsuarioDetalleResponse.UsuarioDetalleDto.class,  "usuariorols","idpersona");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<RespuestaComun> actualizarUsuarioDetalle(@RequestBody UsuarioDetalleRequest usuario) throws Exception {
		var personaentity = servicioPersonaDetalle.buscarPorId(usuario.getIdpersona());
		Usuariodetalle usuariodetalle = usuario.mapearDato(usuario, Usuariodetalle.class);
		usuariodetalle.setIdpersona(personaentity);
		Usuariodetalle entity = null;
		try {
			entity = servicioUsuarioDetalle.actualizarUsuarioDetalle(usuariodetalle);
		} catch (DataIntegrityViolationException e) {
			throw new ArnuvNotFoundException("Error al guardar datos: {0}", e.getMessage().split("Detail:")[1].split("]")[0]);
		}
		UsuarioDetalleResponse resp = new UsuarioDetalleResponse();
		resp.mapearDato(entity, UsuarioDetalleResponse.UsuarioDetalleDto.class,  "usuariorols","idpersona");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<RespuestaComun> buscarCatalogoPorId(@PathVariable int id) throws Exception {
		var entity = servicioUsuarioDetalle.buscarPorId(id);
		UsuarioDetalleResponse resp = new UsuarioDetalleResponse();
		resp.mapearDato(entity, UsuarioDetalleResponse.UsuarioDetalleDto.class,  "usuariorols","idpersona");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}

	@GetMapping("/validar/{username}")
	public ResponseEntity<RespuestaComun> buscarPorUserName(@PathVariable String username) throws Exception {
		var entity = servicioUsuarioDetalle.buscarPorEmail(username);
		if (entity == null) {
			throw new ArnuvNotFoundException("El usuario {0} no existe", username);
		}
		UsuarioDetalleResponse resp = new UsuarioDetalleResponse();
		resp.mapearDato(entity, UsuarioDetalleResponse.UsuarioDetalleDto.class,  "usuariorols","idpersona");
		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
