
package Controlador;
import Conexión.Conexión;
import Vista.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.*;
import java.awt.*;
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
        FlatMaterialLighterIJTheme.setup();
        
        Main objMain = new Main();
        objMain.mostrarMenu();
    }

    public void mostrarMenu() {
        principal.setVisible(true);
    }
}

    
