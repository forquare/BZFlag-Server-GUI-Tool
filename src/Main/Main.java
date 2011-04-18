package Main;
import GUI.MainFrame;
import java.io.File;
/**
 *
 * @author benlavery
 * @version 110417
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final MainFrame gui = new MainFrame();
        final Controller controller = new Controller(gui);

        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.setVisible(true);
            }
        });
    }

}
