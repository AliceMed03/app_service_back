package com.app_service_back.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    //Buscar todos os clientes
    public List<ClienteDTO> findAll(){
        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::toDTO).collect(Collectors.toList());
    }

    //Buscar uma Cliente pelo id
    public ClienteDTO findById(Long id){
        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Cliente não encontrado"));
        return clienteMapper.toDTO(cliente);
    }

    //Criando uma nova Cliente
    public ClienteDTO create(ClienteDTO clienteDTO){
        ClienteEntity cliente = clienteMapper.toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    //Update Cliente
    public ClienteDTO update(Long id, ClienteDTO clienteDTO){
        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Cliente não encontrado"));
        clienteDTO.setIdCliente(id);
        cliente = clienteMapper.updateEntity(clienteDTO, cliente);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }

    //Delete Cliente
    public void deleteById(long id){
        clienteRepository.deleteById(id);
    }
}
