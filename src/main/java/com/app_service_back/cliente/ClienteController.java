package com.app_service_back.cliente;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController // habilitar o REST
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes(){
        List<ClienteDTO> clienteDTO = clienteService.findAll();


        try {
            return ResponseEntity.ok(clienteDTO);
        }catch (HttpMessageNotWritableException e){

            System.out.println("a");
        }

        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.findById(id);
        return ResponseEntity.ok(clienteDTO);
    }
    @PostMapping
    public ResponseEntity<ClienteDTO> createClienteDTO(@Valid @RequestBody ClienteDTO clienteDTO){
        ClienteDTO createClienteDTO = clienteService.create(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createClienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateClienteDTO(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO){
        ClienteDTO updateClienteDTO = clienteService.update(id,clienteDTO);
        return ResponseEntity.ok(updateClienteDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
