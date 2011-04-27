/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;
import GUI.MainFrame;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benlavery
 * @version 110417
 */
public class Controller {

    private MainFrame gui;

    public Controller(){
        gui = new MainFrame();

        //Set maps for GUI
        setMaps();

        gui.setController(this);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.setVisible(true);
            }
        });
    }

    private void setMaps(){
        String OS = System.getProperty("os.name");
        String homeDir = System.getProperty("user.home");
        File mapsDir;
        String mapsPath;

        if(OS.toLowerCase().contains("window")){
            mapsPath = homeDir + "\\My Documents\\My BZFlag Files\\maps";
        }else{
            mapsPath = homeDir + "/.maps";
        }

        mapsDir = new File(mapsPath);
        if(!mapsDir.exists()){
            gui.printError("There is no maps folder in " + mapsPath);
            System.exit(0);
        }
        String[] maps = mapsDir.list();
        if(maps.length == 0){
            gui.printError("There are no suitable maps in " + mapsPath);
            System.exit(0);
        }
        for(int i = 0; i < maps.length; i++){
            if(maps[i].toLowerCase().contains("bzw") || maps[i].toLowerCase().contains("map")){
                gui.getCmbMaps().addItem(maps[i]);
            }
        }
    }

    public void launchServer(){
        if(System.getProperty("os.name").toLowerCase().contains("window")){
            exportSettings(System.getenv("windir") + "\\TEMP\\bzflag-server-gui-temp-config");
        }else{
            exportSettings("/tmp/bzflag-server-gui-temp-config");
            try {
                Process p = Runtime.getRuntime().exec("/usr/games/bzfs -conf /tmp/bzflag-server-gui-temp-config");
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    public void killServer(){

    }

    public void importSettings(){

    }

    public void exportSettings(String path){
        Exporter exp = new Exporter(gui, path);
    }

}
