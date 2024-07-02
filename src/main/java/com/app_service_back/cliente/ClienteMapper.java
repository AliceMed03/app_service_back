package com.app_service_back.cliente;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    @Mapping(source = "idCliente", target = "idCliente")
    ClienteDTO toDTO(ClienteEntity cliente);

    @Mapping(source = "clienteDTO.idCliente", target = "idCliente")
    ClienteEntity toEntity(ClienteDTO clienteDTO);

    List<ClienteDTO> toDTO(List<ClienteEntity> clientes);

    @Mappings({
            @Mapping(source = "clienteDTO.idCliente", target = "idCliente"),
            @Mapping(source = "clienteDTO.clienteNome", target = "clienteNome"),
            @Mapping(source = "clienteDTO.clienteCpf", target = "clienteCpf"),
            @Mapping(source = "clienteDTO.clienteEmail", target = "clienteEmail"),
            @Mapping(source = "clienteDTO.clienteSenha", target = "clienteSenha"),
            @Mapping(source = "clienteDTO.clienteTelefone", target = "clienteTelefone"),
            @Mapping(source = "clienteDTO.clienteDataNascimento", target = "clienteDataNascimento"),
            @Mapping(source = "clienteDTO.endereco", target = "endereco"),
            @Mapping(source = "clienteDTO.agendamento", target = "agendamento")
    })
    ClienteEntity updateEntity(ClienteDTO clienteDTO, ClienteEntity cliente);
}
