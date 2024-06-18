package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Documento;
import com.autobots.sistema.services.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    
    @Autowired
    private DocumentoService documentoService;
    
    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @GetMapping("/todos")
    public List<Documento> pegarDocumentos(){
        return documentoService.pegarTodos();
    };

    @PreAuthorize("hasAnyRole('CLIENTE', 'VENDEDOR', 'GERENTE' 'ADMINISTRADOR')")
    @GetMapping("/pegar/{id}")
    public Documento pegarDocumento(@PathVariable Long id){
        return documentoService.pegarUm(id);
    }

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PostMapping("/cadastrar")
    public Documento cadastrarDocumento(@RequestBody Documento documento){
        documentoService.criarDocumento(documento);
        return documento;
    }

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @PutMapping("/alterar")
    public Documento alterarDocumento(@RequestBody Documento documento){
        documentoService.atualizandoDocumento(documento);
        return documento;
    }

    @PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
    @DeleteMapping("/deletar")
    public void deletarDocumento(@RequestBody Documento deletarDoc){
        documentoService.deletandoDocumento(deletarDoc);
    }
}
