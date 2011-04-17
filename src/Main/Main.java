package Main;
import GUI.MainFrame;
import java.io.File;
/**
 *
 * @author benlavery
 * @version 110417
 */
public class Main {

    private static getMaps(){
        String systemMapPath;
        String homeMapPath;

        //Get maps
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            systemMapPath = "C:\\Program Files\\BZFlag*\\maps";
            homeMapPath = System.getProperty("user.home") + "\\maps";
        }else{
            //We assume UNIX based
            systemMapPath = "/opt/local/lib/bzflag/maps";
            homeMapPath = System.getProperty("user.home") + "/.maps";
        }

        File path = new File(systemMapPath);
        String[] systemMaps = path.list();
        path = new File(homeMapPath);
        String[] homeMaps = path.list();
    }

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
