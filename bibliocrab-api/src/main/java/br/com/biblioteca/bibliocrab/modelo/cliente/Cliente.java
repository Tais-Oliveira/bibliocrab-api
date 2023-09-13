package br.com.biblioteca.bibliocrab.modelo.cliente;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.stereotype.Component;

import br.com.biblioteca.bibliocrab.modelo.acesso.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Component
@Table(name = "Cliente")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente{
    
    private static final long serialVersionUID = 6744535953108071602L;
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @Column
    private String nome;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String celular;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String endereco;

  /*   @Column
    private String email;

    @Column
    private String senha;*/

}