package com.autobots.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Mercadoria;
import com.autobots.sistema.services.MercadoriaService;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaController {
    @Autowired
    private MercadoriaService mercadoriaService;

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PostMapping("/create")
    public Mercadoria cadastrarMercadoria(@RequestBody Mercadoria mercadoria){
    mercadoriaService.cadastrar(mercadoria);
    return mercadoria;

}
}
