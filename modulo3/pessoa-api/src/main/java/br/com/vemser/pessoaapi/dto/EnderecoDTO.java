package br.com.vemser.pessoaapi.dto;

import lombok.Data;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {

    private Integer idEndereco;
}

/*
NOTAS DE ESTUDO:
-Extende EnderecoCreate DTO, que é o espelho da classe Endereco.
-Cuida da "volta". Usamos essa classe para retornar para o Controller protegendo o tráfego dos dados.

 */
