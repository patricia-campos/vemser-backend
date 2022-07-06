package br.com.vemser.pessoaapi.entity;

public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    private Integer tipo;
    private String numero;
    private String descricao;

    public Contato() {

    }

    public Contato(Integer idContato, Integer idPessoa, Integer tipo, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.numero = numero;
        this.descricao = descricao;
    }

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

    //todo ver questão do enum no tipo

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

}
