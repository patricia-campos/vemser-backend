package br.com.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioPersonalizadoDTO {

    //Pessoa
    //private Integer idPessoa;
    private String nome;
    private String email;

    //Endereco
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    //Contato
    private String numero;

    //Pet
    private String nomePet;

}
    //------------------------------------------------------------------------------------------------------------------

    /* ANOTAÇÕES:
    Essa classe DTO foi feita com o objetivo de listar o relatório personalizado através de query jqpl.

    JPQL é um java sql onde usamos a sintaxe do sql misturada com a do java

    */
