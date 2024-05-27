package com.app_service_back.servicos;

import com.app_service_back.categoria.CategoriaEntity;
import com.app_service_back.prestador.PrestadorEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ServicosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idServicos;
    @NotNull(message = "O campo NOME é requerido.")
    private String servicosNome;
    @NotNull(message = "O campo PREÇO é requerido.")
    private Double servicosPreco;
    @NotNull(message = "O campo DESCRIÇÃO é requerido.")
    private String servicosDescricao;
    private String servicosInformacoesAdicionais;
    private String servicosClassificacao;
    private CategoriaEntity categoria;
    private PrestadorEntity prestador;

    public ServicosDTO() {
    }
    public ServicosDTO(Long idServicos, String servicosNome, Double servicosPreco, String servicosDescricao, String servicosInformacoesAdicionais, String servicosClassificacao, CategoriaEntity categoria, PrestadorEntity prestador) {
        this.idServicos = idServicos;
        this.servicosNome = servicosNome;
        this.servicosPreco = servicosPreco;
        this.servicosDescricao = servicosDescricao;
        this.servicosInformacoesAdicionais = servicosInformacoesAdicionais;
        this.servicosClassificacao = servicosClassificacao;
        this.categoria = categoria;
        this.prestador = prestador;
    }

    public Long getIdServicos() {
        return idServicos;
    }

    public void setIdServicos(Long idServicos) {
        this.idServicos = idServicos;
    }

    public String getServicosNome() {
        return servicosNome;
    }

    public void setServicosNome(String servicosNome) {
        this.servicosNome = servicosNome;
    }

    public Double getServicosPreco() {
        return servicosPreco;
    }

    public void setServicosPreco(Double servicosPreco) {
        this.servicosPreco = servicosPreco;
    }

    public String getServicosDescricao() {
        return servicosDescricao;
    }

    public void setServicosDescricao(String servicosDescricao) {
        this.servicosDescricao = servicosDescricao;
    }

    public String getServicosInformacoesAdicionais() {
        return servicosInformacoesAdicionais;
    }

    public void setServicosInformacoesAdicionais(String servicosInformacoesAdicionais) {
        this.servicosInformacoesAdicionais = servicosInformacoesAdicionais;
    }

    public String getServicosClassificacao() {
        return servicosClassificacao;
    }

    public void setServicosClassificacao(String servicosClassificacao) {
        this.servicosClassificacao = servicosClassificacao;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public PrestadorEntity getPrestador() {
        return prestador;
    }

    public void setPrestador(PrestadorEntity prestador) {
        this.prestador = prestador;
    }
}
