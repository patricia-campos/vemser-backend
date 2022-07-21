package br.com.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ID_PET", insertable = false, updatable = false)
    private Integer idPet;


    //------------------------------------------------------------------------------------------------------------------

    //RELACIONAMENTO um para um - Pessoa - Pet

    //@JsonIgnore
    //@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name="ID_PET", referencedColumnName = "ID_PET")
    //private Set<PetEntity> pet;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PET", referencedColumnName = "ID_PET")
    private PetEntity pet;

    //------------------------------------------------------------------------------------------------------------------

    //RELACIONAMENTO um para muitos - Pessoa - Contatos

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "pessoa",         //Indica o lado inverso do relacionamento
            cascade = CascadeType.ALL,   //Faz a cascata para deletar
            orphanRemoval = true)        //Deleta os órfãos
    private Set<ContatoEntity> contatos;

    //------------------------------------------------------------------------------------------------------------------

    //RELACIONAMENTO muitos para muitos - Pessoa - Endereço
    //TODO- AQUI DEU RUIM EM ALGUM PONTO

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PESSOA_ X_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
    )
    private Set<EnderecoEntity> enderecos;
}

//------------------------------------------------------------------------------------------------------------------
    /*
    ANOTAÇÕES:

    O atributo mappedBy é utilizado quando temos um relacionamento bidirecional mapeado entre duas classes. Ele é um
    atributo para ser utilizado nas annotations @OneToMany, @OneToOne e @ManyToMany. Para utilizamos, devemos declarar
    ele dentro da annotation e informar o nome do atributo da classe utilizada no mapeamento na outra ponta do
    relacionamento.

    */