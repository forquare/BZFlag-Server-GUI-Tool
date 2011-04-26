/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;
import GUI.MainFrame;

/**
 *
 * @author benlavery
 * @version 110417
 */
public class Controller {

    private MainFrame gui;

    public Controller(){
        gui = new MainFrame();
        gui.setController(this);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.setVisible(true);
            }
        });
    }

    public void launchServer(){
        exportSettings();
        //Run server
    }

    public void killServer(){

    }

    public void importSettings(){

    }

    public void exportSettings(){
        Exporter exp = new Exporter(gui, "/tmp/myTest.txt");
    }

}
