package com.autobots.sistema.models.hateoas;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.controller.TelefoneController;
import com.autobots.sistema.entities.Telefone;

@Component
public class TelefoneHateoas implements HateaosModel<Telefone> {
    

    @Override
    public void addLinkLista(List<Telefone> lista){
        for(Telefone telefone : lista){
            Long id = telefone.getId();
            Link linkGetAll = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(TelefoneController.class)
                .pegarTelefone(id))
                .withSelfRel();
            telefone.add(linkGetAll);
        }
    }

    @Override
    public void addLink(Telefone telefone){
        Link linkGetOne = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(TelefoneController.class)
                .pegarTelefones())
                .withSelfRel();
            telefone.add(linkGetOne);
    }
    
}
