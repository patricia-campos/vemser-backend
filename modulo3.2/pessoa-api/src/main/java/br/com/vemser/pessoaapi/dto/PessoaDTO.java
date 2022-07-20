package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data

public class PessoaDTO extends PessoaCreateDTO {

    @Schema(description = "Id do cliente")
    private Integer idPessoa;
}

/*
NOTAS DE ESTUDO:
-Extende PessoaCreate DTO, que é o espelho da classe Pessoa.
-Cuida da "volta". Usamos essa classe para retornar para o Controller protegendo o tráfego dos dados.

 */
