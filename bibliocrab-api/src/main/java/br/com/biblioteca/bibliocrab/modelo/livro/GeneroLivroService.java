package br.com.biblioteca.bibliocrab.modelo.livro;
/*
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public class GeneroLivroService {
    
    @Autowired
    private GeneroLivroRepository repository;

    @Transactional
    public GeneroLivro save(GeneroLivro generoLivro) {

        return repository.save(generoLivro);
    }

    public Iterable<GeneroLivro> listarTodos() {
  
        return repository.findAll();
    }
 
    public GeneroLivro obterPorID(Long id) {
 
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, GeneroLivro generoLivroAlterado) {

        GeneroLivro generoLivro = repository.findById(id).get();
        generoLivro.setDescricao(generoLivroAlterado.getDescricao());

        repository.save(generoLivro);
    }

    @Transactional
    public void delete(Long id) {

        GeneroLivro GeneroLivro = repository.findById(id).get();
        repository.delete(GeneroLivro);
    }


}
 */