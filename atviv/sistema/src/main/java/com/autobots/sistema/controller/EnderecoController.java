package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Endereco;
import com.autobots.sistema.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/todos")
    public List<Endereco> pegarEnderecos(){
        return enderecoService.pegarTodos();
    };

    @GetMapping("/pegar/{id}")
    public Endereco pegarEndereco(@PathVariable Long id){
        return enderecoService.pegarUm(id);
    }

    @PutMapping("/alterar")
    public Endereco alterarEndereco(@RequestBody Endereco endereco){
        enderecoService.atualizandoEndereco(endereco);
        return endereco;
    }

    @DeleteMapping("/deletar")
    public void deletarEndereco(@RequestBody Endereco deletarEnd){
        enderecoService.deletandoEndereco(deletarEnd);
    }
}
