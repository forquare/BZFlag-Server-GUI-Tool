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

            sb.append("-density ");
            sb.append(gui.getSpnBuildingDensity().getValue());
            options.add(sb.toString());
            sb.delete(0, sb.length());

            sb.append("-worldsize ");
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

        if(gui.getChkAllGoodflagsOn().isSelected()){
            sb.append("+f good");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }else{
            if(Integer.parseInt(gui.getSpnAgility().getValue().toString()) == -1){
                sb.append("-f A");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnAgility().getValue().toString()) == 0){
                sb.append("+f A{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f A{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl A ");
                sb.append(gui.getSpnAgility().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnCloaking().getValue().toString()) == -1){
                sb.append("-f CL");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnCloaking().getValue().toString()) == 0){
                sb.append("+f CL{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f CL{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl CL ");
                sb.append(gui.getSpnCloaking().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnRapidFire().getValue().toString()) == -1){
                sb.append("-f F");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnRapidFire().getValue().toString()) == 0){
                sb.append("+f F{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f F{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl F ");
                sb.append(gui.getSpnRapidFire().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnGenocide().getValue().toString()) == -1){
                sb.append("-f G");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnGenocide().getValue().toString()) == 0){
                sb.append("+f G{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f G{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl G ");
                sb.append(gui.getSpnGenocide().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnGuidedMissile().getValue().toString()) == -1){
                sb.append("-f GM");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnGuidedMissile().getValue().toString()) == 0){
                sb.append("+f GM{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f GM{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl GM ");
                sb.append(gui.getSpnGuidedMissile().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnInvisibleBullet().getValue().toString()) == -1){
                sb.append("-f IB");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnInvisibleBullet().getValue().toString()) == 0){
                sb.append("+f IB{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f IB{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl IB ");
                sb.append(gui.getSpnInvisibleBullet().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnLaser().getValue().toString()) == -1){
                sb.append("-f L");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnLaser().getValue().toString()) == 0){
                sb.append("+f L{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f L{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl L ");
                sb.append(gui.getSpnLaser().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnMachineGun().getValue().toString()) == -1){
                sb.append("-f MG");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnMachineGun().getValue().toString()) == 0){
                sb.append("+f MG{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f MG{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl MG ");
                sb.append(gui.getSpnMachineGun().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnNarrow().getValue().toString()) == -1){
                sb.append("-f N");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnNarrow().getValue().toString()) == 0){
                sb.append("+f N{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f N{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl N ");
                sb.append(gui.getSpnNarrow().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnOscillationOverthruster().getValue().toString()) == -1){
                sb.append("-f OO");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnOscillationOverthruster().getValue().toString()) == 0){
                sb.append("+f OO{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f OO{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl OO ");
                sb.append(gui.getSpnOscillationOverthruster().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnPhantomZone().getValue().toString()) == -1){
                sb.append("-f PZ");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnPhantomZone().getValue().toString()) == 0){
                sb.append("+f PZ{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f PZ{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl PZ ");
                sb.append(gui.getSpnPhantomZone().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnQuickturn().getValue().toString()) == -1){
                sb.append("-f QT");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnQuickturn().getValue().toString()) == 0){
                sb.append("+f QT{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f QT{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl QT ");
                sb.append(gui.getSpnQuickturn().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnSuperBullet().getValue().toString()) == -1){
                sb.append("-f SB");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnSuperBullet().getValue().toString()) == 0){
                sb.append("+f SB{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f SB{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl SB ");
                sb.append(gui.getSpnSuperBullet().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnSeer().getValue().toString()) == -1){
                sb.append("-f SE");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnSeer().getValue().toString()) == 0){
                sb.append("+f SE{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f SE{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl SE ");
                sb.append(gui.getSpnSeer().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnSheild().getValue().toString()) == -1){
                sb.append("-f SH");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnSheild().getValue().toString()) == 0){
                sb.append("+f SH{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f SH{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl SH ");
                sb.append(gui.getSpnSheild().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnSteamroller().getValue().toString()) == -1){
                sb.append("-f SR");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnSteamroller().getValue().toString()) == 0){
                sb.append("+f SR{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f SR{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl SR ");
                sb.append(gui.getSpnSteamroller().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnStealth().getValue().toString()) == -1){
                sb.append("-f ST");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnStealth().getValue().toString()) == 0){
                sb.append("+f ST{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f ST{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl ST ");
                sb.append(gui.getSpnStealth().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnShockwave().getValue().toString()) == -1){
                sb.append("-f SW");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnShockwave().getValue().toString()) == 0){
                sb.append("+f SW{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f SW{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl SW ");
                sb.append(gui.getSpnShockwave().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnTiny().getValue().toString()) == -1){
                sb.append("-f T");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnTiny().getValue().toString()) == 0){
                sb.append("+f T{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f T{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl T ");
                sb.append(gui.getSpnTiny().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnTheif().getValue().toString()) == -1){
                sb.append("-f TH");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnTheif().getValue().toString()) == 0){
                sb.append("+f TH{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f TH{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl TH ");
                sb.append(gui.getSpnTheif().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnUseless().getValue().toString()) == -1){
                sb.append("-f US");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnUseless().getValue().toString()) == 0){
                sb.append("+f US{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f US{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl US ");
                sb.append(gui.getSpnUseless().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnHighSpeed().getValue().toString()) == -1){
                sb.append("-f V");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnHighSpeed().getValue().toString()) == 0){
                sb.append("+f V{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f V{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl V ");
                sb.append(gui.getSpnHighSpeed().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnWings().getValue().toString()) == -1){
                sb.append("-f WG");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnWings().getValue().toString()) == 0){
                sb.append("+f WG{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f WG{2}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl WG ");
                sb.append(gui.getSpnWings().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(gui.getSpnJumpingFlag().isEnabled()){
                if(Integer.parseInt(gui.getSpnJumpingFlag().getValue().toString()) == -1){
                   sb.append("-f J");
                   options.add(sb.toString());
                   sb.delete(0, sb.length());
                }else if(Integer.parseInt(gui.getSpnJumpingFlag().getValue().toString()) == 0){
                   sb.append("+f J{1}");
                    options.add(sb.toString());
                    sb.delete(0, sb.length());
                }else{
                    sb.append("+f J{1}");
                    options.add(sb.toString());
                    sb.delete(0, sb.length());

                    sb.append("-sl J ");
                    sb.append(gui.getSpnJumpingFlag().getValue().toString());
                    options.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }

            if(gui.getSpnRicochetingFlag().isEnabled()){
                if(Integer.parseInt(gui.getSpnRicochetingFlag().getValue().toString()) == -1){
                   sb.append("-f R");
                   options.add(sb.toString());
                   sb.delete(0, sb.length());
                }else if(Integer.parseInt(gui.getSpnRicochetingFlag().getValue().toString()) == 0){
                   sb.append("+f R{1}");
                    options.add(sb.toString());
                    sb.delete(0, sb.length());
                }else{
                    sb.append("+f R{1}");
                    options.add(sb.toString());
                    sb.delete(0, sb.length());

                    sb.append("-sl R ");
                    sb.append(gui.getSpnRicochetingFlag().getValue().toString());
                    options.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }

        if(gui.getChkAllBadflagsOn().isSelected()){
            sb.append("+f bad");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }else{
            if(Integer.parseInt(gui.getSpnBlindness().getValue().toString()) == -1){
                sb.append("-f B");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnBlindness().getValue().toString()) == 0){
                sb.append("+f B{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f B{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl B ");
                sb.append(gui.getSpnBlindness().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnBouncy().getValue().toString()) == -1){
                sb.append("-f BY");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnBouncy().getValue().toString()) == 0){
                sb.append("+f BY{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f BY{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl BY ");
                sb.append(gui.getSpnBouncy().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnColourBlindness().getValue().toString()) == -1){
                sb.append("-f CB");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnColourBlindness().getValue().toString()) == 0){
                sb.append("+f CB{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f CB{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl CB ");
                sb.append(gui.getSpnColourBlindness().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnForwardOnly().getValue().toString()) == -1){
                sb.append("-f FO");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnForwardOnly().getValue().toString()) == 0){
                sb.append("+f FO{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f FO{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl FO ");
                sb.append(gui.getSpnForwardOnly().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnJamming().getValue().toString()) == -1){
                sb.append("-f JM");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnJamming().getValue().toString()) == 0){
                sb.append("+f JM{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f JM{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl JM ");
                sb.append(gui.getSpnJamming().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnLeftTurnOnly().getValue().toString()) == -1){
                sb.append("-f LT");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnLeftTurnOnly().getValue().toString()) == 0){
                sb.append("+f LT{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f LT{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl LT ");
                sb.append(gui.getSpnLeftTurnOnly().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnMomentum().getValue().toString()) == -1){
                sb.append("-f M");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnMomentum().getValue().toString()) == 0){
                sb.append("+f M{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f M{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl M ");
                sb.append(gui.getSpnMomentum().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnNoJumping().getValue().toString()) == -1){
                sb.append("-f NJ");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnNoJumping().getValue().toString()) == 0){
                sb.append("+f NJ{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f NJ{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl NJ ");
                sb.append(gui.getSpnNoJumping().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnObesity().getValue().toString()) == -1){
                sb.append("-f O");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnObesity().getValue().toString()) == 0){
                sb.append("+f O{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f O{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl O ");
                sb.append(gui.getSpnObesity().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnReverseControlls().getValue().toString()) == -1){
                sb.append("-f RC");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnReverseControlls().getValue().toString()) == 0){
                sb.append("+f RC{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f RC{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl RC ");
                sb.append(gui.getSpnReverseControlls().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnReverseOnly().getValue().toString()) == -1){
                sb.append("-f RO");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnReverseOnly().getValue().toString()) == 0){
                sb.append("+f RO{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f RO{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl RO ");
                sb.append(gui.getSpnReverseOnly().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnRightTurnOnly().getValue().toString()) == -1){
                sb.append("-f RT");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnRightTurnOnly().getValue().toString()) == 0){
                sb.append("+f RT{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f RT{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl RT ");
                sb.append(gui.getSpnRightTurnOnly().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnTriggerHappy().getValue().toString()) == -1){
                sb.append("-f TR");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnTriggerHappy().getValue().toString()) == 0){
                sb.append("+f TR{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f TR{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl TR ");
                sb.append(gui.getSpnTriggerHappy().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }

            if(Integer.parseInt(gui.getSpnWideAngle().getValue().toString()) == -1){
                sb.append("-f WA");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else if(Integer.parseInt(gui.getSpnWideAngle().getValue().toString()) == 0){
                sb.append("+f WA{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }else{
                sb.append("+f WA{1}");
                options.add(sb.toString());
                sb.delete(0, sb.length());

                sb.append("-sl WA ");
                sb.append(gui.getSpnWideAngle().getValue().toString());
                options.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        //Set flags to spawn on buildings
        if(gui.getChkFlagsOnBuildings().isSelected()){
            sb.append("-fb");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set antidote flags
        if(gui.getChkAntidoteFlags().isSelected()){
            sb.append("-sa");
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set extra flags
        if(Integer.parseInt(gui.getSpnExtraFlags().getValue().toString()) != 0){
            sb.append("+s ");
            sb.append(gui.getSpnExtraFlags().getValue().toString());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }

        //Set number of flags
        if(Integer.parseInt(gui.getSpnNumberOfFlags().getValue().toString()) != 0){
            sb.append("-s ");
            sb.append(gui.getSpnNumberOfFlags().getValue().toString());
            options.add(sb.toString());
            sb.delete(0, sb.length());
        }
    }

    private void exportData() {
        FileReadWrite frw = new FileReadWrite();
        frw.writer(options, path);
    }
}
