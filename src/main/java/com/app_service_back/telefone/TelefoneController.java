package com.app_service_back.telefone;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController // habilitar o REST
@RequestMapping("/telefone")
public class TelefoneController {
    @Autowired
    private TelefoneService telefoneService;

    @GetMapping
    public ResponseEntity<List<TelefoneDTO>> getAllTelefones(){
        List<TelefoneDTO> telefoneDTO = telefoneService.findAll();


        try {
            return ResponseEntity.ok(telefoneDTO);
        }catch (HttpMessageNotWritableException e){

            System.out.println("a");
        }

        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> getTelefoneById(@PathVariable Long id){
        TelefoneDTO telefoneDTO = telefoneService.findById(id);
        return ResponseEntity.ok(telefoneDTO);
    }
    @PostMapping
    public ResponseEntity<TelefoneDTO> createTelefoneDTO(@Valid @RequestBody TelefoneDTO telefoneDTO){
        TelefoneDTO createTelefoneDTO = telefoneService.create(telefoneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTelefoneDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> updateTelefoneDTO(@PathVariable Long id, @Valid @RequestBody TelefoneDTO telefoneDTO){
        TelefoneDTO updateTelefoneDTO = telefoneService.update(id,telefoneDTO);
        return ResponseEntity.ok(updateTelefoneDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefone(@PathVariable Long id){
        telefoneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
