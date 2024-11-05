
package Modelo;

import Conexión.Conexión;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionLogin {
    
    // Método para verificar el usuario y la contraseña
    public boolean verificarUsuario(String username, String password) {
        Conexión conexion = new Conexión();
        Connection con = conexion.conectar();
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // Si hay un resultado, las credenciales son correctas

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

