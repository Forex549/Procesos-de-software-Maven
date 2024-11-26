
package Modelo;

import Conexión.Conexión;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;

public class ConexionLogin {
    
    // Método para verificar el usuario y la contraseña
    public static int verificarUsuario(String username, String password,Connection con) {
        int idCliente = -1;
        
        String sql = "{CALL loguearPersona(?,?,?,?)}";

        try  {
            
            CallableStatement consulta = con.prepareCall(sql);
            consulta.setString(1,username);
            consulta.setString(2,password);
           
            // Registra el parámetro de salida (OUT)
            consulta.registerOutParameter(3, java.sql.Types.BOOLEAN); // El tercer parámetro es el OUT (resultado)
            consulta.registerOutParameter(4, java.sql.Types.INTEGER); // ID del cliente
            
            consulta.execute();
            boolean isAuthenticated = consulta.getBoolean(3);
            
           if (isAuthenticated) {
            idCliente = consulta.getInt(4); // Obtenemos el ID solo si la autenticación fue exitosa
            } 

        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        return idCliente;
    }
    
    public static boolean esAdmin(String username, String password,Connection con){
        boolean res = false;
        
        String sql = "{CALL esAdmin(?,?,?)}";
        
        
        try{
        CallableStatement consulta = con.prepareCall(sql);
        consulta.setString(2, username);
        consulta.setString(3, password);
        
        consulta.registerOutParameter(1, java.sql.Types.BOOLEAN);
        
        consulta.execute();
        
        res = consulta.getBoolean(1);
        
        
        }catch(Exception e){
            e.printStackTrace();
        }

        return res;
    }
    public static boolean registrarCliente(String nombres, String apellidos, String correo, String telefono, String direccion, String password, Connection con) {
        String sql = "{CALL crearUsuario(?,?,?,?,?,?)}";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, nombres);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, correo);
            pstmt.setString(4, direccion);
            pstmt.setString(5, telefono);
            pstmt.setString(6, password);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}

