package Controlador;

import Conexión.Conexión;
import Vista.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import Modelo.*;

public class Main2 {

    private static String url = "jdbc:mysql://35.247.214.45:3306/bdprocesos";
    private static String user = "root";
    private static String pass = "Tesla5890";

    private Principal principal;
    private CardLayout cardLayout;

    public Main2() {
        // Inicialización de la interfaz y configuración de CardLayout
        principal = new Principal();
        cardLayout = new CardLayout();
        principal.background.setLayout(cardLayout);

        // Configuración del tema
        FlatMaterialLighterIJTheme.setup();

        // Inicializar paneles y controladores
        inicializarComponentes();
    }

    public static void main(String[] args) {

        Main2 objMain = new Main2();
        objMain.mostrarMenu();
    }

    private void inicializarComponentes() {
        // Establecer conexión a la base de datos
        Connection con = conectar();
        
        // Inicializar las vistas y los controladores
        Login login = new Login(cardLayout, principal);
        int ID = login.ID;
        VistaAlmacen almacen = new VistaAlmacen();
        ControladorAlmacen cont = new ControladorAlmacen(con, almacen);
        cont.iniciar_vista();

        // Añadir los paneles al contenedor principal
        principal.background.add(login, "login");
        principal.background.add(almacen, "almacen");

        // Mostrar el panel de login inicialmente
        cardLayout.show(principal.background, "login");
    }

    public void mostrarMenu() {
        // Mostrar la ventana principal
        principal.setVisible(true);
    }

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

