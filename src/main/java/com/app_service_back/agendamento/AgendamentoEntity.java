package com.app_service_back.agendamento;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.enums.StatusEnum;
import com.app_service_back.servicos.ServicosEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}
