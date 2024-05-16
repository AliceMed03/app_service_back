package com.app_service_back.telefone;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.endereco.EnderecoEntity;
import com.app_service_back.prestador.PrestadorEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "telefone")
public class TelefoneEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTelefone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXXX-XXXX")
    private String telefoneNumero;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "telefoneIdCliente", nullable = false)
//    private ClienteEntity cliente;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "telefoneIdPrestador", nullable = false)
//    private PrestadorEntity prestador;

    public TelefoneEntity() {
    }
    public TelefoneEntity(Long idTelefone, String telefoneNumero, ClienteEntity cliente, PrestadorEntity prestador) {
        this.idTelefone = idTelefone;
        this.telefoneNumero = telefoneNumero;
//        this.cliente = cliente;
//        this.prestador = prestador;
    }

    public Long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefoneNumero() {
        return telefoneNumero;
    }

    public void setTelefoneNumero(String telefoneNumero) {
        this.telefoneNumero = telefoneNumero;
    }

//    public ClienteEntity getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(ClienteEntity cliente) {
//        this.cliente = cliente;
//    }
//
//    public PrestadorEntity getPrestador() {
//        return prestador;
//    }
//
//    public void setPrestador(PrestadorEntity prestador) {
//        this.prestador = prestador;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelefoneEntity that = (TelefoneEntity) o;
        return Objects.equals(idTelefone, that.idTelefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTelefone);
    }
}
