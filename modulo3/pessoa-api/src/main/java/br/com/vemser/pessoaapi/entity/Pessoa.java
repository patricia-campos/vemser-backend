package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Pessoa {

    private Integer idPessoa;
    @NotEmpty(message = "Nome não pode estar vazio")
    @NotBlank(message = "Nome não pode estar em branco")
    @NotNull(message = "Não pode ser nulo")
    private String nome;
    @NotNull(message = "Informe sua data de nascimento")
    @Past(message = "Você não pode nascer no futuro!")
    private LocalDate dataNascimento;
    @NotNull(message = "Não pode ser nulo")
    @NotEmpty(message = "Nào pode ser vazio")
    @Size(min = 11,max = 11, message = "Deve conter 11 caracteres")
    private String cpf;

    public Pessoa() {

    }

    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}