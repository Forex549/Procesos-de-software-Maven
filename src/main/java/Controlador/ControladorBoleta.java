package Controlador;

import Vista.Ventas;
import java.sql.Connection;
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
public class ControladorBoleta {
    private Ventas vista;
    private int IDCliente;
    private Connection con;
    
    private void actualizarCarrito() {
        if (vista.tblProdCarrito != null) { 
            // Carga los datos en la tabla dentro del panel Ventas
            float total = ControladorBoleta.cargarDatos(con, vista.tblProdCarrito, IDCliente);
            // Actualiza el campo de texto con el total calculado
            vista.txtTotal.setText(String.valueOf(total));
        } else {
            System.out.println("Error: tblProdCarrito no está inicializado en la vista.");
        }
    }
 
    private static float cargarDatos(Connection con, JTable tabla, int IDCliente) {
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
    
    public ControladorBoleta(Ventas vista, int IDCliente, Connection con) {
        this.vista = vista;
        this.IDCliente = IDCliente;
        this.con = con;
        
        // Asociamos los eventos de los botones
        this.vista.botonConfirmar.addActionListener(e -> confirmarVenta());
        this.vista.botonCancelar.addActionListener(e -> cancelarVenta());
        this.vista.jCheckBoxTerminosCondiciones.addActionListener(e -> actualizarBotonConfirmar());
        
        // Actualizamos el estado inicial del botón "Confirmar"
        actualizarBotonConfirmar();

        // Cargar el carrito al inicializar el controlador
        actualizarCarrito();
    }

    public void cancelarVenta() {
        // Lógica para cancelar la venta
        System.out.println("Venta cancelada.");
        // Limpiar campos
        vista.txtTotal.setText("");
        // Aquí puedes agregar más lógica para resetear la interfaz
    }

    public void confirmarVenta() {
        // Obtener medio de pago seleccionado
        String medioPago = "";
        if (vista.jRadioButtonyape.isSelected()) {
            medioPago = "Yape";
        } else if (vista.jRadioButtonTranferencia.isSelected()) {
            medioPago = "Transferencia";
        }

        // Obtener comprobante seleccionado
        String comprobante = "";
        if (vista.jRadioButtonFactura.isSelected()) {
            comprobante = "Factura";
        } else if (vista.jRadioButtonBoleta.isSelected()) {
            comprobante = "Boleta";
        }

        // Validar que se haya seleccionado un medio de pago y un comprobante
        if (medioPago.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un medio de pago.");
            return; // Salir si no se selecciona medio de pago
        }

        if (comprobante.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un comprobante.");
            return; // Salir si no se selecciona comprobante
        }

        // Si todo está correcto, procesamos la venta
        System.out.println("Venta confirmada con medio de pago: " + medioPago + " y comprobante: " + comprobante);
        JOptionPane.showMessageDialog(vista, "Venta confirmada con medio de pago: " + medioPago + " y comprobante: " + comprobante);
    }


    private void actualizarTotal() {
        // Aquí agregamos la lógica para actualizar el total
        // Por ejemplo, obtenemos el total de la venta (esto es solo un ejemplo)
        String total = vista.txtTotal.getText();
        System.out.println("Total de la venta: " + total);
        // Si el total no es válido o está vacío, podemos mostrar un mensaje de error
        if (total.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "El total de la venta no puede estar vacío.");
        }
    }

    // Método que habilita o deshabilita el botón de confirmar dependiendo de si se aceptan los términos
    private void actualizarBotonConfirmar() {
        if (vista.jCheckBoxTerminosCondiciones.isSelected()) {
            vista.botonConfirmar.setEnabled(true);
        } else {
            vista.botonConfirmar.setEnabled(false);
        }
    }
}