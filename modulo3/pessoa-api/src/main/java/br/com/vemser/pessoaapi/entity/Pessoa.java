package br.com.vemser.pessoaapi.entity;

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

    @NotEmpty(message = "Nome não pode estar vazio")
    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull(message = "Não pode ser nulo")
    private String nome;

    @NotNull(message = "Informe sua data de nascimento")
    @Past(message = "Você não pode nascer no futuro!")
    private LocalDate dataNascimento;

    @NotNull(message = "Não pode ser nulo")
    @NotEmpty(message = "Nào pode ser vazio")
    @Size(min = 11,max = 11, message = "Deve conter 11 caracteres")
    private String cpf;

}