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

    public Controller(MainFrame mf){
        gui = mf;
        gui.setController(this);
    }

    public void launchServer(){
        System.out.println("HERE");
        exportSettings();
    }

    public void killServer(){

    }

    public void importSettings(){

    }

    public void exportSettings(){
        Exporter exp = new Exporter(gui, "/tmp/myTest.txt");
    }

}
