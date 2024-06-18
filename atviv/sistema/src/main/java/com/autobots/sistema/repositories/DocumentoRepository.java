package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long>{
    
}
