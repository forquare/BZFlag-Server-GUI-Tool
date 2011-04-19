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

        //Setup world/maps
        if(gui.getChkRandomWorld().isSelected()){
            if(gui.getChkRandomRotateObjects().isSelected()){
                sb.append("-b");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            sb.append("-density");
            sb.append(gui.getSpnBuildingDensity().getValue());
            options.add(sb.toString());
            sb.delete(0, sb.length());

            sb.append("-worldsize");
            sb.append(gui.getSpnWorldSize().getValue());
            options.add(sb.toString());
            sb.delete(0, sb.length());

            if(gui.getCmbGameStyle().getSelectedItem().toString().equalsIgnoreCase("capture the flag")){
                sb.append("-cr");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(gui.getChkRandomHeightBuildings().isSelected()){
                sb.append("-h");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }else{
            sb.append("-world \"");
            sb.append(gui.getCmbGameStyle().getSelectedItem().toString());
            sb.append("\"");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        
        //Set teleporters
        if(gui.getChkAddTeleporters().isSelected()){
            sb.append("-t");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set game style
        sb.append("-");
        if(gui.getCmbGameStyle().getSelectedItem().toString().equalsIgnoreCase("free for all")){
            //Do nothing
        }
        if(gui.getCmbGameStyle().getSelectedItem().toString().equalsIgnoreCase("capture the flag")){
            if(!gui.getChkRandomWorld().isSelected()){
                sb.append("c");
                options.add(sb.toString());
            }
        }
        if(gui.getCmbGameStyle().getSelectedItem().toString().equalsIgnoreCase("rabbit based on score")){
            sb.append("rabbit score");
            options.add(sb.toString());
        }
        if(gui.getCmbGameStyle().getSelectedItem().toString().equalsIgnoreCase("rabbit based on killer")){
            sb.append("rabbit killer");
            options.add(sb.toString());
        }
        if(gui.getCmbGameStyle().getSelectedItem().toString().equalsIgnoreCase("rabbit random")){
            sb.append("rabbit random");
            options.add(sb.toString());
        }
        sb.delete(0, sb.length());

        //Set max shots
        sb.append("-ms ");
        sb.append(gui.getSpnMaxShots().getValue());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Make shots ricochet
        if(gui.getChkRicochet().isSelected()){
            sb.append("+r");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Allow jumping
        if(gui.getChkJumping().isSelected()){
            sb.append("-j");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }






        
        
    }


}
