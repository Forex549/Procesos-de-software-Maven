/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Giancarlo
 */
public class ProductoTest {
    
    public ProductoTest() {
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

     private static String url="jdbc:mysql://35.247.214.45:3306/bdprocesos";
    private static String user="root";
   private static String pass="Tesla5890";
    
    public static Connection conectar()
    {
       Connection con=null;
       try
       {
       con = DriverManager.getConnection(url,user,pass);
       System.out.println("Conexión exitosa");
       }catch(Exception e)
       {
        e.printStackTrace();
       }
       
       return con;        
    }
    Connection cone = ConexionLoginTest.conectar();
    /**
     * Test of agregarProducto method, of class Producto.
     */
    @Test
    public void testAgregarProducto() {
        System.out.println("agregarProducto");
        float precio = 50.59F;
        int stock = 5;
        String descripcion = "SIRVE PARA USARSE";
        String marca = "AMD";
        String nombre = "procesador ryzen 5";
        String categoria = "procesador";
        Connection con = cone;
        String imagen = "procesador ryzen 7.jpg";
        Producto.agregarProducto(precio, stock, descripcion, marca, nombre, categoria, con, imagen);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of eliminarProducto method, of class Producto.
     */
    @Test
    public void testEliminarProducto() {
        System.out.println("eliminarProducto");
        int ID = 0;
        Connection con = null;
        Producto.eliminarProducto(ID, con);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Actualizar method, of class Producto.
     */
    @Test
    public void testActualizar() {
        System.out.println("Actualizar");
        int ID = 0;
        float precio = 0.0F;
        int stock = 0;
        String descripcion = "";
        String marca = "";
        String nombre = "";
        String categoria = "";
        Connection con = null;
        String imagen = "";
        Producto.Actualizar(ID, precio, stock, descripcion, marca, nombre, categoria, con, imagen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCabecera method, of class Producto.
     */
    @Test
    public void testGetCabecera() {
        System.out.println("getCabecera");
        Producto instance = new Producto();
        String[] expResult = null;
        String[] result = instance.getCabecera();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
