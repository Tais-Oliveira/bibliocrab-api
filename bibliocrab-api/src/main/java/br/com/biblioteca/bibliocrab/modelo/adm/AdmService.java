package br.com.biblioteca.bibliocrab.modelo.adm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdmService {

    @Autowired
    private AdmRepository repository;

    @Transactional
    public Adm save(Adm adm) {
        return repository.save(adm);
    }

    public Iterable<Adm> listarTodos() {
  
        return repository.findAll();
    }
    
    public Adm obterPorID(Long id) {
 
        return repository.findById(id).get();
    }


}