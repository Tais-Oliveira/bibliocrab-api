package br.com.biblioteca.bibliocrab.modelo.livro;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Transactional
    public Livro save(Livro livro) {
        return repository.save(livro);
    }

    public Iterable<Livro> listarTodos() {
        return repository.findAll();
    }
    
    public Livro obterPorID(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Livro livroAlterado) {
 
     Livro livro = repository.findById(id).get();
     livro.setTitulo(livroAlterado.getTitulo());
     livro.setImagem(livroAlterado.getImagem());
     livro.setAutor(livroAlterado.getAutor());
     livro.setLancamento(livroAlterado.getLancamento());
     livro.setQtdpag(livroAlterado.getQtdpag());
     livro.setSinopse(livroAlterado.getSinopse());

 
     repository.save(livro);
   }

@Transactional
  public void delete(Long id) {

    Livro livro = repository.findById(id).get();   
      repository.delete(livro);
  }


  public Iterable<Livro> filtrar(String titulo /*, Long idGenero */) {

    Iterable<Livro> listaLivros = repository.findAll();

    if (
        (titulo != null && !"".equals(titulo))/*  && (idGenero == null)*/) {    
            listaLivros = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
    } 
    
    /*else if (
        (titulo == null || "".equals(titulo)) &&
        (idGenero != null)) {
            listaLivros = repository.consultarPorCategoria(idGenero); 
    } else if (
       
        (titulo != null && !"".equals(titulo)) &&
        (idGenero != null)) {
            listaLivros = repository.consultarPorTituloECategoria(titulo, idGenero); 
    }
*/
    return listaLivros;
}


}