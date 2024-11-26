package Controlador;

import Vista.RegistrarCliente;
import Modelo.ConexionLogin;
import Vista.Principal;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class ControladorRegistroCliente {

    private RegistrarCliente vista;
    private CardLayout cardLayout;
    private Principal principal;
    private Connection con;

    public ControladorRegistroCliente(RegistrarCliente vista, CardLayout cardLayout, Connection con, Principal principal) {
        this.vista = vista;
        this.cardLayout = cardLayout;
        this.principal = principal;
        this.con = con;

        
        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCliente();
            }
        });
    }

    
      //Método para registrar un cliente en la bd
    private void registrarCliente() {
        // Obtener los valores ingresados por el usuario
        String nombres = vista.jTextFieldNombres.getText().trim();
        String apellidos = vista.jTextFieldApellidos.getText().trim();
        String correo = vista.jTextFieldCorreo.getText().trim();
        String telefono = vista.jTextFieldTelefono.getText().trim();
        String direccion = vista.jTextFieldDireccion.getText().trim();
        String password = new String(vista.jTextFieldPassword.getPassword()).trim();

        //Validar que todos los campos estén llenos
        if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() ||
            telefono.isEmpty() || direccion.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos deben ser completados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Registrar al cliente en la base de datos
        boolean registroExitoso = ConexionLogin.registrarCliente(nombres, apellidos, correo, telefono, direccion, password, con);

        if (registroExitoso) {
            JOptionPane.showMessageDialog(vista, "Registro exitoso.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
            //cambiar a la vista de login 
            cardLayout.show(principal.background, "login");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al registrar el cliente. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
     //Método para limpiar los campos después del registro.
    private void limpiarCampos() {
        vista.jTextFieldNombres.setText("");
        vista.jTextFieldApellidos.setText("");
        vista.jTextFieldCorreo.setText("");
        vista.jTextFieldTelefono.setText("");
        vista.jTextFieldDireccion.setText("");
        vista.jTextFieldPassword.setText("");
    }
}
