package com.autobots.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Veiculo;
import com.autobots.sistema.services.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    
    @Autowired
    private VeiculoService veiculoService;

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PostMapping("/create")
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo){
        veiculoService.cadastrar(veiculo);
        return veiculo;
    }
}
