
package Vista;
import Controlador.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Giancarlo
 */
public class seudomain {
    
    private static String url="jdbc:mysql://35.247.214.45:3306/bdprocesos";
    private static String user="root";
   private static String pass="Tesla5890";
    
    public static void main(String[] args) {
     
        Connection con = seudomain.conectar();
        VistaAlmacen alm = new VistaAlmacen();
        ControladorAlmacen cont = new ControladorAlmacen(con,alm);
        cont.iniciar_vista();
        frame frame = new frame();
        frame.setLayout(new BorderLayout());
        frame.add(alm);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
    public static Connection conectar()
    {
       Connection con=null;
       try
       {
       con = DriverManager.getConnection(url,user,pass);
       System.out.println("Conexión exitosa");
       }catch(Exception e)
       {
        e.printStackTrace();
       }
       
       return con;
               
    }
    
    
    
}
