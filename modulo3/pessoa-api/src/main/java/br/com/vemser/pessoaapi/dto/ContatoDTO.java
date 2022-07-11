package br.com.vemser.pessoaapi.dto;

import lombok.Data;

@Data

public class ContatoDTO extends ContatoCreateDTO {
    private Integer idContato;
}

/*
NOTAS DE ESTUDO:
-Extende ContatoCreate DTO, que é o espelho da classe Contato.
-Cuida da "volta". Usamos essa classe para retornar para o Controller protegendo o tráfego dos dados.

 */
