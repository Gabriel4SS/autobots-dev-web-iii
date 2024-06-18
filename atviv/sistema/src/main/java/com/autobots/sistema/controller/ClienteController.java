package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Cliente;
import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.models.AtualizarCliente;
import com.autobots.sistema.models.SelecionarCliente;
import com.autobots.sistema.models.hateoas.ClienteHateaos;
import com.autobots.sistema.repositories.ClienteRepository;
import com.autobots.sistema.repositories.UsuarioRepository;
import com.autobots.sistema.services.ClienteService;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SelecionarCliente selecionarCliente;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteHateaos clienteHateaos;


    // DÚVIDAS
    /*
     *      Qual a diferença de usar o save e saveAndFlush na prática (na teoria eu já sei)
     *      As propriedades do objeto cliente que são classes, exemplo: Documento e etc, quando enviadas pelo body
     * da requisição mesmo que a estrutura delas estaja correta elas aparecem como nulas ou listas vazias, pq 
     * e como mudar?
     *      Na classe atualizarTelefone o que signifaca aqueles ifs (if"!" não oq??), e oq é aquela estrutura de 
     * for, tem um nome especifico?
     *      Na classe strigNullVerificador como funciona aqueles ifs? (pq 1 é: if(!(...)) e o outro é if(!...))
     */


    /*@GetMapping("/obter")
    public List<Cliente> puxarCLientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }*/

    @GetMapping("/obter")
    public List<Cliente> pegarClientes(){
        List<Cliente> todosClientes = clienteService.pegarTodosClientes();
        clienteHateaos.addLinkLista(todosClientes);
        return todosClientes;
    }

    // @GetMapping("/gerarUser")
    // public void gerarUser(){
    //      Usuario user = new Usuario();
    //      user.setUserEmail("user@gmail.com");
    //      user.setSenha(new BCryptPasswordEncoder().encode("senha"));
    //      usuarioRepository.save(user);
        
    // }
    
    /*@GetMapping("/obter/{id}")
    public Cliente obterCliente(@PathVariable Long id){
        List<Cliente> clientes = clienteRepository.findAll();
        return selecionarCliente.selecionar(clientes, id);
    }*/


    @GetMapping("/obter/{id}")
    public Cliente obterCliente(@PathVariable Long id){
        Cliente cliente = clienteService.pegarClientePorId(id);
        clienteHateaos.addLink(cliente);
        return cliente; 
    }

    @PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Cliente cliente){
        clienteService.cadastrarCliente(cliente);
    }

    /*@PostMapping("/cadastrar")
    public void cadastrar(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }*/

    /*@PutMapping("/alterar")
    public void atualizarCliente(@RequestBody Cliente newCliente){
        Cliente cliente = clienteRepository.getReferenceById(newCliente.getId());
        AtualizarCliente atualizarCliente = new AtualizarCliente();
        atualizarCliente.atualizar(cliente, newCliente);
        clienteRepository.save(cliente);
    }*/

    @PutMapping("/alterar")
    public void atualizarCliente(@RequestBody Cliente novoCliente){
        clienteService.atualizarCliente(novoCliente);
    }

    /*@DeleteMapping("/deletar")
    public void excluirCliente(@RequestBody Cliente excluir){
        Cliente cliente = clienteRepository.getReferenceById(excluir.getId());
        clienteRepository.delete(cliente);
    }*/

    @DeleteMapping("/deletar")
    public void excluirCliente(@RequestBody Cliente excluir){
        clienteService.deletarCliente(excluir);
    }
}
