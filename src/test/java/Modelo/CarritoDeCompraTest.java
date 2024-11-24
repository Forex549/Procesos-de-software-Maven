/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import java.sql.Connection;
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
public class CarritoDeCompraTest {
    
    public CarritoDeCompraTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    /*@BeforeAll
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
    }*/

    /**
     * Test of agregarAlCarrito method, of class CarritoDeCompra.
     */
    @org.junit.jupiter.api.Test
    public void testAgregarAlCarrito() {
        System.out.println("agregarAlCarrito");
        int productoID = 0;
        int cantidad = 0;
        Connection con = null;
        int cliente_id = 0;
        boolean expResult = false;
        boolean result = CarritoDeCompra.agregarAlCarrito(productoID, cantidad, con, cliente_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarDelCarrito method, of class CarritoDeCompra.
     */
    @org.junit.jupiter.api.Test
    public void testEliminarDelCarrito() {
        System.out.println("eliminarDelCarrito");
        int productoID = 0;
        Connection con = null;
       // CarritoDeCompra.eliminarDelCarrito(productoID, con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarCantidad method, of class CarritoDeCompra.
     */
    @org.junit.jupiter.api.Test
    public void testActualizarCantidad() {
        System.out.println("actualizarCantidad");
        int productoID = 0;
        int nuevaCantidad = 0;
        Connection con = null;
        CarritoDeCompra.actualizarCantidad(productoID, nuevaCantidad, con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCabecera method, of class CarritoDeCompra.
     */
    @org.junit.jupiter.api.Test
    public void testGetCabecera() {
        System.out.println("getCabecera");
        CarritoDeCompra instance = new CarritoDeCompra();
        String[] expResult = null;
        String[] result = instance.getCabecera();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarritoUsuario method, of class CarritoDeCompra.
     */
    @org.junit.jupiter.api.Test
    public void testGetCarritoUsuario() {
        System.out.println("getCarritoUsuario");
        int idCliente = 0;
        CarritoDeCompra.getCarritoUsuario(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
