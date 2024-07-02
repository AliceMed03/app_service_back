package com.app_service_back.cliente;

import com.app_service_back.agendamento.AgendamentoEntity;
import com.app_service_back.endereco.EnderecoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idCliente;
    @NotBlank(message = "O campo NOME é requerido.")
    private String clienteNome;
    @CPF
    @NotBlank(message = "O campo CPF é requerido.")
    private String clienteCpf;
    @NotBlank(message = "O campo EMAIL é requerido.")
    private String clienteEmail;
    private String clienteSenha;
    @NotBlank(message = "O campo TELEFONE é requerido.")
    private String clienteTelefone;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "O campo DATA DE NASCIMENTO é requerido.")
    private LocalDate clienteDataNascimento;
    private EnderecoEntity endereco;
    //private String telefoneNumero;
    private List<AgendamentoEntity> agendamento = new ArrayList<>();



    public ClienteDTO() {
    }
    public ClienteDTO(Long idCliente, String clienteNome, String clienteCpf, String clienteEmail, String clienteSenha, LocalDate clienteDataNascimento, EnderecoEntity endereco, String clienteTelefone) {
        this.idCliente = idCliente;
        this.clienteNome = clienteNome;
        this.clienteCpf = clienteCpf;
        this.clienteEmail = clienteEmail;
        this.clienteSenha = clienteSenha;
        this.clienteTelefone = clienteTelefone;
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

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public void setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
    }

    public List<AgendamentoEntity> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<AgendamentoEntity> agendamento) {
        this.agendamento = agendamento;
    }
}
