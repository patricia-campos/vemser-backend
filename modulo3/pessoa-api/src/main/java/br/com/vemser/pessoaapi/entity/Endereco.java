package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipo;
    @NotEmpty(message = "Logradouro não pode ser vazio")
    @NotBlank(message = "Logradouro não pode ser em branco")
    @Size(max = 250, message = "Máximo de 250 caracteres")
    private String logradouro;
    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;
    private String complemento;
    @NotEmpty(message = "Cep não pode ser vazio")
    @NotBlank(message = "Cep não pode ser em branco")
    @Size(max = 250, message = "Máximo de 8 caracteres")
    private String cep;
    @NotNull(message = "Cidade não pode ser nula")
    @NotBlank(message = "Cidade não pode ser em branco")
    @NotEmpty(message = "Cidade não pode ser vazio")
    @Size(max = 250, message = "Máximo de 250 caracteres")
    private String cidade;
    @NotNull(message = "Estado não pode ser nulo")
    @NotBlank(message = "Estado não pode ser em branco")
    @NotEmpty(message = "Estado não pode ser vazio")
    private String estado;
    @NotNull(message = "País não pode ser nulo")
    @NotEmpty(message = "País não pode ser vazio")
    @NotBlank(message = "Paíss não pode ser em branco")
    private String pais;

    /*
    //TODO SUBSTITUIDO POR  @AllArgsConstructor

    public Endereco(Integer idEndereco, Integer idPessoa, TipoEndereco tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
    */

    /*
    //TODO SUBSTITUÍDO POR @Getter @Setter

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    */

}

//TODO
// - Pesquisar como testar o enum tipo de endereço
