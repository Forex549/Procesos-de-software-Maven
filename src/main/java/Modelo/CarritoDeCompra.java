
package Modelo;

import Conexión.Conexion;
import java.sql.*;

public class CarritoDeCompra {
    
    private final String[] cabecera = {"ID", "Nombre", "Cantidad", "Precio unitario", "Total"};
    
    public static boolean agregarAlCarrito (int productoID, int cantidad, Connection con,int cliente_id){
        boolean res = false;
        String consulta = "{CALL agregarACarrito(?,?,?)}"; //funcional
        try {
            CallableStatement procedimiento = con.prepareCall(consulta);
            procedimiento.setInt(1, cantidad);
            procedimiento.setInt(2, cliente_id);
            procedimiento.setInt(3,productoID);
            procedimiento.execute();
            
            res = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
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
   public static void getCarritoUsuario(int idCliente){ //FUNCIONAL
   
       String query = "SELECT cliente.nombres AS cliente, producto.nombre AS producto, "
                     + "carrito.cantidad, producto.precio, "
                     + "(carrito.cantidad * producto.precio) AS subtotal "
                     + "FROM cliente"
                     + "JOIN carrito ON cliente.id_cliente = carrito.cliente_id"
                     + "JOIN producto ON producto.id_producto = carrito.producto_id "
                     + "WHERE cliente.id_cliente " + idCliente;
        
        Conexion conexion = new Conexion();
        try (Connection conn = conexion.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
           
            while (rs.next()){
                String nombreUsuario = rs.getString("cliente");
                String nombreProducto = rs.getString("producto");
                int cantidad = rs.getInt("cantidad");
                float precio = rs.getFloat("precio");
                float subtotal = rs.getFloat("subtotal");
                
                System.out.println("Usuario: " + nombreUsuario);
                System.out.println("Producto: " + nombreProducto);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Precio unitario: " + precio);
                System.out.println("Subtotal: " + subtotal);
                System.out.println("------------------------------------");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
   }
     
}
