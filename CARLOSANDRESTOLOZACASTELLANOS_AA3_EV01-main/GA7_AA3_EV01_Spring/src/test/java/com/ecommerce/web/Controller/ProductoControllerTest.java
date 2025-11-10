package com.ecommerce.web.Controller;

import com.ecommerce.web.controller.ProductoController;
import com.ecommerce.web.modelo.Producto;
import com.ecommerce.web.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import static org.mockito.Mockito.when; // Herramienta para "fingir" resultados
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Le decimos a Spring que solo queremos probar la capa Web (Controller)
@WebMvcTest(ProductoController.class) 
public class ProductoControllerTest {

    // La herramienta para simular peticiones HTTP
    @Autowired 
    private MockMvc mockMvc; 

    // Fingimos (Mock) el repositorio, para que la prueba no use la BD real
    @MockBean 
    private ProductoRepository productoRepository;

    // Prueba para el método LEER POR ID (Buscar)
    @Test
    void obtenerProductoPorId_DebeRetornarProducto() throws Exception {
        // 1. Preparamos el escenario: Creamos un producto de prueba
        Producto productoDePrueba = new Producto();
        productoDePrueba.setIdProducto(1L);
        productoDePrueba.setNombre("Laptop");

        // 2. Definimos el comportamiento FINGIDO: 
        // Cuando alguien llame al repositorio.findById(1L), fingimos que devuelve nuestro producto de prueba.
        when(productoRepository.findById(1L)).thenReturn(Optional.of(productoDePrueba));

        // 3. Ejecutamos la prueba: Simulamos una petición GET a /api/v1/productos/1
        mockMvc.perform(get("/api/v1/productos/1"))
                // 4. Verificamos los resultados (Assertions):
                .andExpect(status().isOk()) // Debe ser 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Debe ser JSON
                .andExpect(jsonPath("$.nombre").value("Laptop")); // El nombre debe ser "Laptop"
    }
    
    // Prueba para un producto no encontrado (404)
     @Test
    void obtenerProductoPorId_DebeRetornarNotFound() throws Exception {
        // 1. Fingimos que la búsqueda no encuentra nada
        when(productoRepository.findById(2L)).thenReturn(Optional.empty()); 

        // 2. Simulamos la petición GET a /api/v1/productos/2
        mockMvc.perform(get("/api/v1/productos/2"))
                // 3. Verificamos el resultado: Debe ser 404 NOT FOUND
                .andExpect(status().isNotFound()); 
    }
}