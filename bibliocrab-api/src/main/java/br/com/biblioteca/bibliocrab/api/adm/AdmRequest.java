package br.com.biblioteca.bibliocrab.api.adm;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.biblioteca.bibliocrab.modelo.adm.Adm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdmRequest {
 
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String celular;

    private String cpf;

    private String rg;

    private String endereco;

    private String email;

    private String matricula;

    private String senha;

    public Adm build() {

        return Adm.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .celular(celular)
                .cpf(cpf)
                .rg(rg)
                .endereco(endereco)
                .email(email)
                .matricula(matricula)
                .senha(senha)
                .build();
    }

}
