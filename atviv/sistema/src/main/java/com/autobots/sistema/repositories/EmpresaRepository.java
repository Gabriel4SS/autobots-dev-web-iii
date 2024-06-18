package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
}
