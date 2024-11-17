/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Vista.*;
import java.awt.CardLayout;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.Callable;
/**
 *
 * @author Giancarlo
 */
public class ControladorVistaInfo {
    
    private VistaInfo vista;
    private CardLayout cardlayout;
    private Connection con;

    public ControladorVistaInfo(VistaInfo vista, CardLayout cardlayout,Connection con) {
        this.vista = vista;
        this.cardlayout = cardlayout;
        this.con = con;
    }
    
    public void configurarInfo(int ID,VistaInfo vista){
    
        String sql = "{CALL obtenerInfo(?,?,?,?,?)}";
        
        try{
        CallableStatement consulta = con.prepareCall(sql);
        consulta.setInt(1,ID);
        
        consulta.registerOutParameter(2, java.sql.Types.VARCHAR);
        consulta.registerOutParameter(3, java.sql.Types.FLOAT);
        consulta.registerOutParameter(4, java.sql.Types.INTEGER);
        consulta.registerOutParameter(5, java.sql.Types.VARCHAR);
        
        consulta.execute();
        
        String descripcion = consulta.getString(2);
        float precio = consulta.getFloat(3);
        int cantidad = consulta.getInt(4);
        String nombre =consulta.getString(5);
        
        this.vista.descriptionProduct.setText(descripcion);
        this.vista.labelNameProduct1.setText(nombre);
        this.vista.labelPrice.setText(String.valueOf(precio));
        
            System.out.println("pfecio: "+precio);
            System.out.println("cantidad: "+cantidad);
            System.out.println("descr: "+descripcion);
            System.out.println("nombre: "+nombre);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    
}
