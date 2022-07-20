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

    @Schema(description = "Id do cliente")
    private Integer idPessoa;

    @Schema(description = "Tipo de endereço do cliente")
    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipo;

    @Schema(description = "Logradouro do endereço do cliente")
    @NotEmpty(message = "Logradouro não pode ser vazio")
    @NotBlank(message = "Logradouro não pode ser em branco")
    @Size(max = 250, message = "Máximo de 250 caracteres")
    private String logradouro;

    @Schema(description = "Número do logradouro do endereço do cliente")
    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;

    @Schema(description = "Complemento do endereço do cliente")
    private String complemento;

    @Schema(description = "CEP do endereço do cliente")
    @NotEmpty(message = "Cep não pode ser vazio")
    @NotBlank(message = "Cep não pode ser em branco")
    @Size(max = 8, message = "Máximo de 8 caracteres")
    private String cep;

    @Schema(description = "Cidade do endereço do cliente")
    @NotNull(message = "Cidade não pode ser nula")
    @NotBlank(message = "Cidade não pode ser em branco")
    @NotEmpty(message = "Cidade não pode ser vazio")
    @Size(max = 250, message = "Máximo de 250 caracteres")
    private String cidade;

    @Schema(description = "Estado do endereço do cliente")
    @NotNull(message = "Estado não pode ser nulo")
    @NotBlank(message = "Estado não pode ser em branco")
    @NotEmpty(message = "Estado não pode ser vazio")
    private String estado;

    @Schema(description = "País do endereço do cliente")
    @NotNull(message = "País não pode ser nulo")
    @NotEmpty(message = "País não pode ser vazio")
    @NotBlank(message = "País não pode ser em branco")
    private String pais;
}

/*
NOTAS DE ESTUDO:
@Data - equivalent to the combination of @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode

Conceito da classe CreateDTO:
É o espelho da Entity, tem os mesmos atributos da Entity com exceção do id.
Usamos para fazer a manipulação usando DTO, para fim de proteger as informações nas transações.
*/

