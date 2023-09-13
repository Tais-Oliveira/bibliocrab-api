package br.com.biblioteca.bibliocrab.api.cronograma;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.bibliocrab.modelo.cronograma.Cronograma;
import br.com.biblioteca.bibliocrab.modelo.cronograma.CronogramaService;

@RestController
@CrossOrigin
@RequestMapping("/cronograma")
public class CronogramaController {
    
    @Autowired
    private CronogramaService cronogramaService;

   @GetMapping
   public Iterable<Cronograma> listarTodos() {
       return cronogramaService.listarTodos();
   }

    @PostMapping
      public ResponseEntity<Cronograma> save(@RequestBody @Valid CronogramaRequest request) {

      Cronograma cronogramaNovo = request.build();
      Cronograma cronograma = cronogramaService.save(cronogramaNovo);
      return new ResponseEntity<Cronograma>(cronograma, HttpStatus.CREATED);
   }
  
   @GetMapping("/{id}")
   public Cronograma obterPorID(@PathVariable Long id) {

       return cronogramaService.obterPorID(id);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Cronograma> update(@PathVariable("id") Long id, @RequestBody @Valid CronogramaRequest request) {

      cronogramaService.update(id, request.build());
      return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

      cronogramaService.delete(id);
      return ResponseEntity.ok().build();
   }

}
