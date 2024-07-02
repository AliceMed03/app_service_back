package com.app_service_back.categoria;

import com.app_service_back.servicos.ServicosDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idCategoria;
    @NotBlank(message = "O campo NOME é requerido.")
    private String categoriaNome;
    @NotBlank(message = "O campo DESCRIÇÃO é requerido.")
    private String categoriaDescricao;
    private List<ServicosDTO> servicos;

    public CategoriaDTO() {
    }
    public CategoriaDTO(Long idCategoria, String categoriaNome, String categoriaDescricao, List<ServicosDTO> servicos) {
        this.idCategoria = idCategoria;
        this.categoriaNome = categoriaNome;
        this.categoriaDescricao = categoriaDescricao;
        this.servicos = servicos;
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

    public List<ServicosDTO> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicosDTO> servicos) {
        this.servicos = servicos;
    }
}
