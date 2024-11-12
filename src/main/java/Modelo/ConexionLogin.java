
package Modelo;

import Conexión.Conexión;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionLogin {
    
    // Método para verificar el usuario y la contraseña
    public boolean verificarUsuario(String username, String password,Connection con,int ID) {
        
        boolean res = false;
        String sql = "{CALL loguearPersona(?,?,?,?)}";

        try  {
            
            CallableStatement consulta = con.prepareCall(sql);
            consulta.setString(1,username);
            consulta.setString(2,password);
           
            // Registra el parámetro de salida (OUT)
            consulta.registerOutParameter(3, java.sql.Types.BOOLEAN); // El tercer parámetro es el OUT (resultado)
            consulta.registerOutParameter(4, java.sql.Types.INTEGER); // ID del cliente
            
            consulta.execute();
            
            res = consulta.getBoolean(3);
            ID = consulta.getInt(4);
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        return res;
    }
    
    public boolean esAdmin(String username, String password){
        boolean res = false;
        
        String usuario = "gerar.0509@gmail.com";
        String contraseña = "contras123";
        
        if(username.equals(usuario) && password.equals(contraseña)){
            res = true;
        }
        
        return res;
    }   
}

