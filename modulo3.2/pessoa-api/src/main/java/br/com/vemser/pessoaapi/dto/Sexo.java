package br.com.vemser.pessoaapi.dto;

import java.util.Arrays;

public enum Sexo {

    M(1),
    F(2);

    private Integer sexoInformado;

    Sexo(Integer sexo) {
        this.sexoInformado = sexo;
    }

    public Integer getSexo() {
        return sexoInformado;
    }

 public static Sexo ofSexo(Integer sexo){
  return Arrays.stream(Sexo.values())
          .filter(s -> s.getSexo().equals(sexo))
          .findFirst()
          .get();
    }
}
