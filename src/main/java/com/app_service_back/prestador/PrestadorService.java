
package com.app_service_back.prestador;

import com.app_service_back.servicos.ServicosEntity;
import com.app_service_back.servicos.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrestadorService {
    @Autowired
    private PrestadorRepository prestadorRepository;
    @Autowired
    private PrestadorMapper prestadorMapper;
    @Autowired
    private ServicosRepository servicosRepository;

    //buscando todos os prestadores
    public List<PrestadorDTO> findAll(){
        List<PrestadorEntity> prestadores = prestadorRepository.findAll();
        return prestadores.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }

    // buscar pelo id
    public PrestadorDTO findById(Long id){
        PrestadorEntity prestador = prestadorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Prestador não encontrado"));
        return prestadorMapper.toDTO(prestador);
    }

    //criando um novo prestador
    public PrestadorDTO create(PrestadorDTO prestadorDTO){
        PrestadorEntity prestador = prestadorMapper.toEntity(prestadorDTO);
        prestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(prestador);
    }

    //update prestador
    public PrestadorDTO update(Long id, PrestadorDTO prestadorDTO) {
        PrestadorEntity prestador = prestadorRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Prestador não encontrado"));
        prestadorDTO.setIdPrestador(id);
        prestador = prestadorMapper.updateEntity(prestadorDTO, prestador);
        prestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(prestador);
    }

    public void deleteById(Long id){
        prestadorRepository.deleteById(id);
    }

    public List<PrestadorDTO> findByServicosNome(String servicosNome) {
        List<ServicosEntity> servicos = servicosRepository.findByServicoNome(servicosNome);
        List<PrestadorEntity> prestadores = servicos.stream()
                .map(ServicosEntity::getPrestador)
                .collect(Collectors.toList());
        return prestadores.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }
}
