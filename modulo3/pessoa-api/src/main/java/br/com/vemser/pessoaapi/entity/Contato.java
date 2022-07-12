package br.com.vemser.pessoaapi.entity;

import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipo;
    private String numero;
    private String descricao;
}
