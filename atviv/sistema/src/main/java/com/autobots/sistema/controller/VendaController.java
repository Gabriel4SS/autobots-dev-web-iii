package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.entities.Venda;
import com.autobots.sistema.repositories.UsuarioRepository;
import com.autobots.sistema.repositories.VendaRepository;

@RestController
@RequestMapping("/venda")
public class VendaController {
    
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE' 'ADMINISTRADOR')")
    @GetMapping("/vendas")
    public List<Venda> listar(){
        return vendaRepository.findAll();
    }

    @PreAuthorize("hasAnyRole('CLIENTE', 'VENDEDOR', 'GERENTE' 'ADMINISTRADOR')")
    @GetMapping("/{id}")
    public List<Venda> listarVendasUser(@PathVariable Long id){
       Usuario user = usuarioRepository.getReferenceById(id);
       List<Venda> vendasDoUser = user.getVendas();
       return vendasDoUser;
        
    }
}
