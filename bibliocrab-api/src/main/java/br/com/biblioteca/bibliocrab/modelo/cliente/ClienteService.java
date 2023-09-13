package br.com.biblioteca.bibliocrab.modelo.cliente;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.bibliocrab.modelo.acesso.UsuarioService;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public Cliente save(Cliente cliente) {

        usuarioService.save(cliente.getUsuario());
        
        return repository.save(cliente);
    }

    public Iterable<Cliente> listarTodos() {
  
        return repository.findAll();
    }
    
    public Cliente obterPorID(Long id) {
 
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Cliente clienteAlterado) {
 
     Cliente cliente = repository.findById(id).get();
     cliente.setNome(clienteAlterado.getNome());
     cliente.setCelular(clienteAlterado.getCelular());
     repository.save(cliente);
   }

    @Transactional
    public void delete(Long id) {

    Cliente cliente = repository.findById(id).get();   
    repository.delete(cliente);
  }


}