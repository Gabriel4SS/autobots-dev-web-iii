package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{
    
}
