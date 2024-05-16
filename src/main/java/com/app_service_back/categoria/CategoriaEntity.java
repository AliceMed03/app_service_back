package com.app_service_back.categoria;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.servicos.ServicosEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class CategoriaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    private String categoriaNome;
    private String categoriaDescricao;
    @OneToMany(mappedBy = "idServicos", fetch = FetchType.EAGER)
    private List<ServicosEntity> servicos = new ArrayList<>();

    public CategoriaEntity() {
    }
    public CategoriaEntity(Long idCategoria, String categoriaNome, String categoriaDescricao) {
        this.idCategoria = idCategoria;
        this.categoriaNome = categoriaNome;
        this.categoriaDescricao = categoriaDescricao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public String getCategoriaDescricao() {
        return categoriaDescricao;
    }

    public void setCategoriaDescricao(String categoriaDescricao) {
        this.categoriaDescricao = categoriaDescricao;
    }

    public List<ServicosEntity> getServicos() {
        return servicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return Objects.equals(idCategoria, that.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria);
    }

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "idCategoria=" + idCategoria +
                ", categoriaNome='" + categoriaNome + '\'' +
                ", categoriaDescricao='" + categoriaDescricao + '\'' +
                '}';
    }
}