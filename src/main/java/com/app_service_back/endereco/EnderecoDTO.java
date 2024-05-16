package com.app_service_back.endereco;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.prestador.PrestadorEntity;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idEndereco;
    @NotNull(message = "O campo RUA é requerido.")
    private String enderecoRua;
    @NotNull(message = "O campo CEP é requerido.")
    private String enderecoCep;
    @NotNull(message = "O campo NUMERO é requerido.")
    private Integer enderecoNumero;
    private String enderecoComplemento;
    @NotNull(message = "O campo CIDADE é requerido.")
    private String enderecoCidade;
    @NotNull(message = "O campo ESTADO é requerido.")
    private String enderecoEstado;
    @NotNull(message = "O campo BAIRRO é requerido.")
    private String enderecoBairro;
    //private List<ClienteEntity> cliente = new ArrayList<>();
    //private List<PrestadorEntity> prestador = new ArrayList<>();


    public EnderecoDTO() {
    }
    public EnderecoDTO(Long idEndereco, String enderecoRua, String enderecoCep, Integer enderecoNumero, String enderecoComplemento, String enderecoCidade, String enderecoEstado, String enderecoBairro) {
        this.idEndereco = idEndereco;
        this.enderecoRua = enderecoRua;
        this.enderecoCep = enderecoCep;
        this.enderecoNumero = enderecoNumero;
        this.enderecoComplemento = enderecoComplemento;
        this.enderecoCidade = enderecoCidade;
        this.enderecoEstado = enderecoEstado;
        this.enderecoBairro = enderecoBairro;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    public String getEnderecoCep() {
        return enderecoCep;
    }

    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public Integer getEnderecoNumero() {
        return enderecoNumero;
    }

    public void setEnderecoNumero(Integer enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    public String getEnderecoEstado() {
        return enderecoEstado;
    }

    public void setEnderecoEstado(String enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }
}
