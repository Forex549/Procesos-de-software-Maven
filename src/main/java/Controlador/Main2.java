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
        CardLayout cardLayout2 = new CardLayout();
        // Inicializar las vistas y los controladores
        panelTienda tienda = new panelTienda();
       
        tienda.panelInicio.setLayout(cardLayout2);
        TablaCliente tablaCliente = new TablaCliente();
        ControladorTablaCliente contro = new ControladorTablaCliente(con, tablaCliente);
        contro.iniciar_vista();
        JpanelCarrito carrito = new JpanelCarrito();
        Login login = new Login(cardLayout, principal);
        int ID = login.ID;
        VistaAlmacen almacen = new VistaAlmacen();
        ControladorPanelTienda conTienda = new ControladorPanelTienda(tienda, con,tienda.panelInicio,cardLayout2);
        ControladorAlmacen cont = new ControladorAlmacen(con, almacen,cardLayout,principal.background);
        cont.iniciar_vista();
        

        // Añadir los paneles al contenedor principal
        principal.background.add(tienda,"tienda");
        principal.background.add(login, "login");
        principal.background.add(almacen, "almacen");
        
        tienda.panelInicio.add(tablaCliente,"cliente");
        tienda.panelInicio.add(carrito,"carrito");

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

