
package Modelo;


import java.sql.*;

/**
 *
 * @author MATHIAS
 */
public class Producto {
    
    private final String[] cabecera =  {"CODIGO","NOMBRE",
            "MARCA","PRECIO", "CANTIDAD"
    };
    
    public static void agregarProducto(float precio,int stock,String descripcion,String marca,String nombre,String categoria,Connection con,String imagen){
    
         String consulta = "{CALL agregarProducto(?,?,?,?,?,?,?)}";
         
        
         
         try{
             
                CallableStatement procedimiento = null;
               
                procedimiento = con.prepareCall(consulta);
                
                procedimiento.setString(1,nombre);
                procedimiento.setString(2, marca);
                procedimiento.setInt(3, stock);
                procedimiento.setString(4, categoria);
                procedimiento.setFloat(5, precio);
                procedimiento.setString(6,descripcion);
                procedimiento.setString(7,imagen);
                
                procedimiento.execute();
                
                

            }catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones en caso de error
                }
    }
    
    public static void eliminarProducto(int ID,Connection con){
    
        String consulta = "{CALL eliminarProducto(?)}";
        
        try{
            CallableStatement procedimineto = null;
            
            procedimineto = con.prepareCall(consulta);
            
            procedimineto.setInt(1,ID);
            
            procedimineto.execute(); 
        
        }catch(SQLException e){
        
            e.printStackTrace();
        }
   
    }
    
    public static void Actualizar(int ID, float precio,int stock,String descripcion,String marca,String nombre,String categoria,Connection con,String imagen){
    
        String consulta = "{CALL actualizarProducto(?,?,?,?,?,?,?,?)}";
        
        try{
            CallableStatement procedimiento = null;
            
            procedimiento = con.prepareCall(consulta);
            procedimiento.setInt(1,ID);
            procedimiento.setFloat(2, precio);
            procedimiento.setInt(3,stock);
            procedimiento.setString(4,descripcion);
            procedimiento.setString(5,marca);
            procedimiento.setString(6,nombre);
            procedimiento.setString(7,categoria);
            procedimiento.setString(8,imagen);
            
            procedimiento.execute();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public String[] getCabecera(){
        return cabecera;
    }
    
}
