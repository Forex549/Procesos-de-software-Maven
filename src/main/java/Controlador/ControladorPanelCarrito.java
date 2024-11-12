
package Controlador;
import Conexión.Conexion;
import Vista.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
/**
 *
 * @author Giancarlo
 */
public class ControladorPanelCarrito {
    
    private JpanelCarrito panelCarrito;
    private static int IDCliente;
    private Connection con;

    public ControladorPanelCarrito(JpanelCarrito panelCarrito, int IDCliente,Connection con) {
        this.panelCarrito = panelCarrito;
        this.IDCliente = IDCliente;
        this.con = con;
        
        this.panelCarrito.tblProdCarrito.setAutoCreateRowSorter(true);
        
        panelCarrito.txtTotal.setText(String.valueOf(ControladorPanelCarrito.cargarDatos(con, panelCarrito.tblProdCarrito,this.IDCliente)));

    }
    
    private static float cargarDatos(Connection con,JTable tabla,int IDCliente){
        DefaultTableModel modelo = new DefaultTableModel();
        float total = 0;
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("subtotal");
        
        String query = "SELECT cliente.nombres AS cliente, producto.nombre AS producto, "
                     + "carrito.cantidad, producto.precio, "
                     + "(carrito.cantidad * producto.precio) AS subtotal "
                     + "FROM cliente "
                     + "JOIN carrito ON cliente.id_cliente = carrito.cliente_id "
                     + "JOIN producto ON producto.id_producto = carrito.producto_id "
                     + "WHERE cliente.id_cliente = " + IDCliente;
        
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                
                Object[] fila = new Object[4];
                fila[0] = rs.getString("producto");
                fila[1] = rs.getFloat("precio");
                fila[2] = rs.getInt("cantidad");
                fila[3] = rs.getFloat("subtotal");
                total = total + rs.getFloat("subtotal");
                modelo.addRow(fila);
            }
        tabla.setModel(modelo);
            return total;
        
        }catch(SQLException e){
        
            e.printStackTrace();
        }
        
        return total;
    
    }
    
    
    
}
