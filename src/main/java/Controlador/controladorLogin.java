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
import java.sql.Connection;
/**
 *
 * @author Giancarlo
 */
public class controladorLogin {
    
    private Login login;
    CardLayout cardLayout;
    Principal principal;
    Tienda tienda;
    JpanelCarrito carrito;
    Connection con;
    public int ID;
    private ControladorPanelCarrito conCarr;
    private ControladorVistaInfo contInfo;
    private TablaCliente tablaCliente;

    public controladorLogin(Login login, CardLayout cardLayout, Connection con,Principal principal,ControladorPanelCarrito conCarr,ControladorVistaInfo contInfo,TablaCliente tablaCliente) {
        this.login = login;
        this.cardLayout = cardLayout;
        this.principal = principal;
        this.con = con;
        this.contInfo = contInfo;
        this.conCarr = conCarr;//se pasa por parametro controlaodr carrito ya q este necesita el id del usuario, y se debe setear
        //dentro de la accion del boton
        this.tablaCliente = tablaCliente;
        
        
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
    }
    
    
    
    
    
}
