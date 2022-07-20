package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class PetDTO extends PetCreateDTO {

    @Schema(description = "Id do pet")
    private Integer idPet;
}

/*
Conceito da classe DTO:
-Extende a classe Create DTO, que é o espelho da respectiva classe Entity.
-Cuida da "volta". Usamos essa classe para retornar para o Controller protegendo o tráfego dos dados.
 */

