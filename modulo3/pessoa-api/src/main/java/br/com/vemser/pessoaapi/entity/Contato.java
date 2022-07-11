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

    @NotNull(message = "Tipo do contato não pode ser nulo")
    private TipoContato tipo;

    @NotNull(message = "Número não pode ser nulo")
    @NotEmpty(message = "Número não pode ser vazio")
    @NotBlank(message = "Número não pode ser em branco")
    @Size(max = 13, message = "Número deve conter no máximo 13 caracteres")
    private String numero;

    @NotEmpty(message = "Descrição não pode ser vazia")
    @NotNull(message = "Descrição não pode ser nula")
    private String descricao;

}
