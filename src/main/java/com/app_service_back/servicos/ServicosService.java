package com.app_service_back.servicos;

import com.app_service_back.prestador.*;
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
    @Autowired
    private PrestadorService prestadorService;

    //buscando todos os servicos
    public List<ServicosDTO> findAll(){
        List<ServicosEntity> servicos = servicosRepository.findAll();
        return servicos.stream().map(servicosMapper::toDTO).collect(Collectors.toList());
    }
    // buscar pelo id
    public ServicosDTO findById(Long id){
        ServicosEntity servicos = servicosRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Serviço não encontrado"));
        return servicosMapper.toDTO(servicos);
    }
    //criando um novo serviço
    public ServicosDTO create(ServicosDTO servicosDTO){
        ServicosEntity servicos = servicosMapper.toEntity(servicosDTO);
        servicos = servicosRepository.save(servicos);
        return servicosMapper.toDTO(servicos);
    }
    //update serviços
    public ServicosDTO update(Long id, ServicosDTO servicosDTO) {
        ServicosEntity servicos = servicosRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Serviço não encontrado"));
        servicosDTO.setIdServicos(id);
        servicos = servicosMapper.updateEntity(servicosDTO, servicos);
        servicos = servicosRepository.save(servicos);
        return servicosMapper.toDTO(servicos);
    }
    public void deleteById(Long id){
        servicosRepository.deleteById(id);
    }

    // New method to get prestadores by service ID
//    @GetMapping("/{servicoId}/prestadores")
//    public ResponseEntity<List<PrestadorDTO>> getPrestadoresByServicoId(@PathVariable Long servicoId) {
//        Servicos servicos = servicosRepository.findById(servicoId).orElseThrow(() -> new IllegalArgumentException("Serviço não encontrado"));
//        List<PrestadorDTO> prestadores = servicosRepository.findPrestadoresByServico(servicos);
//        return ResponseEntity.ok(prestadores);
//    }

}