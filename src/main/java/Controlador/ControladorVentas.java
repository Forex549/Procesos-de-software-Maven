package Controlador;

import Vista.Ventas;
import javax.swing.JOptionPane;

/**
 *
 * @author Ronnie Herrera
 */
public class ControladorVentas {
    private Ventas vista;

    public ControladorVentas(Ventas vista) {
        this.vista = vista;
        
        // Asociamos los eventos de los botones
        this.vista.botonConfirmar.addActionListener(e -> confirmarVenta());
        this.vista.botonCancelar.addActionListener(e -> cancelarVenta());
        this.vista.jCheckBoxTerminosCondiciones.addActionListener(e -> actualizarBotonConfirmar());
        
        // Actualizamos el estado inicial del botón "Confirmar"
        actualizarBotonConfirmar();
    }

    public void cancelarVenta() {
        // Lógica para cancelar la venta
        System.out.println("Venta cancelada.");
        // Limpiar campos
        vista.campoTotal.setText("");
        // Aquí puedes agregar más lógica para resetear la interfaz
    }

    public void confirmarVenta() {
        // Lógica para confirmar la venta
        System.out.println("Venta confirmada.");
        
        // Realizamos acciones adicionales, como la validación de los datos
        if (vista.jCheckBoxTerminosCondiciones.isSelected()) {
            // Si los términos están aceptados, procesamos la venta
            JOptionPane.showMessageDialog(vista, "Venta confirmada exitosamente.");
        } else {
            // Si no se aceptan los términos
            JOptionPane.showMessageDialog(vista, "Debe aceptar los términos y condiciones.");
        }
        
        // Aquí se puede llamar a métodos para procesar la venta (guardar datos, actualizaciones, etc.)
        actualizarTotal();
    }

    private void actualizarTotal() {
        // Aquí agregamos la lógica para actualizar el total
        // Por ejemplo, obtenemos el total de la venta (esto es solo un ejemplo)
        String total = vista.campoTotal.getText();
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
