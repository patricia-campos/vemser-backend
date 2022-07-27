package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;

    //id pessoa é usada na Pet Entity apenas para fins de referência
    //@Column(name = "ID_PESSOA", insertable = false, updatable = false)
    //private Integer idPessoa;

    @Column(name = "TIPO")
    private TipoEndereco tipo;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "PAIS")
    private String pais;

    //------------------------------------------------------------------------------------------------------------------

    //RELACIONAMENTO muitos para muitos - Endereço - Pessoa

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PESSOA_X_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_ENDERECO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PESSOA")
    )
    private List<PessoaEntity> pessoa;
    //private Set<PessoaEntity> pessoa;

}

//------------------------------------------------------------------------------------------------------------------
    /*
    ANOTAÇÕES:

    O atributo mappedBy é utilizado quando temos um relacionamento bidirecional mapeado entre duas classes. Ele é um
    atributo para ser utilizado nas annotations @OneToMany, @OneToOne e @ManyToMany. Para utilizamos, devemos declarar
    ele dentro da annotation e informar o nome do atributo da classe utilizada no mapeamento na outra ponta do
    relacionamento.

    */

