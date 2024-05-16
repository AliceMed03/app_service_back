package com.app_service_back.categoria;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idCategoria;
    @NotNull(message = "O campo NOME é requerido.")
    private String categoriaNome;
    @NotNull(message = "O campo DESCRIÇÃO é requerido.")
    private String categoriaDescricao;
    //private list servico

    public CategoriaDTO() {
    }
    public CategoriaDTO(Long idCategoria, String categoriaNome, String categoriaDescricao) {
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
}
