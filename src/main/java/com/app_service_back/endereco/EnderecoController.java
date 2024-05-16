package com.app_service_back.endereco;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // habilitar o REST
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> getAllEndereco(){
        List<EnderecoDTO> enderecoDTO = enderecoService.findAll();
        return ResponseEntity.ok(enderecoDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable Long id){
        EnderecoDTO enderecoDTO = enderecoService.findById(id);
        return ResponseEntity.ok(enderecoDTO);
    }
    @PostMapping
    public ResponseEntity<EnderecoDTO> createEnderecoDTO(@Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO createEnderecoDTO = enderecoService.create(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEnderecoDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> updateEnderecoDTO(@PathVariable Long id, @Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO updateEnderecoDTO = enderecoService.update(id,enderecoDTO);
        return ResponseEntity.ok(updateEnderecoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
