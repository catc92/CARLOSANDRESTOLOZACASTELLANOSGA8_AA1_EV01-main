package com.ecommerce.web.repository;

import com.ecommerce.web.modelo.Producto; // Importamos el plano que acabamos de crear
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 1. Etiqueta mágica para que Spring sepa que es un Repositorio
@Repository 
// 2. Le decimos a JpaRepository qué Entidad (Producto) va a manejar y el tipo de su ID (Long)
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    // ¡Listo! No necesitamos escribir ningún código. JpaRepository nos da
    // gratis los métodos findAll, findById, save, deleteById, etc.

}