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
        
        //se crean los cardlayout
        cardLayout = new CardLayout(); //el de aca es para cambiar entre los paneles granddes (de toda la pantalla) 
        CardLayout cardLayout2 = new CardLayout();// el de aca para cambiar los paneles de la parte d abajo de la vista usuario
        
        
        //Se crea el frame que contendra TODOS los paneles
        principal = new Principal();
        

        // Inicializar las vistas 
        panelTienda tienda = new panelTienda();
        VistaInfo pd1 = new VistaInfo();
        TablaCliente tablaCliente = new TablaCliente();
        JpanelCarrito carrito = new JpanelCarrito();
        VistaAlmacen almacen = new VistaAlmacen();
        Login login = new Login();
        RegistrarCliente registrar = new RegistrarCliente();
        
        //se desgina cada cardlayout a su respectivo contenedor
        tienda.panelInicio.setLayout(cardLayout2);
        principal.background.setLayout(cardLayout);
        
        
        //se incializan todos los controladores
        ControladorPanelCarrito conCarr = new ControladorPanelCarrito(carrito, con);//depende de id
        ControladorVistaInfo contInfo = new ControladorVistaInfo(pd1, cardLayout2, con,conCarr);
        ControladorTablaCliente contro = new ControladorTablaCliente(con, tablaCliente,cardLayout2,tienda.panelInicio,contInfo,pd1,contInfo);
        contro.iniciar_vista();
        ControladorPanelTienda conTienda = new ControladorPanelTienda(tienda, con,tienda.panelInicio,cardLayout2,cardLayout,principal.background,tablaCliente);//aca maneja dos cardLayout pq trabaja con l panel mas grande y el panel peqeuño
        ControladorAlmacen cont = new ControladorAlmacen(con, almacen,cardLayout,principal.background);
        cont.iniciar_vista();
        ControladorRegistroCliente conRegistro = new ControladorRegistroCliente(registrar, cardLayout, con, principal);
        
        controladorLogin contLog = new controladorLogin(login, cardLayout, con,principal,conCarr,contInfo,tablaCliente);
        System.out.println("wasaaa: "+login.ID);//lo de aca es solo pa verificar si se setea el ID
        
        

        
        //Se añaden los paneles al contenedor principal
        principal.background.add(tienda,"tienda");
        principal.background.add(login, "login");
        principal.background.add(registrar, "registro");
        principal.background.add(almacen, "almacen");
        
        //se añaden los paneles al contenedor de la vista cliente(el cuadro de abajo)
        tienda.panelInicio.add(tablaCliente,"cliente");
        tienda.panelInicio.add(carrito,"carrito");
        tienda.panelInicio.add(pd1,"detalles");
        

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

