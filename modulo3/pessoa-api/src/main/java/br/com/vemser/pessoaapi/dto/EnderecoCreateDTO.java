package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoEndereco;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data

public class EnderecoCreateDTO {

    private Integer idEndereco;

    private Integer idPessoa;

    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipo;

    @NotEmpty(message = "Logradouro não pode ser vazio")
    @NotBlank(message = "Logradouro não pode ser em branco")
    @Size(max = 250, message = "Máximo de 250 caracteres")
    private String logradouro;

    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;

    private String complemento;

    @NotEmpty(message = "Cep não pode ser vazio")
    @NotBlank(message = "Cep não pode ser em branco")
    @Size(max = 250, message = "Máximo de 8 caracteres")
    private String cep;

    @NotNull(message = "Cidade não pode ser nula")
    @NotBlank(message = "Cidade não pode ser em branco")
    @NotEmpty(message = "Cidade não pode ser vazio")
    @Size(max = 250, message = "Máximo de 250 caracteres")
    private String cidade;

    @NotNull(message = "Estado não pode ser nulo")
    @NotBlank(message = "Estado não pode ser em branco")
    @NotEmpty(message = "Estado não pode ser vazio")
    private String estado;

    @NotNull(message = "País não pode ser nulo")
    @NotEmpty(message = "País não pode ser vazio")
    @NotBlank(message = "Paíss não pode ser em branco")
    private String pais;
}

/*
NOTAS DE ESTUDO:
@Data - equivalent to the combination of @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode

EnderecoCreateDTO - É o espelho de Endereco, que usamos para fazer a manipulação usando DTO, para fim de proteger
as informações nas transações.
*/

