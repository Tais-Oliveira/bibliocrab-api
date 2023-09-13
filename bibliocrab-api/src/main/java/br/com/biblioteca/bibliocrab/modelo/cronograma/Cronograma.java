package br.com.biblioteca.bibliocrab.modelo.cronograma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Component
@Table(name = "Cronograma")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cronograma{
    
    private static final long serialVersionUID = 6744535953108071602L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String livro;

    @Column
    private String domingo;

    @Column
    private String segunda;

    @Column
    private String terca;

    @Column
    private String quarta;

    @Column
    private String quinta;

    @Column
    private String sexta;

    @Column
    private String sabado;

}