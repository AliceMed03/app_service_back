package com.app_service_back.categoria;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController // habilitar o REST
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategoria(){
        List<CategoriaDTO> categoriaDTO = categoriaService.findAll();
        return ResponseEntity.ok(categoriaDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Long id){
        CategoriaDTO categoriaDTO = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaDTO);
    }
    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoriaDTO(@Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO createCategoriaDTO = categoriaService.create(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategoriaDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoriaDTO(@PathVariable Long id, @Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO updateCategoriaDTO = categoriaService.update(id,categoriaDTO);
        return ResponseEntity.ok(updateCategoriaDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
