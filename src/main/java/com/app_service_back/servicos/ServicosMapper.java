package com.app_service_back.servicos;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicosMapper {
    @Mapping(source = "idServicos", target = "idServicos")
    ServicosDTO toDTO(ServicosEntity servicos);

    @Mapping(source = "servicosDTO.idServicos", target = "idServicos")
    ServicosEntity toEntity(ServicosDTO servicosDTO);

    List<ServicosDTO> toDTO(List<ServicosEntity> servicoss);

    @Mappings({
            @Mapping(source = "servicosDTO.idServicos", target = "idServicos"),
            @Mapping(source = "servicosDTO.servicosNome", target = "servicosNome"),
            @Mapping(source = "servicosDTO.servicosPreco", target = "servicosPreco"),
            @Mapping(source = "servicosDTO.servicosDescricao", target = "servicosDescricao"),
            @Mapping(source = "servicosDTO.servicosInformacoesAdicionais", target = "servicosInformacoesAdicionais"),
            @Mapping(source = "servicosDTO.servicosClassificacao", target = "servicosClassificacao"),
            @Mapping(source = "servicosDTO.categoria", target = "categoria"),
            @Mapping(source = "servicosDTO.prestador", target = "prestador")
    })
    ServicosEntity updateEntity(ServicosDTO servicosDTO, ServicosEntity servicos);
}
