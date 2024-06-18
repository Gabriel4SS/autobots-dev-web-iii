package com.autobots.sistema.models.hateoas;

import java.util.List;


import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.controller.ClienteController;
import com.autobots.sistema.entities.Cliente;

@Component
public class ClienteHateaos implements HateaosModel<Cliente> {
    

    @Override
    public void addLinkLista(List<Cliente> lista){
        for(Cliente cliente : lista){
            Long id = cliente.getId();
            Link linkGetAll = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(ClienteController.class)
                .obterCliente(id))
                .withSelfRel();
            cliente.add(linkGetAll);
        }
    }

    @Override
    public void addLink(Cliente cliente){
        Link linkGetOne = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(ClienteController.class)
                .pegarClientes())
                .withSelfRel();
            cliente.add(linkGetOne);
    }

   

    
}
