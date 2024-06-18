package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    
}
