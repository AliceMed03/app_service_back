package com.app_service_back.agendamento;

import com.app_service_back.cliente.ClienteEntity;
import com.app_service_back.enums.StatusEnum;
import com.app_service_back.servicos.ServicosEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idAgendamento;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "O campo DATA é requerido.")
    private LocalDate agendamentoData; // = LocalDate.now();
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "O campo HORA é requerido.")
    private LocalTime agendamentoHora;
    private String agendamentoObservacao;
    //@Enumerated(EnumType.STRING)
    private StatusEnum agendamentoStatus;
    private ClienteEntity cliente;
    private ServicosEntity servicos;

}
