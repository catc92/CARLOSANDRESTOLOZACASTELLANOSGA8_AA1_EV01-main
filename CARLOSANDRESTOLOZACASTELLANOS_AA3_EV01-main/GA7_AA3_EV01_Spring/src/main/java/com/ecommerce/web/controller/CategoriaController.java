package com.ecommerce.web.controller;

import com.ecommerce.web.modelo.Categoria;
import com.ecommerce.web.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

// CLASE: Cumple con el estándar PascalCase
@RestController // Indica que esta clase maneja peticiones REST (Web/Standalone)
@RequestMapping("/api/v1/categorias") // Define la URL base para este controlador
public class CategoriaController {

    // Inyección de dependencia: Spring crea e inserta automáticamente la implementación del Repositorio
    @Autowired 
    private CategoriaRepository categoriaRepository;

    // 1. CONSULTAR TODOS (READ ALL) - Método GET
    // Método: Estándar camelCase
    @GetMapping // Maneja GET a /api/v1/categorias
    public List<Categoria> listarCategorias() {
        // Llama al método findAll() proporcionado por JpaRepository
        return categoriaRepository.findAll();
    }

    // 2. CREAR (CREATE) - Método POST
    // Método: Estándar camelCase
    @PostMapping // Maneja POST a /api/v1/categorias
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        // Llama al método save() de JpaRepository. JPA lo mapea a un INSERT.
        return categoriaRepository.save(categoria);
    }

    // 3. CONSULTAR POR ID (READ ONE) - Método GET
    // Método: Estándar camelCase
    @GetMapping("/{id}") // Maneja GET a /api/v1/categorias/{id}
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long id) {
        // findById devuelve un Optional (buenas prácticas de Java)
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        
        // Retorna el objeto si existe, si no, retorna 404 Not Found
        return categoria.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. ACTUALIZAR (UPDATE) - Método PUT
    @PutMapping("/{id}") // Maneja PUT a /api/v1/categorias/{id}
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria detallesCategoria) {
        // Primero, busca si existe
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(id);
        
        if (categoriaExistente.isPresent()) {
            Categoria categoria = categoriaExistente.get();
            // Actualiza los campos (uso de getters/setters implícitos por Lombok)
            categoria.setNombre(detallesCategoria.getNombre());
            categoria.setDescripcion(detallesCategoria.getDescripcion());
            
            // Llama a save(). JPA detecta que el objeto tiene un ID y lo mapea a un UPDATE.
            return ResponseEntity.ok(categoriaRepository.save(categoria));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. ELIMINAR (DELETE) - Método DELETE
    @DeleteMapping("/{id}") // Maneja DELETE a /api/v1/categorias/{id}
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        // Llama al método deleteById() de JpaRepository.
        categoriaRepository.deleteById(id);
        // Retorna 204 No Content
        return ResponseEntity.noContent().build();
    }
}