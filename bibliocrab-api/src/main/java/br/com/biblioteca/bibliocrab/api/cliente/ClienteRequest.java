package br.com.biblioteca.bibliocrab.api.cliente;

import java.time.LocalDate;
import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.biblioteca.bibliocrab.modelo.acesso.Usuario;
import br.com.biblioteca.bibliocrab.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {
    
    @NotBlank(message = "O e-mail é de preenchimento obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    private String password;
    
    @NotNull(message = "O Nome é de preenchimento obrigatório")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String celular;

    private String cpf;

    private String rg;

    private String endereco;

   /*  private String email; */

   /*  private String senha; */

    public Cliente build() {

        return Cliente.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .celular(celular)
                .cpf(cpf)
                .rg(rg)
                .endereco(endereco)
               /*  .email(email)
                .senha(senha)*/
                .usuario(buildUsuario())
                .build();
    }

      public Usuario buildUsuario() {
	
	return Usuario.builder()
		.username(email)
		.password(password)
		.roles(Arrays.asList(Usuario.ROLE_CLIENTE))
		.build();
    }

}
