package com.autobots.sistema.models.hateoas;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.controller.EnderecoController;
import com.autobots.sistema.entities.Endereco;

@Component
public class EnderecoHateoas implements HateaosModel<Endereco> {
    

    @Override
    public void addLinkLista(List<Endereco> lista){
        for(Endereco endereco : lista){
            Long id = endereco.getId();
            Link linkGetAll = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(EnderecoController.class)
                .pegarEndereco(id))
                .withSelfRel();
                endereco.add(linkGetAll);
        }
    }

    @Override
    public void addLink(Endereco endereco){
        Link linkGetOne = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(EnderecoController.class)
                .pegarEnderecos())
                .withSelfRel();
                endereco.add(linkGetOne);
    }
    
}
