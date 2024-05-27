package com.app_service_back.agendamento;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.enums.StatusEnum;
import com.app_service_back.servicos.ServicosEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idAgendamento;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "O campo DATA DE AGENDAMENTO é requerido.")
    private LocalDate agendamentoData; // = LocalDate.now();
    @JsonFormat(pattern = "HH:MM")
    @NotNull(message = "O campo HORA DO AGENDAMENTO é requerido.")
    private LocalTime agendamentoHora;
    private String agendamentoObservacao;
    //@Enumerated(EnumType.STRING)
    private StatusEnum agendamentoStatus;
    private ClienteEntity cliente;
    private ServicosEntity servicos;

    public AgendamentoDTO() {
    }
    public AgendamentoDTO(Long idAgendamento, LocalDate agendamentoData, LocalTime agendamentoHora, String agendamentoObservacao, StatusEnum agendamentoStatus, ClienteEntity cliente, ServicosEntity servicos) {
        this.idAgendamento = idAgendamento;
        this.agendamentoData = agendamentoData;
        this.agendamentoHora = agendamentoHora;
        this.agendamentoObservacao = agendamentoObservacao;
        this.agendamentoStatus = agendamentoStatus;
        this.cliente = cliente;
        this.servicos = servicos;
    }

    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public LocalDate getAgendamentoData() {
        return agendamentoData;
    }

    public void setAgendamentoData(LocalDate agendamentoData) {
        this.agendamentoData = agendamentoData;
    }

    public LocalTime getAgendamentoHora() {
        return agendamentoHora;
    }

    public void setAgendamentoHora(LocalTime agendamentoHora) {
        this.agendamentoHora = agendamentoHora;
    }

    public String getAgendamentoObservacao() {
        return agendamentoObservacao;
    }

    public void setAgendamentoObservacao(String agendamentoObservacao) {
        this.agendamentoObservacao = agendamentoObservacao;
    }

    public StatusEnum getAgendamentoStatus() {
        return agendamentoStatus;
    }

    public void setAgendamentoStatus(StatusEnum agendamentoStatus) {
        this.agendamentoStatus = agendamentoStatus;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public ServicosEntity getServicos() {
        return servicos;
    }

    public void setServicos(ServicosEntity servicos) {
        this.servicos = servicos;
    }
}
