package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    @NotNull(message = "Tipo não pode ser nulo")
    private Integer tipo;
    @NotNull(message = "Número não pode ser nulo")
    @NotEmpty(message = "Número não pode ser vazio")
    @NotBlank(message = "Número não pode ser em branco")
    @Size(max = 13, message = "Número conter no máximo 13 caracteres")
    private String numero;
    @NotEmpty(message = "Descrição não pode ser vazia")
    @NotNull(message = "Descrição não pode ser nula")
    private String descricao;

    /*
    //TODO SUBSTITUIDO POR @NoArgsConstructor

    public Contato() {
    }
    */

    /*
    //TODO SUBSTITUIDO POR  @AllArgsConstructor

    SUBSTITUIDO POR ALL ARGS
    public Contato(Integer idContato, Integer idPessoa, Integer tipo, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.numero = numero;
        this.descricao = descricao;
    }

     */

    /*
    //TODO SUBSTITUÍDO POR @Getter @Setter
    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    */

    /*
    //TODO SUBSTITUÍDO POR @ToString
    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa='" + idPessoa + '\'' +
                ", tipoContato=" + tipo +
                ", numero='" + numero +
                ", descricao='" + descricao +'\'' +
                '}';
    }

     */

    //TODO
    // - Aplicar enum em Tipo

}
