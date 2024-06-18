package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Empresa;
import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.models.hateoas.EmpresaHateaos;
import com.autobots.sistema.repositories.EmpresaRepository;
import com.autobots.sistema.services.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaHateaos empresaHateaos;

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PostMapping("/create")
    public Empresa cadastrarEmpresa(@RequestBody Empresa empresa){
        empresaService.cadastrar(empresa);
        return empresa;
    }

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PutMapping("/associarUsuario/{idEmpresa}")
    public Empresa associarUsuarioEmpresa(@PathVariable Long idEmpresa, @RequestBody Usuario usuario){
        Empresa empresaAtualizada = empresaService.associar(idEmpresa, usuario);
        return empresaAtualizada;
    }

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @GetMapping("/todas")
    public List<Empresa> trazerTodas(){
        List<Empresa> todasEmpresas = empresaRepository.findAll();
        empresaHateaos.addLinkLista(todasEmpresas);
        return  todasEmpresas;
    }
}
