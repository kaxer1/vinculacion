package com.core.arnuv.controller.rest;

import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Personadetalle;
import com.core.arnuv.model.Usuariodetalle;
import com.core.arnuv.model.Usuariorol;
import com.core.arnuv.request.UsuarioDetalleRequest;
import com.core.arnuv.request.UsuarioUnificadoRequest;
import com.core.arnuv.response.BaseResponse;
import com.core.arnuv.response.UsuarioDetalleResponse;
import com.core.arnuv.service.*;
import com.core.arnuv.utils.ArnuvNotFoundException;
import com.core.arnuv.utils.RespuestaComun;
import com.core.arnuv.utils.helper.UsuarioUnificadoHelper;
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
	private ICatalogoDetalleService servicioCatalogoDetalle;

	@Autowired
	private IRolService servicioRol;

	@Autowired
	private IUsuarioRolService servicioUsuarioRol;

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

	@PostMapping("/crear-persona-usuario")
	public ResponseEntity<RespuestaComun> crearUsuarioCompleto(@RequestBody UsuarioUnificadoRequest request) throws Exception {
		var data = serviceJwt.extraerTokenData();
		var catDetEntity = servicioCatalogoDetalle.buscarPorId(request.getIdcatalogoidentificacion(), request.getIddetalleidentificacion());
		var rolEntity = servicioRol.buscarPorId(request.getIdrol());
		try {
			Personadetalle personadetalle = UsuarioUnificadoHelper.crearPersonaDetalle(request, catDetEntity, (int) data.get("idusuario"));
			Personadetalle entityPersonaDetalle = servicioPersonaDetalle.insertarPersonaDetalle(personadetalle);

			Usuariodetalle usuariodetalle = UsuarioUnificadoHelper.crearUsuarioDetalle(request, entityPersonaDetalle, (int) data.get("idusuario"));
			Usuariodetalle entityUsuarioDetalle = servicioUsuarioDetalle.insertarUsuarioDetalle(usuariodetalle);

			Usuariorol usuariorol = UsuarioUnificadoHelper.crearUsuarioRol(request, entityUsuarioDetalle, rolEntity, (int) data.get("idusuario"));
			servicioUsuarioRol.insertarUsuarioRol(usuariorol);

		} catch (DataIntegrityViolationException e) {
			throw new ArnuvNotFoundException("Error al guardar datos: {0}", e.getMessage().split("Detail:")[1].split("]")[0]);
		} catch (Exception e) {
			throw new ArnuvNotFoundException("Error al guardar datos: {0}", e.getMessage());
		}
		BaseResponse resp = new BaseResponse();
		resp.setCodigo("OK");

		return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
	}
}
