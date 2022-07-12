package br.com.vemser.pessoaapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Pessoa {

    private Integer idPessoa;

    @Schema(description = "Nome do cliente")     //========================EM AULA 12/07
    @NotEmpty(message = "Nome não pode estar vazio")
    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @Schema(description = "Data de nascimento do cliente")  //========================EM AULA 12/07
    @NotNull(message = "Informe sua data de nascimento")
    @Past(message = "Você não pode nascer no futuro!")
    private LocalDate dataNascimento;

    @Schema(description = "CPF do cliente")    //========================EM AULA 12/07
    @NotNull(message = "CPF não pode ser nulo")
    @NotEmpty(message = "CPF não pode ser vazio")
    @Size(min = 11,max = 11, message = "CPF deve conter 11 caracteres")
    private String cpf;

    @Schema(description = "E-mail do cliente")     //========================EM AULA 12/07
    @Email
    @NotNull(message = "CPF não pode ser nulo")
    @NotEmpty(message = "CPF não pode ser vazio")
    private String email;

}
