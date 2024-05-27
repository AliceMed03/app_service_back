package com.app_service_back.telefone;

import com.app_service_back.agendamento.AgendamentoDTO;
import com.app_service_back.agendamento.AgendamentoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {
    @Mapping(source = "idTelefone", target = "idTelefone")
    TelefoneDTO toDTO(TelefoneEntity telefone);

    @Mapping(source = "telefoneDTO.idTelefone", target = "idTelefone")
    TelefoneEntity toEntity(TelefoneDTO telefoneDTO);

    List<TelefoneDTO> toDTO(List<TelefoneEntity> telefones);

    @Mappings({
            @Mapping(source = "telefoneDTO.idTelefone", target = "idTelefone"),
            @Mapping(source = "telefoneDTO.telefoneNumero", target = "telefoneNumero"),
            @Mapping(source = "telefoneDTO.cliente", target = "cliente"),
            @Mapping(source = "telefoneDTO.prestador", target = "prestador"),
    })
    TelefoneEntity updateEntity(TelefoneDTO telefoneDTO, TelefoneEntity telefone);
}
