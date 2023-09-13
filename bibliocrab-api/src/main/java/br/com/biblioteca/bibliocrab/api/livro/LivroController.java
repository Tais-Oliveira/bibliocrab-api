package br.com.biblioteca.bibliocrab.api.livro;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.bibliocrab.modelo.livro.Livro;
import br.com.biblioteca.bibliocrab.modelo.livro.LivroService;

@RestController
@CrossOrigin
@RequestMapping("/livro")
public class LivroController {
    
    @Autowired
    private LivroService livroService;

    /*@Autowired
    private GeneroLivroService generoLivroService;*/

   @GetMapping
   public Iterable<Livro> listarTodos() {
       return livroService.listarTodos();
   }

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody @Valid LivroRequest request){
        Livro livroNovo = request.build();

       /*  GeneroLivro gl = generoLivroService.obterPorID(request.getIdGenero());
        livroNovo.setGenero(gl);*/

        Livro livro = livroService.save(livroNovo);
        return new ResponseEntity<Livro>(livro, HttpStatus.CREATED);
  }
  
  @PostMapping("/filtrar")
   public Iterable<Livro> filtrar(
           @RequestParam(value = "titulo", required = false) String titulo)
       /*     @RequestParam(value = "idGenero", required = false) Long idGenero)*/ {

       return livroService.filtrar(titulo/* , idGenero*/);
   }


   @GetMapping("/{id}")
   public Livro obterPorID(@PathVariable Long id) {

       return livroService.obterPorID(id);
   }

  @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

      livroService.delete(id);
      return ResponseEntity.ok().build();
   }


    @PutMapping("/{id}")
   public ResponseEntity<Livro> update(@PathVariable("id") Long id, @RequestBody @Valid LivroRequest request) {

    Livro livro = request.build();
  /*  livro.setGenero(generoLivroService.obterPorID(request.getIdGenero())); */
    livroService.update(id, livro);

    return ResponseEntity.ok().build();
   }

 
}
