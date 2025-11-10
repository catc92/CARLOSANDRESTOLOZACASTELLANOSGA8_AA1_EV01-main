package com.ecommerce.web.modelo;

import jakarta.persistence.Entity; // Anotación JPA (Jakarta Persistence API)
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// CLASE: Cumple con el estándar PascalCase
@Entity
@Table(name = "categoria") // Mapea a la tabla 'categoria' en PostgreSQL
public class Categoria {

    // VARIABLES: Estándar camelCase (idCategoria)
    
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idCategoria; 

    private String nombre_categoria; 
    
    private String descripcion;

    public Object getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public void setNombre(Object nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }
    
    
}