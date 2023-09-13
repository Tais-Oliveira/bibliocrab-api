package br.com.biblioteca.bibliocrab.modelo.livro;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Component
@Table(name = "Livro")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro{
    
    private static final long serialVersionUID = 6744535953108071602L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/* 
    @ManyToOne
    private GeneroLivro genero; */

    @Column
    private String imagem;

    @Column
    private String titulo;

    @Column
    private String sinopse;

    @Column
    private int qtdpag;

    @Column
    private String autor;
    
    @Column
    private LocalDate lancamento;


}