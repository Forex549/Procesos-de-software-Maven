/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.CarritoDeCompra;
import Modelo.Product;
import Vista.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import Vista.VistaInfo;
/**
 *
 * @author Giancarlo
 */
public class ControladorVistaInfo {
    
    private VistaInfo vista;
    private CardLayout cardlayout;
    private Connection con;
    private int IDUsuario;
    private int IDProducto;
    private ControladorPanelCarrito conCarr;

    public ControladorVistaInfo(VistaInfo vista, CardLayout cardlayout,Connection con,ControladorPanelCarrito conCarr) {
        this.vista = vista;
        this.cardlayout = cardlayout;
        this.con = con;
        this.conCarr = conCarr;
        
        this.vista.btnAgregarCarr.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            
                int cantidad = (Integer)vista.comboCantidad.getValue();
                
                if(cantidad > 0){
                
                    if(CarritoDeCompra.agregarAlCarrito(IDProducto, cantidad, con, IDUsuario)){
                    
                    conCarr.setID(IDUsuario);
                    JOptionPane.showMessageDialog(vista, "Producto agregado al carrito exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                        else{
                
                    JOptionPane.showMessageDialog(vista, "Error al agregar el producto al carrito.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                
                else{
                    JOptionPane.showMessageDialog(vista, "Debes seleccionar la cantidad que deseas agregar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
           
     }

    public void configurarInfo(int ID,VistaInfo vista){
    
        String sql = "{CALL obtenerInfo(?,?,?,?,?,?)}";
        
        try{
        CallableStatement consulta = con.prepareCall(sql);
        consulta.setInt(1,ID);
        
        consulta.registerOutParameter(2, java.sql.Types.VARCHAR);
        consulta.registerOutParameter(3, java.sql.Types.FLOAT);
        consulta.registerOutParameter(4, java.sql.Types.INTEGER);
        consulta.registerOutParameter(5, java.sql.Types.VARCHAR);
        consulta.registerOutParameter(6, java.sql.Types.VARCHAR);
        
        consulta.execute();
        
        String descripcion = consulta.getString(2);
        float precio = consulta.getFloat(3);
        int cantidad = consulta.getInt(4);
        String nombre =consulta.getString(5);
        String imagen = consulta.getString(6);
        
        this.vista.descriptionProduct.setText(descripcion);
        this.vista.labelNameProduct1.setText(nombre);
        this.vista.labelPrice.setText(String.valueOf(precio));
        this.vista.lblStock.setText(String.valueOf(cantidad));
        this.vista.ImagenProduct1.setText("");
        this.vista.ImagenProduct1.setIcon(new javax.swing.ImageIcon("productos_imagenes/" + imagen));
        
        
        SpinnerNumberModel modelo = new SpinnerNumberModel(0, 0, cantidad, 1);
        this.vista.comboCantidad.setModel(modelo);
        this.vista.btnAgregarCarr.setEnabled(true);
        
        if(cantidad ==0){
            this.vista.lblStock.setText("AGOTADO");
            this.vista.stock.setText("");
            this.vista.btnAgregarCarr.setEnabled(false);
            SpinnerNumberModel modelo2 = new SpinnerNumberModel(0, 0, cantidad, 0);
        this.vista.comboCantidad.setModel(modelo2);
        }
        
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void setIDUsuario(int ID){
        this.IDUsuario = ID;
    }
    
    public void setIDProducto(int ID){
        this.IDProducto = ID;
    }
    
    
    
    
    
}
