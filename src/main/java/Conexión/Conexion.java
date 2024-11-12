/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexión;
//ejm
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Giancarlo
 */
public class Conexion {
    
    private static String url="jdbc:mysql://35.247.214.45:3306/bdprocesos";
    private static String user="root";
   private static String pass="Tesla5890";
    
    public Connection conectar()
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
    
    
}
