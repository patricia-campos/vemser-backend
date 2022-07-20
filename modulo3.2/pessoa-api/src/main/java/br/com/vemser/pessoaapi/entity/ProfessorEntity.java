package br.com.vemser.pessoaapi.entity;

import br.com.vemser.pessoaapi.entity.pk.ProfessorPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "PROFESSOR")
public class ProfessorEntity {

    @EmbeddedId
    private ProfessorPK professorPK;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SALARIO")
    private Double salario;
}
