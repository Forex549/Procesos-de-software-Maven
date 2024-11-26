/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Vista.*;
import Modelo.ConexionLogin;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
/**
 *
 * @author Giancarlo
 */
public class controladorLogin {
    
    private Login login;
    private CardLayout cardLayout;
    private Principal principal;
    private Tienda tienda;
    private JpanelCarrito carrito;
    private Connection con;
    public int ID;
    private ControladorPanelCarrito conCarr;
    private ControladorVistaInfo contInfo;
    private TablaCliente tablaCliente;
    private ControladorVentas conVent;

    public controladorLogin(Login login, CardLayout cardLayout, Connection con,Principal principal,ControladorPanelCarrito conCarr,ControladorVistaInfo contInfo,TablaCliente tablaCliente,ControladorVentas conVent) {
        this.login = login;
        this.cardLayout = cardLayout;
        this.principal = principal;
        this.con = con;
        this.contInfo = contInfo;
        this.conCarr = conCarr;//se pasa por parametro controlaodr carrito ya q este necesita el id del usuario, y se debe setear
        //dentro de la accion del boton
        this.tablaCliente = tablaCliente;
        this.conVent = conVent;
        
        
        this.login.btnIngresar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                // Obtener los valores ingresados
                String username = login.jTextFieldUsuario.getText().trim();
                String password = new String(login.jTextFieldPassword.getPassword()).trim(); // Convertir el char[] a String
                
                
                int idCliente = ConexionLogin.verificarUsuario(username, password, con);
                ID = idCliente;
 
                if(ConexionLogin.esAdmin(username, password,con)){
                    //Si es admin te mostrar el almacen, falta decorar el almacen
                    cardLayout.show(principal.background, "almacen");
                }

                else if (idCliente != -1) {
                    System.out.println("codigo: "+idCliente);
                    contInfo.setIDUsuario(idCliente);
                    conCarr.setID(idCliente);
                    conVent.setIDCliente(idCliente);
                    
                    //ControladorPanelCarrito carrito = new ControladorPanelCarrito(controladorLogin.this.carrito,ID,con);
                    ControladorTablaCliente.cargarDatos(con, tablaCliente.table);
                    cardLayout.show(principal.background, "tienda");

                    //javax.swing.JOptionPane.showMessageDialog(this, "Ingreso exitoso!");
                    // Lógica para avanzar en la aplicación o cambiar de pantalla
                }

                else {
                    javax.swing.JOptionPane.showMessageDialog(login, "Usuario o contraseña incorrectos.", "Error de autenticación", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
   
        });
        
        // Configurar el clic en el panel de registro
        this.login.jPanelRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirRegistro();
            }
        });
    }
    
    // Método para mostrar la vista de registro
    private void abrirRegistro() {
        // Cambiar a la vista de registro usando CardLayout
        cardLayout.show(principal.background, "registro");
    }
    
    
}
