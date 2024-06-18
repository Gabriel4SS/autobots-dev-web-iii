package com.autobots.sistema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.sistema.entities.Mercadoria;
import com.autobots.sistema.repositories.MercadoriaRepository;

@Service
public class MercadoriaService {
    @Autowired
    private MercadoriaRepository mercadoriaRepository;

    public Mercadoria cadastrar(Mercadoria mercadoria){
        mercadoriaRepository.save(mercadoria);
        return mercadoria;
     }
}
