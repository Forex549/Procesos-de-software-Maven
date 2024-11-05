
package Controlador;
import Conexión.Conexión;
import Vista.Principal;
/**
 *
 * @author Giancarlo
 */
public class Main {
    public Principal principal;

    public Main() {
        principal = new Principal();
    }
    
    public static void main(String[] args) {
        Conexión con = new Conexión();
        con.conectar();
        Main objMain = new Main();
        objMain.mostrarMenu();
    }

    public void mostrarMenu() {
        principal.setVisible(true);
    }
}
