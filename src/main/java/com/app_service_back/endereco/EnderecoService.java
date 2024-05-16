package com.app_service_back.endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    //Buscar todos os endereços
    public List<EnderecoDTO> findAll(){
        List<EnderecoEntity> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(enderecoMapper::toDTO).collect(Collectors.toList());
    }

    //Buscar uma endereço pelo id
    public EnderecoDTO findById(Long id){
        EnderecoEntity endereco = enderecoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Endereço não encontrado"));
        return enderecoMapper.toDTO(endereco);
    }

    //Criando uma nova endereço
    public EnderecoDTO create(EnderecoDTO enderecoDTO){
        EnderecoEntity endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    //Update endereço
    public EnderecoDTO update(Long id, EnderecoDTO enderecoDTO){
        EnderecoEntity endereco = enderecoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Endereço não encontrado"));
        enderecoDTO.setIdEndereco(id);
        endereco = enderecoMapper.updateEntity(enderecoDTO, endereco);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    //Delete endereço
    public void deleteById(long id){
        enderecoRepository.deleteById(id);
    }
}

