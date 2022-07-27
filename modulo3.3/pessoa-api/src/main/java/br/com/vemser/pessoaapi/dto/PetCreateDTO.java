package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data //Aqui em dto posso ter o @Data
public class PetCreateDTO {

    @Schema(description = "Id da pessoa")
    private Integer idPessoa;

    @Schema(description = "Nome do Pet")
    @NotEmpty(message = "Nome do pet não pode ser vazio")
    @NotBlank(message = "Nome do pet não pode ser em branco")
    @Size(max = 255, message = "Máximo de 255 caracteres")
    private String nome;

    @Schema(description = "Tipo do pet")
    @NotNull(message = "Tipo do pet não pode ser nulo")
    private TipoPet tipo;
}

/*
Conceito da classe CreateDTO:
É o espelho da Entity, tem os mesmos atributos da Entity com exceção do id.
Usamos para fazer a manipulação usando DTO, para fim de proteger as informações nas transações.
*/
