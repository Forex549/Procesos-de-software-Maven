package Controlador;

import Vista.Boleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador para la vista Boleta. Gestiona la carga de detalles de boleta
 * y la acción de imprimir.
 *
 * @author Ronnie Herrera
 */
public class ControladorBoleta {
    private Boleta vista;
    private Connection con;
    private int IDCliente;

    public ControladorBoleta(Boleta vista, Connection con, int IDCliente) {
        this.vista = vista;
        this.con = con;
        this.IDCliente = IDCliente;
        // Llamar al método para cargar los detalles de la boleta
        cargarDetalleBoleta();

        // Acción del botón de imprimir
        vista.jButtonDescargar.addActionListener(e -> imprimirBoleta());
    }

    private void cargarDetalleBoleta() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Subtotal");

        // Consulta para obtener los productos del pedido
        String query = "SELECT p.id_producto, p.nombre, dp.cantidad, p.precio, "
                     + "(dp.cantidad * p.precio) AS subtotal "
                     + "FROM detalle_pedido dp "
                     + "JOIN producto p ON p.id_producto = dp.id_producto "
                     + "WHERE dp.id_pedido = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, obtenerUltimoPedido());  // Obtener el último pedido del cliente
            ResultSet rs = ps.executeQuery();
            float total = 0;

            // Iteramos sobre los resultados de la consulta
            while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getInt("id_producto");   // ID del producto
                fila[1] = rs.getString("nombre");     // Nombre del producto
                fila[2] = rs.getInt("cantidad");      // Cantidad del producto
                fila[3] = rs.getFloat("precio");      // Precio del producto
                fila[4] = rs.getFloat("subtotal");    // Subtotal (cantidad * precio)
                total += rs.getFloat("subtotal");    // Acumulamos el total
                modelo.addRow(fila);  // Añadimos la fila a la tabla
            }

            // Establecemos el modelo de la tabla en la vista
            vista.tblProdPedido.setModel(modelo);
            // Mostramos el total en el campo correspondiente de la vista
            vista.txtTotal.setText(String.format("%.2f", total));
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al cargar los detalles de la boleta.");
        }
    }

    // Obtener el ID del último pedido del cliente
    private int obtenerUltimoPedido() {
        String query = "SELECT MAX(id_pedido) AS id_pedido FROM bdprocesos.pedido WHERE id_cliente = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, IDCliente);  // Establecer el ID del cliente
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_pedido");  // Retornar el ID del último pedido
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Si no se encuentra el pedido
    }

    private void imprimirBoleta() {
        // Aquí agregamos la lógica para imprimir la boleta
        JOptionPane.showMessageDialog(vista, "Boleta lista para imprimir.");
    }
}
