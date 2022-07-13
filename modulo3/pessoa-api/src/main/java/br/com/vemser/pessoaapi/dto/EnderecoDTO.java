package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {

    @Schema(description = "Id do endereço")     //========================EM AULA 12/07
    private Integer idEndereco;
}

/*
NOTAS DE ESTUDO:
-Extende EnderecoCreate DTO, que é o espelho da classe Endereco.
-Cuida da "volta". Usamos essa classe para retornar para o Controller protegendo o tráfego dos dados.

 */
