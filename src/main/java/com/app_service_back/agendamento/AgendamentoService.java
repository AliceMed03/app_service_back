package com.app_service_back.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private AgendamentoMapper agendamentoMapper;

    //Buscar todos os agendamentos
    public List<AgendamentoDTO> findAll(){
        List<AgendamentoEntity> agendamentos = agendamentoRepository.findAll();
        return agendamentos.stream().map(agendamentoMapper::toDTO).collect(Collectors.toList());
    }

    //Buscar um agendamento pelo id
    public AgendamentoDTO findById(Long id){
        AgendamentoEntity agendamento = agendamentoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Agendamento não encontrado"));
        return agendamentoMapper.toDTO(agendamento);
    }

    //Criando um novo agendamento
    public AgendamentoDTO create(AgendamentoDTO agendamentoDTO){
        AgendamentoEntity agendamento = agendamentoMapper.toEntity(agendamentoDTO);
        agendamento = agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDTO(agendamento);
    }

    //Update agendamento
    public AgendamentoDTO update(Long id, AgendamentoDTO agendamentoDTO){
        AgendamentoEntity agendamento = agendamentoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Agendamento não encontrado"));
        agendamentoDTO.setIdAgendamento(id);
        agendamento = agendamentoMapper.updateEntity(agendamentoDTO, agendamento);
        agendamento = agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDTO(agendamento);
    }

    //Delete agendamento
    public void deleteById(long id){
        agendamentoRepository.deleteById(id);
    }
}
