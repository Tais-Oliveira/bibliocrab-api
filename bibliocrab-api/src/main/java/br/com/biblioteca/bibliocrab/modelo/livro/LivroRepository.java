package br.com.biblioteca.bibliocrab.modelo.livro;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {

   //Exemplo de uma busca aproximada com ordenação:
   // @Query(value = "SELECT l FROM Livro l WHERE l.titulo like %:titulo% ORDER BY l.titulo")
    //List<Livro> consultarPorTitulo(String titulo);

    Iterable<Livro> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo);

   //Exemplo de uma busca exata como um atributo de relacionamento
  // @Query(value = "SELECT l FROM Livro l WHERE l.genero.id = :idGenero")
  // Iterable<Livro> consultarPorCategoria(Long idGenero);

   //Exemplo de uma busca com mais de um atributo
  // @Query(value = "SELECT l FROM Livro l WHERE l.titulo like %:titulo% AND l.genero.id = :idGenero")
  // Iterable<Livro> consultarPorTituloECategoria(String titulo, Long idGenero);


}
