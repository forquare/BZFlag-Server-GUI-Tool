package Main;

import GUI.MainFrame;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    private File confFile;

    /**
     * Automagically sets up the GUI
     */
    public Controller(){
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                killServer();
            }
        });

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
        try {
            confFile = File.createTempFile("bzflag-server-gui-temp-config", ".conf");
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(System.getProperty("os.name").toLowerCase().contains("window")){
            if(exportSettings(confFile.getPath())){
                return launchWindows();
            }else{
                return false;
            }
        }else{
            if(exportSettings(confFile.getPath())){
                if(System.getProperty("os.name").toLowerCase().contains("mac")){
                    return launchMac();
                }else{
                    return launchUNIX();
                }
            }else{
                return false;
            }
        }
    }

    /**
     * Allows the suer to manually kill the server
     */
    public void killServer(){
        server.destroy();
        confFile.delete();
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

    private boolean launchMac(){
        try {
            File appDir = new File("/Applications");
            String[] files = appDir.list();
            String BZFlag = new String();
            for (int i = 0; i < files.length; i++) {
                if (files[i].toLowerCase().contains("bzflag")) {
                    BZFlag = files[i];
                    i = files.length;
                }
            }
            if (BZFlag.isEmpty()) {
                gui.printError("Cannot find BZFlag server...");
                return false;
            }
            server = Runtime.getRuntime().exec(
                        "/Applications/" + BZFlag + "/Contents/MacOS/bzfs -conf " + confFile.getPath()
                     );
        } catch (IOException ex) {
            gui.printError("An error has occured in launching the server");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        gui.serverLaunched();
        monitorServerProcess();
        return true;
    }

    private boolean launchUNIX(){
        try {
            File bzfs = new File("/usr/games/bzfs");
            if(!bzfs.exists()){
                gui.printError("Cannot find BZFlag server in \"/usr/games\" ...");
                return false;
            }
            server = Runtime.getRuntime().exec(bzfs.getPath() + " -conf " + confFile.getPath());
        } catch (IOException ex) {
            gui.printError("An error has occured in launching the server");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        gui.serverLaunched();
        monitorServerProcess();
        return true;
    }

    private boolean launchWindows(){
        try {
            File appDir = new File("C:" + File.separator + "Program Files");
            String[] files = appDir.list();
            String BZFlag = new String();
            for (int i = 0; i < files.length; i++) {
                if (files[i].toLowerCase().contains("bzflag")) {
                    BZFlag = files[i];
                    i = files.length;
                }
            }
            if (BZFlag.isEmpty()) {
                gui.printError("Cannot find BZFlag server...");
                return false;
            }
            server = Runtime.getRuntime().exec(
                        appDir.getPath() + File.separator + BZFlag + File.separator +
                        "bzfs -conf " + confFile.getPath()
                    );
        } catch (IOException ex) {
            gui.printError("An error has occured in launching the server");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        gui.serverLaunched();
        monitorServerProcess();
        return true;
    }

    //If the server process exits, we can automagically reset parts of the GUI
    private void monitorServerProcess(){

        Thread t = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);
                        server.exitValue();
                        killServer();
                        return;
                    } catch (IllegalThreadStateException e) {
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        t.start();
    }
}
