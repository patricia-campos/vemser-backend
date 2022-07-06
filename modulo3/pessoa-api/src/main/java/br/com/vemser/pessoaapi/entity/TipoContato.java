package br.com.vemser.pessoaapi.entity;

public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);

private Integer tipoDoContato;

TipoContato(Integer tipoDoContato) {
    this.tipoDoContato=tipoDoContato;
}

public Integer getTipoDoContato() {
    return tipoDoContato;
}

}
