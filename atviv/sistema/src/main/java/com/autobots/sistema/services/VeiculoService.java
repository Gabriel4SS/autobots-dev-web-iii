package com.autobots.sistema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.sistema.entities.Veiculo;
import com.autobots.sistema.repositories.VeiculoRepository;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo cadastrar(Veiculo veiculo){
        veiculoRepository.save(veiculo);
        return veiculo;
    }
}
