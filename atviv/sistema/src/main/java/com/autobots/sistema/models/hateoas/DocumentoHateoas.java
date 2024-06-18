package com.autobots.sistema.models.hateoas;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.controller.DocumentoController;
import com.autobots.sistema.entities.Documento;

@Component
public class DocumentoHateoas implements HateaosModel<Documento> {
    

    @Override
    public void addLinkLista(List<Documento> lista){
        for(Documento documento : lista){
            Long id = documento.getId();
            Link linkGetAll = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(DocumentoController.class)
                .pegarDocumento(id))
                .withSelfRel();
                documento.add(linkGetAll);
        }
    }

    @Override
    public void addLink(Documento documento){
        Link linkGetOne = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(DocumentoController.class)
                .pegarDocumentos())
                .withSelfRel();
            documento.add(linkGetOne);
    }
    
}
