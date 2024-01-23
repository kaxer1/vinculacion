package com.core.arnuv.controller.rest;

import com.core.arnuv.enums.EnumEstadoSession;
import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Usuariosession;
import com.core.arnuv.model.Usuariosessionhistorial;
import com.core.arnuv.request.LoginRequest;
import com.core.arnuv.response.BaseResponse;
import com.core.arnuv.response.LoginResponse;
import com.core.arnuv.service.IOpcionesPermisoService;
import com.core.arnuv.service.IUsuarioDetalleService;
import com.core.arnuv.service.IUsuarioSesionService;
import com.core.arnuv.utils.ArnuvNotFoundException;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/autenticacion")
public class AutenticacionRestController {

    @Autowired
    private IUsuarioDetalleService serviceUsuarioDetalle;

    @Autowired
    private IUsuarioSesionService servicioSesion;

    @Autowired
    private IOpcionesPermisoService servicioOpciones;

    @Autowired
    private JwtServiceImpl serviceJwt;

    @PostMapping("/login")
    public ResponseEntity<RespuestaComun> validarLogin(HttpServletRequest request, @RequestBody LoginRequest login) throws Exception {
        var entity = serviceUsuarioDetalle.buscarPorUsuario(login.getUsername());
        LoginResponse resp = new LoginResponse();
        if (entity == null) {
            throw new ArnuvNotFoundException("El usuario {0} no existe", login.getUsername());
        } else {
            if (!entity.getPassword().equals(login.getPassword())) {
                throw new ArnuvNotFoundException("Credenciales del usuario no existe");
            }
            if (!entity.getEstado()) {
                throw new ArnuvNotFoundException("El usuario esta deshabilitado");
            }
//            if (entity.getUsuariosession() != null && (entity.getUsuariosession().getActivo() || entity.getUsuariosession().getEstado().equals(EnumEstadoSession.INGRESADO.getCodigo())) ) {
//                throw new ArnuvNotFoundException("El usuario ya tiene una sesion activa desde {0}",entity.getUsuariosession().getFechainicio().toLocaleString());
//            }

            if (entity.getUsuariosession() == null) {
                Usuariosession sesion = new Usuariosession();
                sesion.setEstado(EnumEstadoSession.INGRESADO.getCodigo());
                sesion.setFechainicio(new Date());
                sesion.setActivo(true);
                sesion.setIdsession(login.getSerial());
                sesion.setIptermialremoto("127.1.1.1");
                sesion.setUseragent("Movil");
                sesion.setNumerointentos(1);
                sesion.setUsuariodetalle(entity);
                servicioSesion.insertarUsuarioSesion(sesion);
            } else {
                entity.getUsuariosession().setNumerointentos(0);
                entity.getUsuariosession().setUseragent("Movil");
                entity.getUsuariosession().setIptermialremoto("127.1.1.1");
                servicioSesion.actualizarUsuarioSesion(entity.getUsuariosession());
                Usuariosessionhistorial sesionhistorial = ArnuvUtils.convertirObjeto(entity, Usuariosessionhistorial.class);
//                TODO: guardar el historial
            }

//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(entity.getIdpersona().getEmail(), entity.getPassword()));

            LoginResponse.DataUserDto dto = new LoginResponse.DataUserDto();
            dto.setIdusuario(entity.getIdusuario());
            dto.setIdpersona(entity.getIdpersona().getId());
            dto.setUsername(entity.getUsername());
            var lroles = entity.getUsuariorols();
            if (!lroles.isEmpty()) {
                dto.setIdrol(lroles.get(0).getIdrol().getId());
                dto.setNrol(lroles.get(0).getIdrol().getNombre());
            }
            resp.setDto(dto);
            resp.setCodigo("OK");
            resp.setMensaje("LOGIN APROBADO");
        }
        Map<String, Object> mdatos = new HashMap<>();
        mdatos.put("idusuario",resp.getDto().getIdusuario());
        mdatos.put("idpersona",resp.getDto().getIdpersona());
        mdatos.put("username",resp.getDto().getUsername());
        mdatos.put("idrol",resp.getDto().getIdrol());
        mdatos.put("nrol",resp.getDto().getNrol());
        return new ResponseEntity<>(resp, serviceJwt.generaToken(mdatos, entity), HttpStatus.OK);
    }

    @PostMapping("/menu")
    public ResponseEntity<RespuestaComun> consultaMenu(@RequestBody LoginRequest login) throws Exception {
        var lresultados = servicioOpciones.buscarTitulosMenu(1);
        for (Map<String, Object> titulo : lresultados) {
            if (titulo.get("idopcion") == null) continue;

            Long idopcionpadre = Long.parseLong(titulo.get("idopcion").toString());
            titulo.put("items", servicioOpciones.buscarItemMenu(1, idopcionpadre));
        }

        BaseResponse resp = new BaseResponse();

        resp.setLista(lresultados);

        return new ResponseEntity<>(resp, serviceJwt.regeneraToken(), HttpStatus.OK);
    }
}
