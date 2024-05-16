package com.app_service_back.endereco;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.prestador.PrestadorEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "endereco")
public class EnderecoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;
    private String enderecoRua;
    private String enderecoCep;
    private Integer enderecoNumero;
    private String enderecoComplemento;
    private String enderecoCidade;
    private String enderecoEstado;
    private String enderecoBairro;
    @OneToMany(mappedBy = "idCliente", fetch = FetchType.EAGER)
    private List<ClienteEntity> cliente = new ArrayList<>();
    @OneToMany(mappedBy = "idPrestador", fetch = FetchType.EAGER)
    private List<PrestadorEntity> prestador = new ArrayList<>();

    public EnderecoEntity() {
    }
    public EnderecoEntity(Long idEndereco, String enderecoRua, String enderecoCep, Integer enderecoNumero, String enderecoComplemento, String enderecoCidade, String enderecoEstado, String enderecoBairro) {
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

    public List<PrestadorEntity> getPrestador() {
        return prestador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoEntity that = (EnderecoEntity) o;
        return Objects.equals(idEndereco, that.idEndereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEndereco);
    }
}
