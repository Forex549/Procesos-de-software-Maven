/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;
import Vista.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Giancarlo
 */
public class Main2 {
    
    private static String url="jdbc:mysql://35.247.214.45:3306/bdprocesos";
    private static String user="root";
    private static String pass="Tesla5890";
    
    public static void main(String[] args) {
        
        Connection con = seudomain.conectar();
        FlatMaterialLighterIJTheme.setup();
        
        Principal principal = new Principal();
        //JPanel contenedor = new JPanel();
        CardLayout cardLayout = new CardLayout();//este ees un objeto q permite trabajar con varios paneles en uno, como cavmair de paneles
        principal.background.setLayout(cardLayout);//se configura cual es el panel q conendra a todos
        //contenedor.setLayout(cardLayout);

        
        Login login = new Login(cardLayout,principal); //se crea el obejto vente del login
        VistaAlmacen almacen = new VistaAlmacen(); //se crea el objeto bventana del almacen
        ControladorAlmacen cont = new ControladorAlmacen(con,almacen);//controlador del almacen
        cont.iniciar_vista();//cosa del controlador pa q cargue los datos

        //se añaden los paneles al panel "madre"
        principal.background.add(login, "login");
        principal.background.add(almacen, "almacen");

       //codigo desechado, xsiaca lo deje
       //principal.background.setLayout(new BorderLayout());
        //principal.background.add(contenedor,BorderLayout.CENTER);
        //principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.pack();
       //.show muestra el panel q quieres, aca pal inicio muestra el login
        cardLayout.show(principal.background, "login");
        
        principal.setVisible(true);
       
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
