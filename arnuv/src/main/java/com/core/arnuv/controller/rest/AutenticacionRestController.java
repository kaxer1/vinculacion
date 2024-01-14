package com.core.arnuv.controller.rest;

import com.core.arnuv.request.LoginRequest;
import com.core.arnuv.response.BaseResponse;
import com.core.arnuv.service.IUsuarioDetalleService;
import com.core.arnuv.utils.ArnuvNotFoundException;
import com.core.arnuv.utils.ArnuvUtils;
import com.core.arnuv.utils.RespuestaComun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autenticacion")
public class AutenticacionRestController {

    @Autowired
    private IUsuarioDetalleService serviceUsuarioDetalle;

    @PostMapping("/login")
    public ResponseEntity<RespuestaComun> validarLogin(@RequestBody LoginRequest login) throws Exception {
        var entity = serviceUsuarioDetalle.buscarPorCredenciales(login.getUsername(), login.getPassword());
        BaseResponse resp = new BaseResponse();
        if (entity == null) {
            throw new ArnuvNotFoundException("Credenciales del usuario no existe {0}",login.getUsername());
        } else {
            resp.setCodigo("OK");
            resp.setMensaje("LOGIN APROBADO");
        }
        return new ResponseEntity<>(resp, ArnuvUtils.validaRegeneracionToken(), HttpStatus.OK);
    }

    @PostMapping("/menu")
    public ResponseEntity<RespuestaComun> consultaMenu(@RequestBody LoginRequest login) throws Exception {
        var entity = serviceUsuarioDetalle.buscarPorCredenciales(login.getUsername(), login.getPassword());
        BaseResponse resp = new BaseResponse();
        if (entity == null) {
            throw new ArnuvNotFoundException("Credenciales del usuario no existe");
        } else {
            resp.setCodigo("OK");
            resp.setMensaje("LOGIN APROBADO");
        }
        return new ResponseEntity<>(resp, ArnuvUtils.validaRegeneracionToken(), HttpStatus.OK);
    }
}
