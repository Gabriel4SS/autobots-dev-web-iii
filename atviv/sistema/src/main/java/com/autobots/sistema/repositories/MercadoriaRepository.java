package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Mercadoria;

public interface MercadoriaRepository extends  JpaRepository<Mercadoria, Long>{
    
}
