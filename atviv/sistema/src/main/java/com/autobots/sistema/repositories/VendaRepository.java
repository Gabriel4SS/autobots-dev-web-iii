package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
    
}
