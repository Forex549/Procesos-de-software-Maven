
package Controlador;
import Vista.Ventas;
import Conexión.Conexion;
import Vista.*;
import Modelo.*;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Giancarlo
 */
public class ControladorPanelCarrito {
    
    private JpanelCarrito panelCarrito;
    private int IDCliente;
    private Connection con;
    private CardLayout cardLayout2;
    private JPanel contenedor;
    private Ventas ventas;

    public ControladorPanelCarrito(JpanelCarrito panelCarrito,Connection con,CardLayout cardLayout2,JPanel contenedor,Ventas ventas) {
        this.panelCarrito = panelCarrito;
        this.con = con;
        this.cardLayout2 = cardLayout2;
        this.contenedor = contenedor;
        this.ventas = ventas;
        
        this.panelCarrito.tblProdCarrito.setAutoCreateRowSorter(true);
        
            
        this.panelCarrito.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                eliminarProducto();
            }
        });
        
            
         this.panelCarrito.btnPagar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            float total = ControladorVentas.cargarDatos(con, ventas.tblProdCarrito, IDCliente);
            ventas.txtTotal.setText(String.valueOf(total));
            cardLayout2.show(contenedor, "ventas");
        }
    });
    }
    

private void mostrarMensaje(String mensaje, String titulo, int tipoMensaje) {
    JOptionPane.showMessageDialog(panelCarrito, mensaje, titulo, tipoMensaje);
}


    private void eliminarProducto(){//se nos paso la funcion
        String idProductoText = panelCarrito.IdTField.getText();
        if (idProductoText.isEmpty()){
            JOptionPane.showMessageDialog(panelCarrito, "Porfavor ingrese el ID del Producto", "Error", JOptionPane.ERROR);
            return;
        }
        
        try {
            int productoID = Integer.parseInt(idProductoText);
            
            CarritoDeCompra.eliminarDelCarrito(productoID, IDCliente, con);
            
            actualizarCarrito();
        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(panelCarrito, "El ID debe ser un número valido");
        }
    }
    
    private void actualizarCarrito(){
        float total = ControladorPanelCarrito.cargarDatos(con, panelCarrito.tblProdCarrito, IDCliente);
        panelCarrito.txtTotal.setText(String.valueOf(total));
    }   
    
    private static float cargarDatos(Connection con,JTable tabla,int IDCliente){
        DefaultTableModel modelo = new DefaultTableModel();
        float total = 0;
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("subtotal");
        
        String query = "SELECT cliente.nombres AS cliente, producto.nombre AS producto, "
                     + "carrito.producto_id AS id_producto, carrito.cantidad, producto.precio, "
                     + "(carrito.cantidad * producto.precio) AS subtotal "
                     + "FROM cliente "
                     + "JOIN carrito ON cliente.id_cliente = carrito.cliente_id "
                     + "JOIN producto ON producto.id_producto = carrito.producto_id "
                     + "WHERE cliente.id_cliente = " + IDCliente;
        
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query)){
            
            while(rs.next()){
                
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_producto");
                fila[1] = rs.getString("producto");
                fila[2] = rs.getFloat("precio");
                fila[3] = rs.getInt("cantidad");
                fila[4] = rs.getFloat("subtotal");
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
    
    public void setID(int ID) {
        this.IDCliente = ID;
        //ya q el ID está seteado puedes inicializar o actualizar componentes que dependan del id
        //cad ves q se incie sesion se setea de neuvo el id y se cargan los datos
        float total = ControladorPanelCarrito.cargarDatos(con, panelCarrito.tblProdCarrito, IDCliente);
        panelCarrito.txtTotal.setText(String.valueOf(total));
    }
       
}
