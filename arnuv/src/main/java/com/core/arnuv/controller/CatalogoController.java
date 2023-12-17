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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
@TableGenerator(name = "Catalogo")
public class CatalogoController {
	
	@Autowired
	private ICatalogoService servicioCatalogo;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Catalogo>> getCatalogos() throws Exception {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("token", "kldjsfdsfjlksdj");
        var aux = this.servicioCatalogo.listarTodosCatalogos();
        return new ResponseEntity<>(aux, responseHeaders, HttpStatus.OK);
    }


}
