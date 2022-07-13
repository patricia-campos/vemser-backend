package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data

public class EnderecoCreateDTO {


    private Integer idPessoa;

    @Schema(description = "Tipo de endereço do cliente")     //========================EM AULA 12/07
    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipo;

    @Schema(description = "Logradouro")     //========================EM AULA 12/07
    @NotEmpty(message = "Logradouro não pode ser vazio")
    @NotBlank(message = "Logradouro não pode ser em branco")
    @Size(max = 250, message = "Máximo de 250 caracteres")
    private String logradouro;

    @Schema(description = "Número")     //========================EM AULA 12/07
    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;

    private String complemento;

    @Schema(description = "CEP")     //========================EM AULA 12/07
    @NotEmpty(message = "Cep não pode ser vazio")
    @NotBlank(message = "Cep não pode ser em branco")
    @Size(max = 8, message = "Máximo de 8 caracteres")
    private String cep;

    @Schema(description = "Cidade")     //========================EM AULA 12/07
    @NotNull(message = "Cidade não pode ser nula")
    @NotBlank(message = "Cidade não pode ser em branco")
    @NotEmpty(message = "Cidade não pode ser vazio")
    @Size(max = 250, message = "Máximo de 250 caracteres")
    private String cidade;

    @Schema(description = "Estado")     //========================EM AULA 12/07
    @NotNull(message = "Estado não pode ser nulo")
    @NotBlank(message = "Estado não pode ser em branco")
    @NotEmpty(message = "Estado não pode ser vazio")
    private String estado;

    @Schema(description = "País")     //========================EM AULA 12/07
    @NotNull(message = "País não pode ser nulo")
    @NotEmpty(message = "País não pode ser vazio")
    @NotBlank(message = "País não pode ser em branco")
    private String pais;
}

/*
NOTAS DE ESTUDO:
@Data - equivalent to the combination of @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode

EnderecoCreateDTO - É o espelho de Endereco, que usamos para fazer a manipulação usando DTO, para fim de proteger
as informações nas transações.
*/

