package com.app_service_back.servicos;

import com.app_service_back.categoria.CategoriaEntity;
import com.app_service_back.endereco.EnderecoEntity;
import com.app_service_back.prestador.PrestadorEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "servicos")
public class ServicosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idServicos;
    private String servicosNome;
    private Double servicosPreco;
    private String servicosDescricao;
    private String servicosInformacoesAdicionais;
    private String servicosClassificacao;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servicosIdCategoria", nullable = false)
    private CategoriaEntity categoria;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "servicosIdPrestador", nullable = false)
    private PrestadorEntity prestador;

    public ServicosEntity() {
    }
    public ServicosEntity(Long idServicos, String servicosNome, Double servicosPreco, String servicosDescricao, String servicosInformacoesAdicionais, String servicosClassificacao, CategoriaEntity categoria, PrestadorEntity prestador) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicosEntity that = (ServicosEntity) o;
        return Objects.equals(idServicos, that.idServicos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServicos);
    }
}
