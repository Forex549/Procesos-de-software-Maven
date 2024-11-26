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
public class ConexionLoginTest {
    
    public ConexionLoginTest() {
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
     * Test of verificarUsuario method, of class ConexionLogin.
     */
    
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
    @Test
    public void testVerificarUsuario() {
        System.out.println("verificarUsuario");
        String username = "gianca.0603@gmail.com";
        String password = "12345678";
        Connection con = cone;
        int expResult = 23;
        int result = ConexionLogin.verificarUsuario(username, password, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of esAdmin method, of class ConexionLogin.
     */
    @Test
    public void testEsAdmin() {
        System.out.println("esAdmin");
        String username = "";
        String password = "";
        Connection con = null;
        boolean expResult = false;
        boolean result = ConexionLogin.esAdmin(username, password, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCliente method, of class ConexionLogin.
     */
    @Test
    public void testRegistrarCliente() {
        System.out.println("registrarCliente");
        String nombres = "";
        String apellidos = "";
        String correo = "";
        String telefono = "";
        String direccion = "";
        String password = "";
        Connection con = null;
        boolean expResult = false;
        boolean result = ConexionLogin.registrarCliente(nombres, apellidos, correo, telefono, direccion, password, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
