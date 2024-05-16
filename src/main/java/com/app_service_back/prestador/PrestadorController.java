package com.app_service_back.prestador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // habilitar o REST
@RequestMapping("/prestador")
public class PrestadorController {
    @Autowired
    private PrestadorService prestadorService;

    @GetMapping
    public ResponseEntity<List<PrestadorDTO>> getAllPrestadores(){
        List<PrestadorDTO> prestadorDTO = prestadorService.findAll();
        return ResponseEntity.ok(prestadorDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PrestadorDTO> getPrestadorById(@PathVariable Long id){
        PrestadorDTO prestadorDTO = prestadorService.findById(id);
        return ResponseEntity.ok(prestadorDTO);
    }
    @PostMapping
    public ResponseEntity<PrestadorDTO> createPrestadorDTO(@Valid @RequestBody PrestadorDTO prestadorDTO){
        PrestadorDTO createPrestadorDTO = prestadorService.create(prestadorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPrestadorDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PrestadorDTO> updatePrestadorDTO(@PathVariable Long id, @Valid @RequestBody PrestadorDTO prestadorDTO){
        PrestadorDTO updatePrestadorDTO = prestadorService.update(id,prestadorDTO);
        return ResponseEntity.ok(updatePrestadorDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestador(@PathVariable Long id){
        prestadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
