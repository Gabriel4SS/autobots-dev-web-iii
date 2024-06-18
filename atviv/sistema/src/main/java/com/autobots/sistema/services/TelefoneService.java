package com.autobots.sistema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.autobots.sistema.entities.Telefone;
import com.autobots.sistema.models.AtualizarTelefone;
import com.autobots.sistema.models.hateoas.TelefoneHateoas;
import com.autobots.sistema.repositories.TelefoneRepository;

@Service
public class TelefoneService {
    
    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private AtualizarTelefone atualizarTelefone;

    @Autowired
    private TelefoneHateoas telefoneHateoas;

    public List<Telefone> pegarTodos(){
        List<Telefone> telefones = telefoneRepository.findAll();
        telefoneHateoas.addLinkLista(telefones);
        return telefones;
    }

    public Telefone pegarUm(@PathVariable Long id){
        List<Telefone> telefones = telefoneRepository.findAll();
        Telefone telefoneBuscado = null;
        for(Telefone telefoneABuscar : telefones){
            if(telefoneABuscar.getId() == id){
                return telefoneABuscar;
            }

            return telefoneBuscado = telefoneABuscar;

        };
        telefoneHateoas.addLink(telefoneBuscado);
        return telefoneBuscado;
    }

    public Telefone criarTelefone(@RequestBody Telefone telefone){
        telefoneRepository.save(telefone);
        return telefone; 
    }

    public Telefone atualizandoTelefone(@RequestBody Telefone novoTelefone){
        Telefone telefone = telefoneRepository.getReferenceById(novoTelefone.getId());
        atualizarTelefone.atualizar(telefone, novoTelefone);
        telefoneRepository.save(telefone);
        return telefone;
    }

    public void deletandoTelefone(@RequestBody Telefone deletando){
        Telefone telefone = telefoneRepository.getReferenceById(deletando.getId());
        telefoneRepository.delete(telefone);
    }

}
