
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Modelo.Producto;
import Vista.*;
import java.awt.CardLayout;
import javax.swing.JPanel;
/**
 *
 * @author Giancarlo
 */
public class ControladorAlmacen {
    
    
    private Connection con;
    private VistaAlmacen vista;
    private CardLayout cardlayout;
    private JPanel contenedor;

    public ControladorAlmacen(Connection con,VistaAlmacen vista,CardLayout cardlayout,JPanel contenedor) {
        this.con = con;
        this.vista = vista;
        this.cardlayout = cardlayout;
        this.contenedor = contenedor;
        
        this.vista.btnAgregar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        
            if(camposLlenos()){
            
                String nombre = vista.txtNombre.getText();
                String marca = vista.txtMarca.getText();
                Float precio = Float.parseFloat(vista.txtPrecio.getText());
                int cantidad = Integer.parseInt(vista.txtCantidad.getText());
                String categoria  = vista.txtCategoria.getText();
                String descripcion = vista.txtDescrip.getText();
                
                Producto.agregarProducto(precio, cantidad, descripcion, marca, nombre, categoria, con);
                limpiarCampos();
                JOptionPane.showMessageDialog(vista, "Se realizó el registro" , "Producto Agregado" , JOptionPane.INFORMATION_MESSAGE);
            
            }else{
            
                JOptionPane.showMessageDialog(vista, "Debe llenar todos los campos" , "Error al agregar producto" , JOptionPane.ERROR_MESSAGE);
            }
            
        
        }
        });
        
        this.vista.btnSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            
                cardlayout.show(contenedor,"login");
            
            }
        });
        
        this.vista.btnEliminar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
                int filaEliminar = vista.tblProductos.getSelectedRow();
                
                if( filaEliminar >= 0 ){
                    
                    int codigoeliminar = (int)vista.tblProductos.getValueAt(filaEliminar, 0);
                    Producto.eliminarProducto(codigoeliminar, con);
                    
                    JOptionPane.showMessageDialog(vista,"Registro eliminado", "Elimiar Productos" , JOptionPane.INFORMATION_MESSAGE );
                    limpiarCampos();
                }else{
                
                    JOptionPane.showMessageDialog(vista,"No has seleccionado una fila de la tabla ", "Elimiar Producto" , JOptionPane.ERROR_MESSAGE );
                }
        
            }
        });
        
        
        this.vista.btnActualizar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){

                int filaselect = vista.tblProductos.getSelectedRow();
                
                if(filaselect>=0){
                    
                    int id = (int)vista.tblProductos.getValueAt(filaselect, 0);
                
                    if(vista.btnActualizar.getText().equalsIgnoreCase("Actualizar")){
                        
                        habilitarControlesActualizacion(true);
                        
                        vista.txtCodigo.setText(vista.tblProductos.getValueAt(filaselect, 0).toString());
                        vista.txtNombre.setText(vista.tblProductos.getValueAt(filaselect, 1).toString());
                        vista.txtPrecio.setText(vista.tblProductos.getValueAt(filaselect, 2).toString());
                        vista.txtCantidad.setText(vista.tblProductos.getValueAt(filaselect, 3).toString());
                        vista.txtMarca.setText(vista.tblProductos.getValueAt(filaselect, 4).toString());
                        vista.txtCategoria.setText(vista.tblProductos.getValueAt(filaselect, 5).toString());
                        vista.txtDescrip.setText(vista.tblProductos.getValueAt(filaselect, 6).toString());
                    
                    
                    }else if(vista.btnActualizar.getText().equalsIgnoreCase("Grabar")){
                        
                        
                        if(camposLlenos()){
                        
                            String categoria = vista.txtCategoria.getText();
                            String nombre = vista.txtNombre.getText();
                            String marca = vista.txtMarca.getText();
                            float precio = Float.parseFloat(vista.txtPrecio.getText());
                            int cantidad= Integer.parseInt(vista.txtCantidad.getText());
                            String descripcion = vista.txtDescrip.getText();
                            
                            Producto.Actualizar(id, precio, cantidad, descripcion, marca, nombre, categoria, con);
                            
                            habilitarControlesActualizacion(false);
                            limpiarCampos();
                            JOptionPane.showMessageDialog(vista,"Actualizacion exitosa", "Actualizar Producto" , JOptionPane.INFORMATION_MESSAGE );
                        }
                        else{
                            JOptionPane.showMessageDialog(vista, "Debe llenar todos los campos" , "Error al agregar producto" , JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                    
                }else{
                
                    JOptionPane.showMessageDialog(vista, "Debes seleccionar una fila" , "Actualizar Producto" , JOptionPane.WARNING_MESSAGE );
                }
            

                }
        
        } 
       );
            
}
    
    
    public void iniciar_vista(){
        this.vista.tblProductos.setAutoCreateRowSorter(true);//pa poder ordenar las filas y columnas mas facil con solo cliks
       
        limpiarCampos();
        habilitarControlesActualizacion(false);
    }
    
    
    private boolean camposLlenos(){
        boolean resultado = false;
        if (
                this.vista.txtNombre.getText().length()!= 0 &&
                this.vista.txtMarca.getText().length()!= 0 &&
                this.vista.txtPrecio.getText().length()!= 0 &&
                this.vista.txtCantidad.getText().length()!= 0 &&
                this.vista.txtDescrip.getText().length()!=0
        ){
            resultado = true;
        }
        return resultado;
    }
    
    private void limpiarCampos() {
        vista.txtCodigo.setText("");
        vista.txtCantidad.setText("");
        vista.txtMarca.setText("");
        vista.txtNombre.setText("");
        vista.txtPrecio.setText("");
        vista.txtDescrip.setText("");
        vista.txtCategoria.setText("");
        ControladorAlmacen.cargarDatos(con, vista.tblProductos);
        this.vista.txtCodigo.requestFocus();
        this.vista.txtCodigo.selectAll();

    }
    
     private static void cargarDatos(Connection con,JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Marca");
        modelo.addColumn("Categoria");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Fecha de actualización");

        
        String consulta = "SELECT * FROM producto"; // Cambia "productos" al nombre de tu tabla

        try  {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            
                 while (rs.next()) {
                Object[] fila = new Object[8];
                fila[0] = rs.getInt("id_producto"); // Cambia "id" al nombre de tu columna
                fila[1] = rs.getString("Nombre"); // Cambia "nombre" al nombre de tu columna
                fila[2] = rs.getFloat("Precio"); // Cambia "precio" al nombre de tu columna
                fila[3] = rs.getInt("Stock"); // Cambia "stock" al nombre de tu columna
                fila[4] = rs.getString("Marca");
                fila[5] = rs.getString("Categoria");
                fila[6] = rs.getString("descripción");
                fila[7] = rs.getTimestamp("fecha_actualizacion");
                modelo.addRow(fila);
                
                
        }  
                 tabla.setModel(modelo);
        } catch (SQLException e) {
            e.printStackTrace();
        }}
        
        
        private void habilitarControlesActualizacion(boolean editar){
        if (editar){
            vista.btnAgregar.setEnabled(false);
            vista.btnEliminar.setEnabled(false);
            vista.btnActualizar.setEnabled(true);
            vista.btnActualizar.setText("Grabar");
            vista.txtCodigo.setEnabled(false);
            this.vista.txtNombre.requestFocus(); //esto y lo d abajo no es necesario solo cambia el lugar el crusor
            this.vista.txtNombre.selectAll();
        } else {
            vista.btnAgregar.setEnabled(true);
            vista.btnEliminar.setEnabled(true);
            vista.btnActualizar.setEnabled(true);
            vista.btnActualizar.setText("Actualizar");
            vista.txtCodigo.setEnabled(false);
            this.vista.txtCodigo.requestFocus();
            this.vista.txtCodigo.selectAll();
        }
    }

}