package com.app_service_back.telefone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private TelefoneMapper telefoneMapper;

    //Buscar todos os telefones
    public List<TelefoneDTO> findAll(){
        List<TelefoneEntity> telefones = telefoneRepository.findAll();
        return telefones.stream().map(telefoneMapper::toDTO).collect(Collectors.toList());
    }

    //Buscar um telefone pelo id
    public TelefoneDTO findById(Long id){
        TelefoneEntity telefone = telefoneRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Telefone não encontrado"));
        return telefoneMapper.toDTO(telefone);
    }

    //Criando um novo telefone
    public TelefoneDTO create(TelefoneDTO telefoneDTO){
        TelefoneEntity telefone = telefoneMapper.toEntity(telefoneDTO);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }

    //Update telefone
    public TelefoneDTO update(Long id, TelefoneDTO telefoneDTO){
        TelefoneEntity telefone = telefoneRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Telefone não encontrado"));
        telefoneDTO.setIdTelefone(id);
        telefone = telefoneMapper.updateEntity(telefoneDTO, telefone);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }

    //Delete telefone
    public void deleteById(long id){
        telefoneRepository.deleteById(id);
    }
}
