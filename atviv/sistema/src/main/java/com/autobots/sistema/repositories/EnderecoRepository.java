package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
