package com.app_service_back.agendamento;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AgendamentoMapper {
    @Mapping(source = "idAgendamento", target = "idAgendamento")
    AgendamentoDTO toDTO(AgendamentoEntity agendamento);

    @Mapping(source = "agendamentoDTO.idAgendamento", target = "idAgendamento")
    AgendamentoEntity toEntity(AgendamentoDTO agendamentoDTO);

    List<AgendamentoDTO> toDTO(List<AgendamentoEntity> agendamentos);

    @Mappings({
            @Mapping(source = "agendamentoDTO.idAgendamento", target = "idAgendamento"),
            @Mapping(source = "agendamentoDTO.agendamentoData", target = "agendamentoData"),
            @Mapping(source = "agendamentoDTO.agendamentoHora", target = "agendamentoHora"),
            @Mapping(source = "agendamentoDTO.agendamentoObservacao", target = "agendamentoObservacao"),
            @Mapping(source = "agendamentoDTO.agendamentoStatus", target = "agendamentoStatus"),
            @Mapping(source = "agendamentoDTO.cliente", target = "cliente"),
            @Mapping(source = "agendamentoDTO.servicos", target = "servicos"),
    })
    AgendamentoEntity updateEntity(AgendamentoDTO agendamentoDTO, AgendamentoEntity agendamento);
}
