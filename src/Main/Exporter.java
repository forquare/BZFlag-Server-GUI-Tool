/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;
import GUI.MainFrame;
import util.FileReadWrite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

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

    public Exporter(JFrame mf, String p){
        gui = (MainFrame) mf;
        path = p;
        gatherData();
        exportData();
    }

    private void gatherData(){
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
        sb.append("-password ");
        sb.append(gui.getPassAdminPassword().getPassword());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set inertia
        sb.append("-a ");
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
            sb.append(gui.getCmbMaps().getSelectedItem().toString());
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
            sb.append("-mps ");
            sb.append(gui.getSpnMaxPlayerScore().getValue().toString());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set max score for teams
        if(Integer.parseInt(gui.getSpnMaxTeamScore().getValue().toString()) > 0){
            sb.append("-mts ");
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
            sb.append("-time ");
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

        //Set public message
        sb.append("-public \"");
        sb.append(gui.getTxtPublicMessage().getText());
        sb.append("\"");
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set public address
        sb.append("-publicaddr ");
        sb.append(gui.getTxtPublicAddress().getText());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set server listening port
        sb.append("-p ");
        sb.append(gui.getTxtListeningPort().getText());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set server to not respond to pings
        if(gui.getChkMakeServerPrivate().isSelected()){
            sb.append("-q");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set interface
        if(!gui.getTxtListeningAddress().getText().isEmpty()){
            sb.append("-i ");
            sb.append(gui.getTxtListeningAddress().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set require UDP
        if(gui.getChkRequireUDP().isSelected()){
            sb.append("-requireudp");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set auto team
        if(gui.getChkAutoTeam().isSelected()){
            sb.append("-autoTeam");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set max players
        sb.append("-mp ");
        sb.append(gui.getSpnMaxPlayers().getValue());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set passwd file
        if(!gui.getTxtPathToPasswordDatabase().getText().isEmpty()){
            sb.append("-passdb ");
            sb.append(gui.getTxtPathToPasswordDatabase().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set user file
        if(!gui.getTxtPathToUserDatabase().getText().isEmpty()){
            sb.append("-userdb ");
            sb.append(gui.getTxtPathToUserDatabase().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set groups file
        if(!gui.getTxtPathToGroupDatabase().getText().isEmpty()){
            sb.append("-groupdb ");
            sb.append(gui.getTxtPathToGroupDatabase().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set registered group
        if(!gui.getTxtRegisteredGroupName().getText().isEmpty()){
            sb.append("-advertise ");
            sb.append(gui.getTxtRegisteredGroupName().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set max idle time
        sb.append("-maxidle ");
        sb.append(gui.getSpnMaxIdleTime().getValue());
        options.add(sb.toString());
        sb.delete(0, sb.length());

        //Set lag announce to admin
        if(Integer.parseInt(gui.getSpnAdminAnnounceLag().getValue().toString()) > 0){
            sb.append("-adminlagannounce ");
            sb.append(gui.getSpnAdminAnnounceLag().getValue());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }
        
        //Set lag announce to player
        if(Integer.parseInt(gui.getSpnAnnounceLag().getValue().toString()) > 0){
            sb.append("-lagannounce ");
            sb.append(gui.getSpnAnnounceLag().getValue());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set kick if lag is too high
        if(Integer.parseInt(gui.getSpnKickPlayerAfterlag().getValue().toString()) > 0){
            sb.append("-lagdrop ");
            sb.append(gui.getSpnKickPlayerAfterlag().getValue());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set ban file
        if(!gui.getTxtPathToBanFile().getText().isEmpty()){
            sb.append("-banfile ");
            sb.append(gui.getTxtPathToBanFile().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set banned addresses
        if(!gui.getTxtBanAddresses().getText().isEmpty()){
            sb.append("-ban ");
            sb.append(gui.getTxtBanAddresses().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Add timestamps to log
        if(gui.getChkAddTimestampToLog().isSelected()){
            sb.append("-ts");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set PID file
        if(!gui.getTxtPathToPIDFile().getText().isEmpty()){
            sb.append("-pidfile ");
            sb.append(gui.getTxtPathToPIDFile().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set server message
        if(!gui.getTxtWelcomeMessage().getText().isEmpty()){
            BufferedReader buf = new BufferedReader(new StringReader(gui.getTxtWelcomeMessage().getText()));
            String messageLine = new String();
            try {
                while ((messageLine = buf.readLine()) != null) {
                    sb.append("-srvmsg \"");
                    sb.append(messageLine);
                    sb.append("\"");
                    options.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } catch (IOException ex) {
                Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Set admin message
        if(!gui.getTxtBroadcastMessage().getText().isEmpty()){
            BufferedReader buf = new BufferedReader(new StringReader(gui.getTxtBroadcastMessage().getText()));
            String messageLine = new String();
            try {
                while ((messageLine = buf.readLine()) != null) {
                    sb.append("-admsg \"");
                    sb.append(messageLine);
                    sb.append("\"");
                    options.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            } catch (IOException ex) {
                Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Set spam time
        if(Integer.parseInt(gui.getSpnSpamTime().getValue().toString()) > 0){
            sb.append("-spamtime ");
            sb.append(gui.getSpnSpamTime().getValue());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set PID file
        if(!gui.getTxtPathToBadWords().getText().isEmpty()){
            sb.append("-badwords ");
            sb.append(gui.getTxtPathToBadWords().getText());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set filter chat
        if(gui.getChkFilterChat().isSelected()){
            sb.append("-filterChat");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set filter call signs
        if(gui.getChkFilterCallSigns().isSelected()){
            sb.append("-filterCallsigns");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set simple filter
        if(gui.getChkFilterChatSimple().isSelected()){
            sb.append("-filterSimple");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set sync time
        if(gui.getChkSyncTimeWithServer().isSelected()){
            sb.append("-synctime");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    private void exportData() {
        FileReadWrite frw = new FileReadWrite();
        frw.writer(options, path);
    }
}
