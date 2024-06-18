package com.autobots.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.sistema.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{
}
