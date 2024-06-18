package com.autobots.sistema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.sistema.entities.Empresa;
import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.repositories.EmpresaRepository;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa cadastrar(Empresa empresa){
       empresaRepository.save(empresa);
       return empresa;
    }

    public Empresa associar(Long idEmpresa, Usuario usuario){
        Empresa updateEmpresa = empresaRepository.getReferenceById(idEmpresa);
        updateEmpresa.getUsuarios().add(usuario);
        empresaRepository.saveAndFlush(updateEmpresa);
        return updateEmpresa;
    }
}
