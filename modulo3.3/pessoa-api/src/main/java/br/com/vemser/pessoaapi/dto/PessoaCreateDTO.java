package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @Schema(description = "Nome do cliente")
    @NotEmpty(message = "Nome não pode estar vazio")
    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @Schema(description = "Sexo do cliente")
    @NotNull(message = "Não pode ser nulo")
    private Sexo sexo;

    @Schema(description = "Data de nascimento do cliente")
    @NotNull(message = "Informe sua data de nascimento")
    @Past(message = "Você não pode nascer no futuro!")
    private LocalDate dataNascimento;

    @Schema(description = "CPF do cliente")
    @NotNull(message = "CPF não pode ser nulo")
    @NotEmpty(message = "CPF não pode ser vazio")
    @Size(min = 11, max = 11, message = "CPF deve conter 11 caracteres")
    private String cpf;

    @Schema(description = "E-mail do cliente")
    @Email
    @NotNull(message = "E-mail não pode ser nulo")
    @NotEmpty(message = "E-mail não pode ser vazio")
    private String email;
}

/*
NOTAS DE ESTUDO:
@Data - equivalent to the combination of @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode

PessoaCreateDTO - É o espelho de Pessoa, que usamos para fazer a manipulação usando DTO, para fim de proteger
as informações nas transações.
*/
