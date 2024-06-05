package com.app_service_back.cliente;

import com.app_service_back.agendamento.AgendamentoEntity;
import com.app_service_back.endereco.EnderecoEntity;
import com.app_service_back.telefone.TelefoneEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idCliente;
    private String clienteNome;
    @CPF
    @Column(unique = true, nullable = false)
    private String clienteCpf;
    @Column(unique = true)
    private String clienteEmail;
    private String clienteSenha;
    private LocalDate clienteDataNascimento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clienteIdEndereco")
    private EnderecoEntity endereco;
    //mappedBy = "idTelefone",
    @OneToMany( fetch = FetchType.EAGER)
    private List<TelefoneEntity> telefone;
    //mappedBy = "idAgendamento",
    @OneToMany( fetch = FetchType.EAGER)
    private List<AgendamentoEntity> agendamento;

    public ClienteEntity() {
    }
    public ClienteEntity(Long idCliente, String clienteNome, String clienteCpf, String clienteEmail, String clienteSenha, LocalDate clienteDataNascimento, EnderecoEntity endereco) {
        this.idCliente = idCliente;
        this.clienteNome = clienteNome;
        this.clienteCpf = clienteCpf;
        this.clienteEmail = clienteEmail;
        this.clienteSenha = clienteSenha;
        this.clienteDataNascimento = clienteDataNascimento;
        this.endereco = endereco;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public String getClienteSenha() { return clienteSenha;}

    public void setClienteSenha(String clienteSenha) { this.clienteSenha = clienteSenha;}

    public LocalDate getClienteDataNascimento() {
        return clienteDataNascimento;
    }

    public void setClienteDataNascimento(LocalDate clienteDataNascimento) {
        this.clienteDataNascimento = clienteDataNascimento;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<TelefoneEntity> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<TelefoneEntity> telefone) {
        this.telefone = telefone;
    }

    public List<AgendamentoEntity> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<AgendamentoEntity> agendamento) {
        this.agendamento = agendamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(idCliente, that.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "idCliente=" + idCliente +
                ", clienteNome='" + clienteNome + '\'' +
                ", clienteCpf='" + clienteCpf + '\'' +
                ", clienteEmail='" + clienteEmail + '\'' +
                ", clienteSenha='" + clienteSenha + '\'' +
                ", clienteDataNascimento=" + clienteDataNascimento +
                ", endereco=" + endereco +
                '}';
    }

}