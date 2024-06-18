package com.autobots.sistema.models.hateoas;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public interface HateaosModel<T> {
    public void addLinkLista(List<T> lista);
    public void addLink(T objeto);
 
}
