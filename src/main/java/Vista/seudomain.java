
package Vista;
import Controlador.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;

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
    TablaCliente tabla = new TablaCliente();
    ControladorTablaCliente cont = new ControladorTablaCliente(con, tabla);
    cont.iniciar_vista();
    frame frame = new frame();
    frame.setLayout(new BorderLayout());
    frame.add(tabla);
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
