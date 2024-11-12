
package Controlador;

import Vista.TablaCliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MATHIAS
 */
public class ControladorTablaCliente {
    
    private Connection con;
    private TablaCliente tabla;
    
    public ControladorTablaCliente(Connection con, TablaCliente tabla){
        this.con = con;
        this.tabla = tabla;
        
        
    }
    
    public void iniciar_vista(){
        //this.tabla.table.setAutoCreateRowSorter(true);//pa poder ordenar las filas y columnas mas facil con solo cliks
        cargarDatos(con, tabla.table);
    }
    
    private static void cargarDatos(Connection con, JTable table) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("MARCA");
        modelo.addColumn("CATEGORIA");

        
        String consulta = "SELECT * FROM producto"; // Cambia "productos" al nombre de tu tabla

        try  {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            
                 while (rs.next()) {
                Object[] fila = new Object[5];
                fila[0] = rs.getString("NOMBRE"); // Cambia "nombre" al nombre de tu columna
                fila[1] = rs.getFloat("PRECIO"); // Cambia "precio" al nombre de tu columna
                fila[2] = rs.getInt("STOCK"); // Cambia "stock" al nombre de tu columna
                fila[3] = rs.getString("MARCA");
                fila[4] = rs.getString("CATEGORIA");
                modelo.addRow(fila);
                
        }  
                 table.setModel(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    
    
    
}
