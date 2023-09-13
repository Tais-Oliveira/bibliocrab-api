package br.com.biblioteca.bibliocrab.modelo.cronograma;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CronogramaService {

    @Autowired
    private CronogramaRepository repository;

    @Transactional
    public Cronograma save(Cronograma cronograma) {
        return repository.save(cronograma);
    }

    public Iterable<Cronograma> listarTodos() {
  
        return repository.findAll();
    }
    
    public Cronograma obterPorID(Long id) {
 
        return repository.findById(id).get();
    }

    @Transactional
   public void update(Long id, Cronograma cronogramaAlterado) {

    Cronograma cronograma = repository.findById(id).get();
    cronograma.setLivro(cronogramaAlterado.getLivro());
    cronograma.setDomingo(cronogramaAlterado.getDomingo());
    cronograma.setSegunda(cronogramaAlterado.getSegunda());
    cronograma.setTerca(cronogramaAlterado.getTerca());
    cronograma.setQuarta(cronogramaAlterado.getQuarta());
    cronograma.setQuinta(cronogramaAlterado.getQuinta());
    cronograma.setSexta(cronogramaAlterado.getSexta());
    cronograma.setSabado(cronogramaAlterado.getSabado());

    repository.save(cronograma);
  }
  
  @Transactional
  public void delete(Long id) {

    Cronograma cronograma = repository.findById(id).get();
  /*   cronograma.setHabilitado(Boolean.FALSE);
      super.preencherCamposAuditoria(cronograma);
*/    
      repository.delete(cronograma);
  }


}
