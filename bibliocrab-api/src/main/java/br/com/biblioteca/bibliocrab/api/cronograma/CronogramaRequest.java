package br.com.biblioteca.bibliocrab.api.cronograma;

import br.com.biblioteca.bibliocrab.modelo.cronograma.Cronograma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CronogramaRequest {
 
    private String livro;

    private String domingo;

    private String segunda;

    private String terca;

    private String quarta;

    private String quinta;

    private String sexta;

    private String sabado;

    public Cronograma build() {

        return Cronograma.builder()
                .livro(livro)
                .domingo(domingo)
                .segunda(segunda)
                .terca(terca)
                .quarta(quarta)
                .quinta(quinta)
                .sexta(sexta)
                .sabado(sabado)
                .build();
    }

}
