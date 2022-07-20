package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato2", allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Integer idContato;

    //id pessoa é usada na Pet Entity apenas para fins de referência
    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "TIPO")
    private TipoContato tipo;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DESCRICAO")
    private String descricao;

    //------------------------------------------------------------------------------------------------------------------

    //RELACIONAMENTO muitos para um - Contatos - Pessoa

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
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
