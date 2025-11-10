package com.ecommerce.web.modelo;

import jakarta.persistence.*; // Importamos las herramientas mágicas de JPA

// 1. Etiqueta mágica para que Hibernate sepa que esto es una tabla de BD
@Entity 
@Table(name = "producto") // Le decimos cómo se llama la tabla en la BD
public class Producto {

    // Variables internas (Atributos del MER)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    private String nombre;
    private String descripcion;
    private Double precio; // Usamos Double para los precios
    private Integer stock; // Usamos Integer para el inventario

    // NOTA IMPORTANTE: Para la FK id_categoria, la dejaremos simple por ahora,
    // pero en un proyecto real usaríamos @ManyToOne para la relación con Categoria.
    private Long idCategoria; // (FK simple por simplificación)
    
    // 2. Generar Constructor vacío (siempre necesario para JPA)
    public Producto() {}

    public Object getDescripcion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescripcion'");
    }

    public void setDescripcion(Object descripcion2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDescripcion'");
    }

    public Object getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public void setNombre(Object nombre2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

    public Object getPrecio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrecio'");
    }

    public void setPrecio(Object precio2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrecio'");
    }

    public Object getStock() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStock'");
    }

    public void setStock(Object stock2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStock'");
    }

    public Object getIdCategoria() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdCategoria'");
    }

    public void setIdCategoria(Object idCategoria2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIdCategoria'");
    }

    public void setIdProducto(long l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIdProducto'");
    }

    // 3. Generar Getters y Setters (los métodos que permiten "leer" y "escribir" las variables)
    // *En tu IDE, clic derecho -> Source Actions -> Generate Getters and Setters*
    
    // ... Aquí va todo el código de los métodos getNombre(), setNombre(), getPrecio(), etc. ...
}