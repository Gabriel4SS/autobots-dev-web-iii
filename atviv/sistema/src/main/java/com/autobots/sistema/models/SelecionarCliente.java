package com.autobots.sistema.models;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.sistema.entities.Cliente;

@Component
public class SelecionarCliente {
    
    public Cliente selecionar(List<Cliente> clientes, long id) {
		
        Cliente selecionado = null;
		
        for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				selecionado = cliente;
			}
		}

		return selecionado;
	}
}