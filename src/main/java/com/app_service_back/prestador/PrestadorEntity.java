package com.app_service_back.prestador;

import com.app_service_back.endereco.EnderecoEntity;
import com.app_service_back.servicos.ServicosEntity;
import com.app_service_back.telefone.TelefoneEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "prestador")
public class PrestadorEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPrestador;
    private String prestadorNome;
    @Column(unique = true)
    private String prestadorCpf;
    private String prestadorRazaoSocial;
    private String prestadorNomeFantasia;
    @Column(unique = true)
    private String prestadorCnpj;
    @Column(unique = true)
    private String prestadorEmail;
    private String prestadorSenha;
    @OneToMany(mappedBy = "idServicos", fetch = FetchType.EAGER)
    private List<ServicosEntity> servicos = new ArrayList<>();
    @OneToMany(mappedBy = "idTelefone", fetch = FetchType.EAGER)
    private List<TelefoneEntity> telefone = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prestadorIdEndereco", nullable = false)
    private EnderecoEntity endereco;

    public PrestadorEntity() {

    }
    public PrestadorEntity(Long idPrestador, String prestadorNome, String prestadorCpf, String prestadorRazaoSocial, String prestadorNomeFantasia, String prestadorCnpj, String prestadorEmail, String prestadorSenha, EnderecoEntity endereco) {
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

    public List<ServicosEntity> getServicos() {
        return servicos;
    }

    public List<TelefoneEntity> getTelefone() {
        return telefone;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrestadorEntity that = (PrestadorEntity) o;
        return Objects.equals(idPrestador, that.idPrestador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPrestador);
    }
}