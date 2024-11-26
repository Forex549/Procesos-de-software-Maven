package Controlador;

import Modelo.CarritoDeCompra;
//import Controlador.CarritoDeCompra;
import Vista.Boleta;
import Vista.Ventas;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ronnie Herrera
 */
public class ControladorVentas {
    private Ventas vista;
    private int IDCliente;
    private Connection con;
    private CardLayout cardLayout2;
    private ControladorPanelCarrito conCarr;
    
    
    public ControladorVentas(Ventas vista/*, int IDCliente*/, Connection con,CardLayout cardLayout2,ControladorPanelCarrito conCarr) {
        this.vista = vista;
        this.IDCliente = IDCliente;
        this.con = con;
        this.cardLayout2 = cardLayout2;
        this.conCarr = conCarr;
        
        this.vista.botonConfirmar.addActionListener(e -> confirmarVenta());
        this.vista.botonCancelar.addActionListener(e -> cancelarVenta());
        this.vista.jCheckBoxTerminosCondiciones.addActionListener(e -> actualizarBotonConfirmar());
        
        actualizarBotonConfirmar();
        //actualizarCarrito();
    }
    
    private void actualizarCarrito() { //duda si aun es necesario
        if (vista.tblProdCarrito != null) { 
            // Carga los datos en la tabla dentro del panel Ventas
            float total = ControladorVentas.cargarDatos(con, vista.tblProdCarrito, IDCliente);
            // Actualiza el campo de texto con el total calculado
            vista.txtTotal.setText(String.valueOf(total));
        } else {
            System.out.println("Error: tblProdCarrito no está inicializado en la vista.");
        }
    }
 
     public static float cargarDatos(Connection con, JTable tabla, int IDCliente) {
        DefaultTableModel modelo = new DefaultTableModel();
        float total = 0;
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("subtotal");

        String query = "SELECT producto.nombre AS producto, "
                     + "carrito.producto_id AS id_producto, carrito.cantidad, producto.precio, "
                     + "(carrito.cantidad * producto.precio) AS subtotal "
                     + "FROM carrito "
                     + "JOIN producto ON producto.id_producto = carrito.producto_id "
                     + "WHERE carrito.cliente_id = " + IDCliente;

        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_producto");
                fila[1] = rs.getString("producto");
                fila[2] = rs.getFloat("precio");
                fila[3] = rs.getInt("cantidad");
                fila[4] = rs.getFloat("subtotal");
                total += rs.getFloat("subtotal");
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total;
    }
    
    

   public void cancelarVenta() {
        vista.txtTotal.setText("");
        System.out.println("Venta cancelada.");
    }


public void confirmarVenta() {
    String medioPago = vista.jRadioButtonyape.isSelected() ? "Yape" : 
                       vista.jRadioButtonTranferencia.isSelected() ? "Transferencia" : "";

    String comprobante = vista.jRadioButtonFactura.isSelected() ? "Factura" : 
                         vista.jRadioButtonBoleta.isSelected() ? "Boleta" : "";

    if (medioPago.isEmpty() || comprobante.isEmpty()) {
        JOptionPane.showMessageDialog(vista, "Debe seleccionar medio de pago y comprobante.");
        return;
    }

    try {
        con.setAutoCommit(false);

        // Reducción de stock y limpieza de carrito
        String consultaCarrito = "SELECT producto_id, cantidad FROM carrito WHERE cliente_id = ?";
        try (PreparedStatement psCarrito = con.prepareStatement(consultaCarrito)) {
            psCarrito.setInt(1, IDCliente);
            ResultSet rs = psCarrito.executeQuery();

            while (rs.next()) {
                int idProducto = rs.getInt("producto_id");
                int cantidad = rs.getInt("cantidad");

                String actualizarStock = "UPDATE producto SET stock = stock - ? WHERE id_producto = ?";
                try (PreparedStatement psStock = con.prepareStatement(actualizarStock)) {
                    psStock.setInt(1, cantidad);
                    psStock.setInt(2, idProducto);
                    psStock.executeUpdate();
                }
            }
        }

        String limpiarCarrito = "DELETE FROM carrito WHERE cliente_id = ?";
        try (PreparedStatement psLimpiar = con.prepareStatement(limpiarCarrito)) {
            psLimpiar.setInt(1, IDCliente);
            psLimpiar.executeUpdate();
        }

        con.commit();
        
        // Aquí se llama a la función para abrir la ventana de la boleta
        //abrirVistaBoleta();
        
        conCarr.setID(IDCliente);
        actualizarCarrito();
    } catch (SQLException e) {
        try {
            con.rollback();
            JOptionPane.showMessageDialog(vista, "Error al procesar la venta. Se han revertido los cambios.");
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        e.printStackTrace();
    } finally {
        try {
            con.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/*
private void abrirVistaBoleta() {
    // Crear una nueva instancia de la vista de la boleta
    Boleta ventanaBoleta = new Boleta();

    // Asegúrate de tener la conexión y el IDCliente disponibles
    Connection con = // Tu conexión a la base de datos;
    int IDCliente = // El ID del cliente que deseas pasar;

    // Crear el controlador asociado a la ventana de la boleta
    ControladorBoleta controladorBoleta = new ControladorBoleta(ventanaBoleta, con, IDCliente);

    // Crear un JFrame para mostrar la ventana de la boleta
    JFrame frameBoleta = new JFrame("Boleta de Venta");
    frameBoleta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frameBoleta.setContentPane(ventanaBoleta);
    frameBoleta.pack();
    frameBoleta.setLocationRelativeTo(null); // Centrar la ventana
    frameBoleta.setVisible(true);
}

*/


 private void actualizarTotal() { 
    try {
        // Calculamos el total sumando los subtotales del carrito
        float total = 0;
        String query = "SELECT (carrito.cantidad * producto.precio) AS subtotal "
                     + "FROM carrito "
                     + "JOIN producto ON producto.id_producto = carrito.producto_id "
                     + "WHERE carrito.cliente_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, IDCliente);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                total += rs.getFloat("subtotal");
            }
        }

        // Actualizamos el campo de texto con el total calculado
        vista.txtTotal.setText(String.format("%.2f", total));
        System.out.println("Total actualizado: " + total);

        // Validamos si el total es válido o está vacío (en este caso, debería ser 0.0 si no hay productos)
        if (total <= 0) {
            JOptionPane.showMessageDialog(vista, "El carrito está vacío. No hay productos para calcular el total.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(vista, "Error al actualizar el total. Verifique la base de datos.");
    }
}


    // Método que habilita o deshabilita el botón de confirmar dependiendo de si se aceptan los términos
    private void actualizarBotonConfirmar() {
        if (vista.jCheckBoxTerminosCondiciones.isSelected() && vista.jCheckBoxUsarMiCuenta.isSelected()) {
            vista.botonConfirmar.setEnabled(true);} 
        else if(vista.jCheckBoxUsarMiCuenta.isSelected() && vista.jCheckBoxTerminosCondiciones.isSelected()){
                    vista.botonConfirmar.setEnabled(true);
        } else {
            vista.botonConfirmar.setEnabled(false);
        }
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }
}