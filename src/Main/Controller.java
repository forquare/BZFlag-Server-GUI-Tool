package Main;

import GUI.MainFrame;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This controller class is responsible for instantiating the GUI and other components in the system.
 * 
 * @author benlavery
 * @version 110430
 */
public class Controller {

    private MainFrame gui;
    private Process server;

    /**
     * Automagically sets up the GUI
     */
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

    /**
     * Looks at pre-defined directories for map files
     */
    private void setMaps(){
        String OS = System.getProperty("os.name");
        String homeDir = System.getProperty("user.home");
        StringBuilder sb = new StringBuilder();
        File mapsDirectory;
        String[] maps;

        if(OS.toLowerCase().contains("window")){
            sb.append(homeDir);
            sb.append(File.separator);
            sb.append("My Documents");
            sb.append(File.separator);
            sb.append("My BZFlag Files");
            sb.append(File.separator);
            sb.append("maps");
        }else{
            //Assume UNIX based
            sb.append(homeDir);
            sb.append(File.separator);
            sb.append("Documents");
            sb.append(File.separator);
            sb.append("My BZFlag Files");
            sb.append(File.separator);
            sb.append("maps");
        }

        mapsDirectory = new File(sb.toString());
        if(!mapsDirectory.exists() || !mapsDirectory.isDirectory()){
            //If the maps directory doesn't exist, force the user to
            //use a random map
            gui.setRandomWorld(true, false);
            //Tell user of this action
            gui.printError("Because I can't find \"" + mapsDirectory.getPath() +
                    "\"\nI will only allow you to use random maps.");
        }else{
            maps = mapsDirectory.list();
            for(int i = 0; i < maps.length; i++){
                if(maps[i].toLowerCase().contains("bzw") || maps[i].toLowerCase().contains("map")){
                    gui.getCmbMaps().addItem(maps[i]);
                }
            }

            //If there are no maps, force user to use a random map
            if(gui.getCmbMaps().getItemCount() == 0){
                gui.setRandomWorld(true, false);
                gui.printError("Because I can't find any suitable files in\n\"" + mapsDirectory.getPath() +
                    "\"\nI will only allow you to use random maps.");
            }
        }
    }

    /**
     * Launches the server
     *
     * @return True if the launching of the server was successful, False if it was not.
     */
    public boolean launchServer(){
        if(System.getProperty("os.name").toLowerCase().contains("window")){
            if(exportSettings(System.getenv("windir") + File.separator + "TEMP" + File.separator+ "bzflag-server-gui-temp-config")){
                //Launch Windows server
            }
        }else{
            if(exportSettings("/tmp/bzflag-server-gui-temp-config")){
                if(System.getProperty("os.name").toLowerCase().contains("mac")){
                    try {
                        File appDir = new File ("/Applications");
                        String[] files = appDir.list();
                        String BZFlag = new String();
                        for(int i = 0; i < files.length; i++){
                            if(files[i].toLowerCase().contains("bzflag")){
                                BZFlag = files[i];
                                i = files.length;
                            }
                        }
                        if(BZFlag.isEmpty()){
                            gui.printError("Cannot find BZFlag server...");
                            return false;
                        }
                        server = Runtime.getRuntime().exec(
                            "/Applications/" + BZFlag + "/Contents/MacOS/bzfs -conf /tmp/bzflag-server-gui-temp-config"
                        );
                    } catch (IOException ex) {
                        gui.printError("An error has occured in launching the server");
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
                }else{
                    //Launch Linux server from /usr/games
                }
            }else{
                return false;
            }
        }
        gui.serverLaunched();
        return true;
    }

    /**
     * Allows the suer to manually kill the server
     */
    public void killServer(){
        server.destroy();
        if(System.getProperty("os.name").toLowerCase().contains("window")){
            File f = new File(System.getenv("windir") + File.separator + "TEMP" + File.separator+ "bzflag-server-gui-temp-config");
            f.delete();
        }else{
            File f = new File("/tmp/bzflag-server-gui-temp-config");
            f.delete();
        }
        gui.serverKilled();
    }

    /**
     * Allows the user to import settings from a file into the GUI.
     */
    public void importSettings(){

    }

    /**
     * Allows user to export data from the GUI into a file.
     *
     * @param path - A String containing the path of the file to write.
     * @return True if the writing of the file was successful, False if it was not.
     */
    public boolean exportSettings(String path){
        try {
            new Exporter(gui, path);
        } catch (IOException ex) {
            gui.printError("An error has occured in exporting your settings");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
