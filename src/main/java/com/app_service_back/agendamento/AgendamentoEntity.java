package com.app_service_back.agendamento;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.enums.StatusEnum;
import com.app_service_back.servicos.ServicosEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "agendamento")
public class AgendamentoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idAgendamento;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD/MM/YYYY")
    private LocalDate agendamentoData; // = LocalDate.now();
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:MM")
    private LocalTime agendamentoHora;
    private String agendamentoObservacao;
    @Enumerated(EnumType.STRING)
    private StatusEnum agendamentoStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agendamentoIdCliente")
    private ClienteEntity cliente;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agendamentoIdServicos")
    private ServicosEntity servicos;

    public AgendamentoEntity() {
    }
    public AgendamentoEntity(Long idAgendamento, LocalDate agendamentoData, LocalTime agendamentoHora, String agendamentoObservacao, StatusEnum agendamentoStatus, ClienteEntity cliente, ServicosEntity servicos) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgendamentoEntity that = (AgendamentoEntity) o;
        return Objects.equals(idAgendamento, that.idAgendamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAgendamento);
    }


    @Override
    public String toString() {
        return "AgendamentoEntity{" +
                "idAgendamento=" + idAgendamento +
                ", agendamentoData=" + agendamentoData +
                ", agendamentoHora=" + agendamentoHora +
                ", agendamentoObservacao='" + agendamentoObservacao + '\'' +
                ", agendamentoStatus=" + agendamentoStatus +
                ", cliente=" + cliente +
                ", servicos=" + servicos +
                '}';
    }
}
