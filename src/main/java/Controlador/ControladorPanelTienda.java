/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.TablaCliente;
import Vista.panelTienda;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Giancarlo
 */
public class ControladorPanelTienda {
    
    private panelTienda panel;
    private Connection con;
    private CardLayout cardLayout;
    private CardLayout cardLayout2;
    private JPanel contenedor;
    private JPanel contenedor2;
    private TablaCliente tablaCliente;

    public ControladorPanelTienda(panelTienda panel, Connection con,JPanel contenedoor,CardLayout cardLayout,CardLayout cardLayout2,JPanel contenedor2,TablaCliente tablaCliente) {
        this.panel = panel;
        this.con = con;
        this.contenedor = contenedoor;
        this.contenedor2 = contenedor2;
        this.cardLayout = cardLayout;
        this.cardLayout2 = cardLayout2;
        this.tablaCliente = tablaCliente;
        
       this.panel.btnCarrito.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               
               cardLayout.show(contenedor, "carrito");
               
           }
    
       });
       
       this.panel.btnSalir.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               
               cardLayout2.show(contenedor2, "login");
               
           }
    
       });
       
       this.panel.btnInicio.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
           ControladorTablaCliente.cargarDatos(con, tablaCliente.table);
           cardLayout.show(contenedor,"cliente");
           
           }
       
       });
       
       
    }
    
    
    
}
