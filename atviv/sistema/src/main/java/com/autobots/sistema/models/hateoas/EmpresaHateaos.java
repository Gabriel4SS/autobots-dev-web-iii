package com.autobots.sistema.models.hateoas;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.controller.EmpresaController;
import com.autobots.sistema.entities.Empresa;

@Component
public class EmpresaHateaos implements HateaosModel<Empresa> {
    

    @Override
    public void addLinkLista(List<Empresa> lista){
        for(Empresa empresa : lista){
            Long id = empresa.getId();
            Link linkGetAll = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(EmpresaController.class)
                .cadastrarEmpresa(empresa))
                .withSelfRel();
            empresa.add(linkGetAll);
        }
    }

    @Override
    public void addLink(Empresa empresa){
        Link linkGetOne = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                .methodOn(EmpresaController.class)
                .trazerTodas())
                .withSelfRel();
            empresa.add(linkGetOne);
    }

    
    
}
