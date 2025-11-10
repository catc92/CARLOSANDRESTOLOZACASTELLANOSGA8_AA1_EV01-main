package com.ecommerce.web.repository;

import com.ecommerce.web.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CLASE: Cumple con el estándar PascalCase
@Repository // Indica que esta interfaz es un componente de acceso a datos
// Heredamos de JpaRepository, que ya trae los métodos: save (CREATE/UPDATE), findById (READ), findAll (READ all), deleteById (DELETE)
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    // COMENTARIOS: Podemos añadir métodos personalizados si fuera necesario, Spring los implementa automáticamente:
    // List<Categoria> findByNombre(String nombre); 
}