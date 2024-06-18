package com.autobots.sistema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.autobots.sistema.entities.Cliente;
import com.autobots.sistema.models.AtualizarCliente;
import com.autobots.sistema.models.SelecionarCliente;
import com.autobots.sistema.repositories.ClienteRepository;

@Service
public class ClienteService {
    


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SelecionarCliente selecionarCliente;

    //@Autowired
    //private AtualizarCliente atualizarCliente;


    public void cadastrarCliente (@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        
    }

    public List<Cliente> pegarTodosClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente pegarClientePorId(@PathVariable Long id){
        List<Cliente> clientes = clienteRepository.findAll();
        return selecionarCliente.selecionar(clientes, id);
    }

    public void atualizarCliente(@RequestBody Cliente novoCliente){
        Cliente cliente = clienteRepository.getReferenceById(novoCliente.getId());
        AtualizarCliente atualizarCliente = new AtualizarCliente();
        atualizarCliente.atualizar(cliente, novoCliente);
        clienteRepository.save(cliente);
    }

    public void deletarCliente(@RequestBody Cliente deletar){
        Cliente cliente = clienteRepository.getReferenceById(deletar.getId());
        clienteRepository.delete(cliente);
    }
}
