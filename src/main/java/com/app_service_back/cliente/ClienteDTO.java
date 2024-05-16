package com.app_service_back.cliente;

import com.app_service_back.endereco.EnderecoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import java.io.Serializable;
import java.time.LocalDate;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idCliente;
    @NotNull(message = "O campo NOME é requerido.")
    private String clienteNome;
    @CPF
    @NotNull(message = "O campo CPF é requerido.")
    private String clienteCpf;
    @NotNull(message = "O campo EMAIL é requerido.")
    private String clienteEmail;
    @JsonIgnore
    private String clienteSenha;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "O campo DATA DE NASCIMENTO é requerido.")
    private LocalDate clienteDataNascimento;
    private EnderecoEntity endereco;
    //private List<TelefoneEntity> telefone = new ArrayList<>();
    //private List<AgendamentoEntity> agendamento = new ArrayList<>();


    public ClienteDTO() {
    }
    public ClienteDTO(Long idCliente, String clienteNome, String clienteCpf, String clienteEmail, String clienteSenha, LocalDate clienteDataNascimento, EnderecoEntity endereco) {
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
}
