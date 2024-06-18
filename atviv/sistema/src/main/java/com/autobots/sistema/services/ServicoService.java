package com.autobots.sistema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.sistema.entities.Servico;
import com.autobots.sistema.repositories.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico cadastrar(Servico servico){
        servicoRepository.save(servico);
        return servico;
     }

}
