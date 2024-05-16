package com.app_service_back.endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring")
public interface EnderecoMapper {
        @Mapping(source = "idEndereco", target = "idEndereco")
        EnderecoDTO toDTO(EnderecoEntity endereco);

        @Mapping(source = "enderecoDTO.idEndereco", target = "idEndereco")
        EnderecoEntity toEntity(EnderecoDTO enderecoDTO);

        List<EnderecoDTO> toDTO(List<EnderecoEntity> enderecos);

        @Mappings({
                @Mapping(source = "enderecoDTO.idEndereco", target = "idEndereco"),
                @Mapping(source = "enderecoDTO.enderecoRua", target = "enderecoRua"),
                @Mapping(source = "enderecoDTO.enderecoCep", target = "enderecoCep"),
                @Mapping(source = "enderecoDTO.enderecoNumero", target = "enderecoNumero"),
                @Mapping(source = "enderecoDTO.enderecoComplemento", target = "enderecoComplemento"),
                @Mapping(source = "enderecoDTO.enderecoCidade", target = "enderecoCidade"),
                @Mapping(source = "enderecoDTO.enderecoEstado", target = "enderecoEstado"),
                @Mapping(source = "enderecoDTO.enderecoBairro", target = "enderecoBairro")
        })
        EnderecoEntity updateEntity(EnderecoDTO enderecoDTO, EnderecoEntity endereco);
}
