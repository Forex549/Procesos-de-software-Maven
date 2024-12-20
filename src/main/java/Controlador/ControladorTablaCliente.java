
package Controlador;

import Modelo.Producto;
import Vista.TablaCliente;
import Vista.VistaInfo;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MATHIAS
 */
public class ControladorTablaCliente {
    
    private Connection con;
    private TablaCliente tabla;
    private CardLayout cardLayout;
    private JPanel detalles;
    private JPanel contenedor;
    private ControladorVistaInfo contInfo;
    private VistaInfo vistInfo;
    private ControladorVistaInfo conInfo;
    
    public ControladorTablaCliente(Connection con, TablaCliente tabla,CardLayout cardLayout,JPanel detalles,ControladorVistaInfo contInfo,VistaInfo vistInfo,ControladorVistaInfo conInfo){
        this.con = con;
        this.tabla = tabla;
        this.cardLayout = cardLayout;
        this.detalles = detalles;
        this.contInfo = contInfo;
        this.vistInfo = vistInfo;
        this.conInfo = conInfo;
    }
    
    public void iniciar_vista(){
        this.tabla.table.setAutoCreateRowSorter(true);//pa poder ordenar las filas y columnas mas facil con solo cliks
        cargarDatos(con, tabla.table);
        
        this.tabla.btnVer.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
            int codigoVer = -1;
            int filaVer = (int)tabla.table.getSelectedRow();
            
                
                if( filaVer >= 0 ){
                    
                    codigoVer = (int)tabla.table.getValueAt(filaVer, 0);
                    System.out.println("codigo: "+codigoVer);  
                    contInfo.configurarInfo(codigoVer, vistInfo);
                    contInfo.setIDProducto(codigoVer);
                    cardLayout.show(detalles,"detalles");
                }else{
                
                    JOptionPane.showMessageDialog(tabla,"No has seleccionado una fila de la tabla ", "Ver Producto" , JOptionPane.ERROR_MESSAGE );
                }
            
        }
   
        });
        
        this.tabla.btnBuscar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String texto = tabla.txtFiltro.getText();
            cargarDatosFiltName(con, tabla, texto);
            
        }
        });
    }
    
    
    public static void cargarDatosFiltName(Connection con, TablaCliente table,String texto){
    
    DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("MARCA");
        modelo.addColumn("CATEGORIA");
        
        String sql = "{CALL buscarProductosXNombre(?)}";
        CallableStatement consulta = null;
        
        try{
            consulta = con.prepareCall(sql);
            consulta.setString(1, texto); 
            
            ResultSet rs = consulta.executeQuery();
            
            while (rs.next()) {
            Object[] fila = new Object[5];
            fila[0] = rs.getString("nombre");
            fila[1] = rs.getFloat("precio");
            fila[2] = rs.getInt("stock");
            fila[3] = rs.getString("marca");
            fila[4] = rs.getString("categoria");
            modelo.addRow(fila);
        }
        
        table.table.setModel(modelo);
            
            
        }catch(SQLException e){
        
            e.printStackTrace();
        }
        
    
    
    }
    
    public static void cargarDatos(Connection con, JTable table) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("MARCA");
        modelo.addColumn("CATEGORIA");

        
        String consulta = "SELECT * FROM producto";

        try  {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            
                 while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("id_producto");//lo q esta en parentesis son los nombres de las columnas en la bd
                fila[1] = rs.getString("nombre"); 
                fila[2] = rs.getFloat("precio"); 
                fila[3] = rs.getInt("stock"); 
                fila[4] = rs.getString("marca");
                fila[5] = rs.getString("categoria");
                modelo.addRow(fila);
                
        }  
                 table.setModel(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }}
    
    
    
}
