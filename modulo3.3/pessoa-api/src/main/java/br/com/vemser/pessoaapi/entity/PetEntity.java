package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PET") //Nome da tabela
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "seq_pet", allocationSize = 1)
    @Column(name = "ID_PET")
    private Integer idPet;

    //id pessoa é usada na Pet Entity apenas para fins de referência
    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    private TipoPet tipo;

    //------------------------------------------------------------------------------------------------------------------

    //RELACIONAMENTO um para um - Pet - Pessoa

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID_PESSOA")
    private PessoaEntity pessoa;

}
//------------------------------------------------------------------------------------------------------------------
    /*
    ANOTAÇÕES:

    O atributo mappedBy é utilizado quando temos um relacionamento bidirecional mapeado entre duas classes. Ele é um
    atributo para ser utilizado nas annotations @OneToMany, @OneToOne e @ManyToMany. Para utilizamos, devemos declarar
    ele dentro da annotation e informar o nome do atributo da classe utilizada no mapeamento na outra ponta do
    relacionamento.

    */