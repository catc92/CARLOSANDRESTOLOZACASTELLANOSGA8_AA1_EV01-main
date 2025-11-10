package com.ecommerce.web.controller;

import com.ecommerce.web.modelo.Producto;
import com.ecommerce.web.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// 1. Etiquetas de Controlador REST y URL base
@RestController 
@RequestMapping("/api/v1/productos") 
public class ProductoController {

    // 2. Traemos al administrador de datos (Inyección de Dependencia)
    @Autowired 
    private ProductoRepository productoRepository;

    // A. CREAR (POST) - Guarda un producto nuevo
    @PostMapping 
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // B. LEER TODOS (GET) - Lista todos los productos
    @GetMapping 
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }
    
    // C. LEER POR ID (GET/{id}) - Busca un solo producto
    @GetMapping("/{id}") 
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // D. ACTUALIZAR (PUT) - Modifica un producto existente
    @PutMapping("/{id}") 
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(detallesProducto.getNombre());
                    producto.setDescripcion(detallesProducto.getDescripcion());
                    producto.setPrecio(detallesProducto.getPrecio());
                    producto.setStock(detallesProducto.getStock());
                    producto.setIdCategoria(detallesProducto.getIdCategoria());
                    return ResponseEntity.ok(productoRepository.save(producto));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // E. ELIMINAR (DELETE) - Borra un producto
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content
    }
}