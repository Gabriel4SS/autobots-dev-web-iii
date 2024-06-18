package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Telefone;
import com.autobots.sistema.services.TelefoneService;


/*
 *                Dúvidas
 * Porque não funciona?:
 * public Telefone pegarUms(@PathVariable Long id){
        List<Telefone> telefones = telefoneRepository.findAll();
        for(Telefone telefoneABuscar : telefones){
            if(telefoneABuscar.getId() == id){
                Telefone telefoneBuscado = telefoneABuscar;
                return telefoneABuscar;
            }

            return telefoneABuscar; 

        };
        return telefoneABuscar;
    }

    Arquivos de "suporte" como o clienteAtualizador e selecionador devem ficar em qual pasta, models??

    getReferenceById retorna um proxy, oq isso significa?
 * 
 */


@RestController
@RequestMapping("/telefone")
public class TelefoneController {
    
    @Autowired
    private TelefoneService telefoneService;

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @GetMapping("/todos")
    public List<Telefone> pegarTelefones(){
        return telefoneService.pegarTodos();
    };

    @PreAuthorize("hasAnyRole('CLIENTE', 'VENDEDOR', 'GERENTE' 'ADMINISTRADOR')")
    @GetMapping("/pegar/{id}")
    public Telefone pegarTelefone(@PathVariable Long id){
        return telefoneService.pegarUm(id);
    }

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PostMapping("/cadastrar")
    public Telefone cadastrarTelefone(@RequestBody Telefone telefone){
        telefoneService.criarTelefone(telefone);
        return telefone;
    }

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PutMapping("/alterar")
    public Telefone alterarTelefone(@RequestBody Telefone telefone){
        telefoneService.atualizandoTelefone(telefone);
        return telefone;
    }

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @DeleteMapping("/deletar")
    public void deletarTelefone(@RequestBody Telefone deletarTel){
        telefoneService.deletandoTelefone(deletarTel);
    }
}
