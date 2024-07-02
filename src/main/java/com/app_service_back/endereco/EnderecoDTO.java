package com.app_service_back.endereco;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.prestador.PrestadorEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idEndereco;
    @NotBlank(message = "O campo RUA é requerido.")
    private String enderecoRua;
    @NotBlank(message = "O campo CEP é requerido.")
    private String enderecoCep;
    @NotBlank(message = "O campo NUMERO é requerido.")
    private Integer enderecoNumero;
    private String enderecoComplemento;
    @NotBlank(message = "O campo CIDADE é requerido.")
    private String enderecoCidade;
    @NotBlank(message = "O campo ESTADO é requerido.")
    private String enderecoEstado;
    @NotBlank(message = "O campo BAIRRO é requerido.")
    private String enderecoBairro;
    private List<ClienteEntity> cliente;
    private List<PrestadorEntity> prestador;


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

    public List<ClienteEntity> getCliente() {
        return cliente;
    }

    public void setCliente(List<ClienteEntity> cliente) {
        this.cliente = cliente;
    }

    public List<PrestadorEntity> getPrestador() {
        return prestador;
    }

    public void setPrestador(List<PrestadorEntity> prestador) {
        this.prestador = prestador;
    }
}
