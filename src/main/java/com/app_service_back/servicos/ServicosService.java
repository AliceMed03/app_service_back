package com.app_service_back.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicosService {
    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private ServicosMapper servicosMapper;

    //Buscar todos os servicos
    public List<ServicosDTO> findAll(){
        List<ServicosEntity> servicos = servicosRepository.findAll();
        return servicos.stream().map(servicosMapper::toDTO).collect(Collectors.toList());
    }

    //Buscar um servicos pelo id
    public ServicosDTO findById(Long id){
        ServicosEntity servicos = servicosRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Servicos não encontrados"));
        return servicosMapper.toDTO(servicos);
    }

    //Criando um novo servicos
    public ServicosDTO create(ServicosDTO servicosDTO){
        ServicosEntity servicos = servicosMapper.toEntity(servicosDTO);
        servicos = servicosRepository.save(servicos);
        return servicosMapper.toDTO(servicos);
    }

    //Update servicos
    public ServicosDTO update(Long id, ServicosDTO servicosDTO){
        ServicosEntity servicos = servicosRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Servicos não encontrados"));
        servicosDTO.setIdServicos(id);
        servicos = servicosMapper.updateEntity(servicosDTO, servicos);
        servicos = servicosRepository.save(servicos);
        return servicosMapper.toDTO(servicos);
    }

    //Delete servicos
    public void deleteById(long id){
        servicosRepository.deleteById(id);
    }
}
