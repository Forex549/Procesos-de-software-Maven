
package Modelo;

import java.sql.*;

public class CarritoDeCompra {
    
    private final String[] cabecera = {"ID", "Nombre", "Cantidad", "Precio unitario", "Total"};
    
    public static void agregarAlCarrito (int productoID, int cantidad, Connection con){
        String consulta = "{CALL agregarAlCarrito(?.?)}";
        try {
            CallableStatement procedimiento = con.prepareCall(consulta);
            procedimiento.setInt(1, productoID);
            procedimiento.setInt(2, cantidad);
            procedimiento.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void eliminarDelCarrito(int productoID, Connection con) {
        String consulta = "{CALL eliminarDelCarrito(?)}";
        
        try {
            CallableStatement procedimiento = con.prepareCall(consulta);
            procedimiento.setInt(1, productoID);
            procedimiento.execute();   
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public static void actualizarCantidad(int productoID, int nuevaCantidad, Connection con){
        String consulta = "{CALL actualizarCantidadCarrito(?,?)}";
        try {
            CallableStatement procedimiento = con.prepareCall(consulta);
            procedimiento.setInt(1, productoID);
            procedimiento.setInt(2, nuevaCantidad);
            procedimiento.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public String[] getCabecera() {
        return cabecera;
    }
     
}
