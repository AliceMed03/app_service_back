package com.app_service_back.prestador;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PrestadorMapper {
    @Mapping(source = "idPrestador", target = "idPrestador")
    PrestadorDTO toDTO(PrestadorEntity prestador);

    @Mapping(source = "prestadorDTO.idPrestador", target = "idPrestador")
    PrestadorEntity toEntity(PrestadorDTO prestadorDTO);

    List<PrestadorDTO> toDTO(List<PrestadorEntity> prestadores);

    @Mappings({
            @Mapping(source = "prestadorDTO.idPrestador", target = "idPrestador"),
            @Mapping(source = "prestadorDTO.prestadorNome", target = "prestadorNome"),
            @Mapping(source = "prestadorDTO.prestadorCpf", target = "prestadorCpf"),
            @Mapping(source = "prestadorDTO.prestadorRazaoSocial", target = "prestadorRazaoSocial"),
            @Mapping(source = "prestadorDTO.prestadorNomeFantasia", target = "prestadorNomeFantasia"),
            @Mapping(source = "prestadorDTO.prestadorCnpj", target = "prestadorCnpj"),
            @Mapping(source = "prestadorDTO.prestadorEmail", target = "prestadorEmail"),
            @Mapping(source = "prestadorDTO.prestadorSenha", target = "prestadorSenha"),
            @Mapping(source = "prestadorDTO.prestadortelefone", target = "prestadortelefone"),
            @Mapping(source = "prestadorDTO.endereco", target = "endereco"),
            @Mapping(source = "prestadorDTO.servicos", target = "servicos")
    })
    PrestadorEntity updateEntity(PrestadorDTO prestadorDTO, PrestadorEntity prestador);
}
