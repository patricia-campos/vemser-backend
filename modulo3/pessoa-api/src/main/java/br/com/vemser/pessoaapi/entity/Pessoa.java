package br.com.vemser.pessoaapi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Pessoa {

    private Integer idPessoa;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;

}
