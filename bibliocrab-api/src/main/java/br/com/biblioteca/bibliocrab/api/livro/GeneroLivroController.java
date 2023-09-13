package br.com.biblioteca.bibliocrab.api.livro;
/* 
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
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.bibliocrab.modelo.livro.GeneroLivro;
import br.com.biblioteca.bibliocrab.modelo.livro.GeneroLivroService;

@RestController
@CrossOrigin
@RequestMapping("/genero")
public class GeneroLivroController {
    
    @Autowired
    private GeneroLivroService generoLivroService;

    @PostMapping
    public ResponseEntity<GeneroLivro> save(@RequestBody @Valid GeneroLivroRequest request) {
        GeneroLivro generoLivroNovo = request.build();
        GeneroLivro generoLivro = generoLivroService.save(generoLivroNovo);
        return new ResponseEntity<GeneroLivro>(generoLivro, HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<GeneroLivro> listarTodos() {
       return generoLivroService.listarTodos();
    }

    @GetMapping("/{id}")
    public GeneroLivro obterPorID(@PathVariable Long id) {

       return generoLivroService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroLivro> update(@PathVariable("id") Long id, @RequestBody GeneroLivroRequest request) {

        generoLivroService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        generoLivroService.delete(id);
        return ResponseEntity.ok().build();
    }

}
*/