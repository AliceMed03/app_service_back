package com.app_service_back.servicos;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController // habilitar o REST
@RequestMapping("/servicos")
public class ServicosController {
    @Autowired
    private ServicosService servicosService;

    @GetMapping
    public ResponseEntity<List<ServicosDTO>> getAllServicos(){
        List<ServicosDTO> servicosDTO = servicosService.findAll();


        try {
            return ResponseEntity.ok(servicosDTO);
        }catch (HttpMessageNotWritableException e){

            System.out.println("a");
        }

        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServicosDTO> getServicosById(@PathVariable Long id){
        ServicosDTO servicosDTO = servicosService.findById(id);
        return ResponseEntity.ok(servicosDTO);
    }
    @PostMapping
    public ResponseEntity<ServicosDTO> createServicosDTO(@Valid @RequestBody ServicosDTO servicosDTO){
        ServicosDTO createServicosDTO = servicosService.create(servicosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createServicosDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ServicosDTO> updateServicosDTO(@PathVariable Long id, @Valid @RequestBody ServicosDTO servicosDTO){
        ServicosDTO updateServicosDTO = servicosService.update(id,servicosDTO);
        return ResponseEntity.ok(updateServicosDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicos(@PathVariable Long id){
        servicosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
