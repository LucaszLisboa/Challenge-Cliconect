package com.lucas.cliconect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "Sexo é obrigatório")
    private String sexo;
//    private Endereco endereco;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    @NotBlank(message = "Celular é obrigatório")
    private String celular;
    @NotBlank(message = "Data de nascimento é obrigatório")
    private String data_nascimento;
    @NotBlank(message = "Email é obrigatório")
    @Email
    private String email;
    @NotBlank(message = "Informações de atendimento é obrigatório")
    private String informacoes_atendimento;

    public Paciente(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInformacoesAtendimento() {
        return informacoes_atendimento;
    }

    public void setInformacoesAtendimento(String informacoes_atendimento) {
        this.informacoes_atendimento = informacoes_atendimento;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    //    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
}
