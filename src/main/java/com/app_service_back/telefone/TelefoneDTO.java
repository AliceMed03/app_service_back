package com.app_service_back.telefone;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.prestador.PrestadorEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

public class TelefoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idTelefone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXXX-XXXX")
    @NotNull(message = "O campo NÚMERO é requerido.")
    private String telefoneNumero;
    private ClienteEntity cliente;
    private PrestadorEntity prestador;

    public TelefoneDTO() {
    }
    public TelefoneDTO(Long idTelefone, String telefoneNumero, ClienteEntity cliente, PrestadorEntity prestador) {
        this.idTelefone = idTelefone;
        this.telefoneNumero = telefoneNumero;
        this.cliente = cliente;
        this.prestador = prestador;
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

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public PrestadorEntity getPrestador() {
        return prestador;
    }

    public void setPrestador(PrestadorEntity prestador) {
        this.prestador = prestador;
    }
}
