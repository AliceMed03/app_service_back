package com.app_service_back.agendamento;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // habilitar o REST
@RequestMapping("/agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> getAllAgendamentos(){
        List<AgendamentoDTO> agendamentoDTO = agendamentoService.findAll();


        try {
            return ResponseEntity.ok(agendamentoDTO);
        }catch (HttpMessageNotWritableException e){

            System.out.println("a");
        }

        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> getAgendamentoById(@PathVariable Long id){
        AgendamentoDTO agendamentoDTO = agendamentoService.findById(id);
        return ResponseEntity.ok(agendamentoDTO);
    }
    @PostMapping
    public ResponseEntity<AgendamentoDTO> createAgendamentoDTO(@Valid @RequestBody AgendamentoDTO agendamentoDTO){
        AgendamentoDTO createAgendamentoDTO = agendamentoService.create(agendamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAgendamentoDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> updateAgendamentoDTO(@PathVariable Long id, @Valid @RequestBody AgendamentoDTO agendamentoDTO){
        AgendamentoDTO updateAgendamentoDTO = agendamentoService.update(id,agendamentoDTO);
        return ResponseEntity.ok(updateAgendamentoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable Long id){
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
