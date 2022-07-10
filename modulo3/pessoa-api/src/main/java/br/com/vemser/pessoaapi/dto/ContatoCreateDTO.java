package br.com.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data

public class ContatoCreateDTO {

    private Integer idContato;

    private Integer idPessoa;

    @NotNull(message = "Tipo não pode ser nulo")
    private Integer tipo;

    @NotNull(message = "Número não pode ser nulo")
    @NotEmpty(message = "Número não pode ser vazio")
    @NotBlank(message = "Número não pode ser em branco")
    @Size(max = 13, message = "Número conter no máximo 13 caracteres")
    private String numero;

    @NotEmpty(message = "Descrição não pode ser vazia")
    @NotNull(message = "Descrição não pode ser nula")
    private String descricao;

}
