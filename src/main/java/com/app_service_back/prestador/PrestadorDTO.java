package com.app_service_back.prestador;

import com.app_service_back.endereco.EnderecoEntity;
import com.app_service_back.servicos.ServicosEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class PrestadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idPrestador;
    @NotBlank(message = "O campo NOME é requerido.")
    private String prestadorNome;
    @Column(unique = true)
    @CPF
    @NotBlank(message = "O campo CPF é requerido.")
    private String prestadorCpf;
    private String prestadorRazaoSocial;
    private String prestadorNomeFantasia;
    @Column(unique = true)
    private String prestadorCnpj;
    @Column(unique = true)
    @NotBlank(message = "O campo EMAIL é requerido.")
    private String prestadorEmail;

    private String prestadorSenha;
    @NotBlank(message = "O campo TELEFONE é requerido.")
    private String prestadorTelefone;
    private EnderecoEntity endereco;
    private List<ServicosEntity> servicos = new ArrayList<>();

    public String getprestadorTelefone() {
        return prestadorTelefone;
    }

    public Long getIdPrestador() {
        return idPrestador;
    }

    public String getPrestadorNome() {
        return prestadorNome;
    }

    public String getPrestadorCpf() {
        return prestadorCpf;
    }

    public String getPrestadorRazaoSocial() {
        return prestadorRazaoSocial;
    }

    public String getPrestadorNomeFantasia() {
        return prestadorNomeFantasia;
    }

    public String getPrestadorCnpj() {
        return prestadorCnpj;
    }

    public String getPrestadorEmail() {
        return prestadorEmail;
    }

    public String getPrestadorSenha() {
        return prestadorSenha;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public List<ServicosEntity> getServicos() {
        return servicos;
    }

    public void setIdPrestador(Long idPrestador) {
        this.idPrestador = idPrestador;
    }

    public void setPrestadorNome(String prestadorNome) {
        this.prestadorNome = prestadorNome;
    }

    public void setPrestadorCpf(String prestadorCpf) {
        this.prestadorCpf = prestadorCpf;
    }

    public void setPrestadorRazaoSocial(String prestadorRazaoSocial) {
        this.prestadorRazaoSocial = prestadorRazaoSocial;
    }

    public void setPrestadorNomeFantasia(String prestadorNomeFantasia) {
        this.prestadorNomeFantasia = prestadorNomeFantasia;
    }

    public void setPrestadorCnpj(String prestadorCnpj) {
        this.prestadorCnpj = prestadorCnpj;
    }

    public void setPrestadorEmail(String prestadorEmail) {
        this.prestadorEmail = prestadorEmail;
    }

    public void setPrestadorSenha(String prestadorSenha) {
        this.prestadorSenha = prestadorSenha;
    }

    public void setprestadorTelefone(String prestadorTelefone) {
        this.prestadorTelefone = prestadorTelefone;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public void setServicos(List<ServicosEntity> servicos) {
        this.servicos = servicos;
    }
}


