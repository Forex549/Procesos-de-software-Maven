package Controlador;

import Vista.Boleta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ControladorBoleta {
    private Boleta vista;
    private Connection con;
    private int IDCliente;  // Variable para almacenar el ID del cliente

    public ControladorBoleta(Boleta vista, Connection con) {
        this.vista = vista;
        this.con = con;
    }

    // Método para establecer el ID del cliente
    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;  // Establece el ID dinámicamente
    }

    // Método para cargar los datos desde la tabla
    public void cargarDatosDesdeTabla(DefaultTableModel modeloTabla, String total) {
        vista.tblProdPedido.setModel(modeloTabla); // Asigna el modelo de tabla directamente
        vista.txtTotal.setText(total); // Muestra el total recibido
    }

public void cargarDatosUsuario() {
    // Consulta para obtener los datos del cliente usando el IDCliente
    String consulta = "SELECT nombres, apellidos, correo, direccion, telefono FROM cliente WHERE id_cliente = ?";
    try (PreparedStatement ps = con.prepareStatement(consulta)) {
        ps.setInt(1, IDCliente);  // Usa el IDCliente asignado
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                // Asignación de datos a las etiquetas ya existentes
                vista.jLabelNombreCliente.setText(rs.getString("nombres") + " " + rs.getString("apellidos"));
                vista.jLabelCorreo.setText("Correo: " + rs.getString("correo"));
                vista.jLabelDireccion.setText(rs.getString("direccion"));
                vista.jLabelNumero.setText("Teléfono: " + rs.getString("telefono")); 
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}




}

/*
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

*/

