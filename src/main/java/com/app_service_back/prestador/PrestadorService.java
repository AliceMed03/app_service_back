package com.app_service_back.prestador;

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

    //Buscar todos os prestadores
    public List<PrestadorDTO> findAll(){
        List<PrestadorEntity> prestadores = prestadorRepository.findAll();
        return prestadores.stream().map(prestadorMapper::toDTO).collect(Collectors.toList());
    }

    //Buscar uma Prestador pelo id
    public PrestadorDTO findById(Long id){
        PrestadorEntity prestador = prestadorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Prestador não encontrado"));
        return prestadorMapper.toDTO(prestador);
    }

    //Criando uma nova prestador
    public PrestadorDTO create(PrestadorDTO prestadorDTO){
        PrestadorEntity prestador = prestadorMapper.toEntity(prestadorDTO);
        prestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(prestador);
    }

    //Update prestador
    public PrestadorDTO update(Long id, PrestadorDTO prestadorDTO){
        PrestadorEntity prestador = prestadorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Prestador não encontrado"));
        prestadorDTO.setIdPrestador(id);
        prestador = prestadorMapper.updateEntity(prestadorDTO, prestador);
        prestador = prestadorRepository.save(prestador);
        return prestadorMapper.toDTO(prestador);
    }

    //Delete prestador
    public void deleteById(long id){
        prestadorRepository.deleteById(id);
    }
}
