package br.com.biblioteca.bibliocrab.api.livro;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.biblioteca.bibliocrab.modelo.livro.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroRequest {

  /* private Long idGenero;  */ 
    
    private String imagem;

    private String titulo;

    private String sinopse;

    private int qtdpag;

    private String autor;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lancamento;

    public Livro build() {

        return Livro.builder()
                .imagem(imagem)
                .titulo(titulo)
                .sinopse(sinopse)
                .qtdpag(qtdpag)
                .autor(autor)
                .lancamento(lancamento)
                .build();
    }

}