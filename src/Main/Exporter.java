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

        //Allow players to spawn on buildings
        if(gui.getChkSpawnOnBuilding().isSelected()){
            sb.append("-sb");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Turn off team kills
        if(!gui.getChkDieOnTeamKill().isSelected()){
            sb.append("-tk");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Announce team kills on admin channel
        if(gui.getChkAnnounceTKToAdmins().isSelected()){
            sb.append("-tkannounce");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Kick player for high percentage of TKs
        sb.append("-tkkr ");
        sb.append(gui.getSpnMaxTeamKills().getValue());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Disable bots
        if(gui.getChkDisableBots().isSelected()){
            sb.append("-disableBots");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Quit server after one game
        if(gui.getChkQuiteAfterOneGame().isSelected()){
            sb.append("-q");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set max score for players
        if(Integer.parseInt(gui.getSpnMaxPlayerScore().getValue().toString()) > 0){
            sb.append("-mps");
            sb.append(gui.getSpnMaxPlayerScore().getValue().toString());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set max score for teams
        if(Integer.parseInt(gui.getSpnMaxTeamScore().getValue().toString()) > 0){
            sb.append("-mts");
            sb.append(gui.getSpnMaxTeamScore().getValue().toString());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }
        
        //Set print score to console
        if(gui.getChkPrintScoreToConsole().isSelected()){
            sb.append("-printscore");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set time for game
        if(Integer.parseInt(gui.getSpnGameTime().getValue().toString()) > 0){
            sb.append("-time");
            sb.append(gui.getSpnGameTime().getValue().toString());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set manual start of game
        if(gui.getChkManuallyStartTimedGame().isSelected()){
            sb.append("-timemanual");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }
        
        


        
    }
}
