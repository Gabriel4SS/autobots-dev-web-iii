package com.autobots.sistema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.autobots.sistema.entities.Endereco;
import com.autobots.sistema.models.AtualizarEndereco;
import com.autobots.sistema.models.hateoas.EnderecoHateoas;
import com.autobots.sistema.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private AtualizarEndereco atualizarEndereco;

    @Autowired
    private EnderecoHateoas enderecoHateoas;

    public List<Endereco> pegarTodos(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        enderecoHateoas.addLinkLista(enderecos);
        return enderecos;
    }

    public Endereco pegarUm(@PathVariable Long id){
        List<Endereco> enderecos = enderecoRepository.findAll();
        Endereco enderecoBuscado = null;
        for(Endereco enderecoABuscar : enderecos){
            if(enderecoABuscar.getId() == id){
                return enderecoABuscar;
            }

            return enderecoBuscado = enderecoABuscar;

        };
        enderecoHateoas.addLink(enderecoBuscado);
        return enderecoBuscado;
    }

    public Endereco atualizandoEndereco(@RequestBody Endereco novoEndereco){
        Endereco endereco = enderecoRepository.getReferenceById(novoEndereco.getId());
        atualizarEndereco.atualizar(endereco, novoEndereco);
        enderecoRepository.save(endereco);
        return endereco;
    }

    public void deletandoEndereco(@RequestBody Endereco deletando){
        Endereco endereco = enderecoRepository.getReferenceById(deletando.getId());
        enderecoRepository.delete(endereco);
    }
}
