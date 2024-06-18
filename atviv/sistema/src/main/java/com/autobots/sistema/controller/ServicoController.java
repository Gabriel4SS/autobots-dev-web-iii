package com.autobots.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Servico;
import com.autobots.sistema.services.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PostMapping("/create")
    public Servico cadastrarMercadoria(@RequestBody Servico servico){
    servicoService.cadastrar(servico);
    return servico;
    }
}
