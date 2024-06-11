package com.app_service_back.prestador;

import com.app_service_back.endereco.EnderecoEntity;
import com.app_service_back.servicos.ServicosEntity;
import com.app_service_back.telefone.TelefoneEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrestadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idPrestador;
    @NotNull(message = "O campo NOME é requerido.")
    private String prestadorNome;
    @Column(unique = true)
    @CPF
    @NotNull(message = "O campo CPF é requerido.")
    private String prestadorCpf;
    private String prestadorRazaoSocial;
    private String prestadorNomeFantasia;
    @Column(unique = true)
    private String prestadorCnpj;
    @Column(unique = true)
    @NotNull(message = "O campo EMAIL é requerido.")
    private String prestadorEmail;
    @JsonIgnore
    private String prestadorSenha;
    private EnderecoEntity endereco;
    private List<ServicosEntity> servicos = new ArrayList<>();
    private List<TelefoneEntity> telefone = new ArrayList<>();


    public PrestadorDTO() {
    }
    public PrestadorDTO(Long idPrestador, String prestadorNome, String prestadorCpf, String prestadorRazaoSocial, String prestadorNomeFantasia, String prestadorCnpj, String prestadorEmail, String prestadorSenha, EnderecoEntity endereco) {
        this.idPrestador = idPrestador;
        this.prestadorNome = prestadorNome;
        this.prestadorCpf = prestadorCpf;
        this.prestadorRazaoSocial = prestadorRazaoSocial;
        this.prestadorNomeFantasia = prestadorNomeFantasia;
        this.prestadorCnpj = prestadorCnpj;
        this.prestadorEmail = prestadorEmail;
        this.prestadorSenha = prestadorSenha;
        this.endereco = endereco;
    }

    public Long getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(Long idPrestador) {
        this.idPrestador = idPrestador;
    }

    public String getPrestadorNome() {
        return prestadorNome;
    }

    public void setPrestadorNome(String prestadorNome) {
        this.prestadorNome = prestadorNome;
    }

    public String getPrestadorCpf() {
        return prestadorCpf;
    }

    public void setPrestadorCpf(String prestadorCpf) {
        this.prestadorCpf = prestadorCpf;
    }

    public String getPrestadorRazaoSocial() {
        return prestadorRazaoSocial;
    }

    public void setPrestadorRazaoSocial(String prestadorRazaoSocial) {
        this.prestadorRazaoSocial = prestadorRazaoSocial;
    }

    public String getPrestadorNomeFantasia() {
        return prestadorNomeFantasia;
    }

    public void setPrestadorNomeFantasia(String prestadorNomeFantasia) {
        this.prestadorNomeFantasia = prestadorNomeFantasia;
    }

    public String getPrestadorCnpj() {
        return prestadorCnpj;
    }

    public void setPrestadorCnpj(String prestadorCnpj) {
        this.prestadorCnpj = prestadorCnpj;
    }

    public String getPrestadorEmail() {
        return prestadorEmail;
    }

    public void setPrestadorEmail(String prestadorEmail) {
        this.prestadorEmail = prestadorEmail;
    }

    public String getPrestadorSenha() {
        return prestadorSenha;
    }

    public void setPrestadorSenha(String prestadorSenha) {
        this.prestadorSenha = prestadorSenha;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<ServicosEntity> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicosEntity> servicos) {
        this.servicos = servicos;
    }

    public List<TelefoneEntity> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<TelefoneEntity> telefone) {
        this.telefone = telefone;
    }
}


