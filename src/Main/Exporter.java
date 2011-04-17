/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;
import GUI.MainFrame;
import java.util.Vector;

/**
 *
 * @author benlavery
 * @version 110417
 */
public class Exporter {

    private MainFrame gui;
    private String path;
    final int INITIAL_VECTOR_COUNT = 99;
    private Vector<String> options = new Vector<String>(INITIAL_VECTOR_COUNT);

    public Exporter(MainFrame mf, String p){
        gui = mf;
        path = p;
        export();
    }

    private void export(){
        //Go through each editable widget and get their value.
        //Set an element in the array as the output


        //Set debug level
        StringBuilder sb = new StringBuilder();
        sb.append("-");
        for(int i = 0; i < gui.getSldDebugLevel().getValue(); i++){
            sb.append("d");
        }
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set admin password
        //We check passwords are the same before we leave the GUI
        sb.append("-");
        sb.append(gui.getPassAdminPassword().getPassword());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set inertia
        sb.append("- ");
        sb.append(gui.getSpnInertiaX().getValue());
        sb.append(" ");
        sb.append(gui.getSpnInertiaY().getValue());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set world path

        
    }


}
