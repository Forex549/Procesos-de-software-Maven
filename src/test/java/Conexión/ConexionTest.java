/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Conexión;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Ronnie Herrera
 */
public class ConexionTest {
    
    public ConexionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of conectar method, of class Conexion.
     */
        Connection con;
    @Test

    public void testConectar() {
        
        System.out.println("Iniciando prueba de conexión...");

        // Instancia de la clase a probar
        Conexion instance = new Conexion();

        // Ejecutar el método a probar
        Connection result = instance.conectar();

        // Validar que la conexión no sea null
        assertNotNull(result, "La conexión no debe ser null");

        // Validar que la conexión esté activa
        try {
            assertTrue(!result.isClosed(), "La conexión debe estar abierta");
        } catch (SQLException e) {
            fail("Error al verificar el estado de la conexión: " + e.getMessage());
        }

        System.out.println("Prueba de conexión completada con éxito.");
    }
    
    
}
