package gui;

import java.awt.Dimension;

import javax.swing.*;

public class Server extends JPanel {
	
	private Window window;
	
	protected JTextField txtPublicMessage = new JTextField("Noo BZFlag Server");
	protected JTextField txtPublicAddress = new JTextField("123.456.789.000:5154");
	protected JTextField txtListeningPort = new JTextField("5154");
	protected JTextField txtListeningAddress = new JTextField("");
	protected JTextField txtPathToPasswordDB = new JTextField("");
	protected JTextField txtPathtoUserDB = new JTextField("");
	protected JTextField txtPathToGroupDB = new JTextField("");
	protected JTextField txtRegisteredGroupName = new JTextField("");
	protected JTextField txtPathToBanFile = new JTextField("");
	protected JTextField txtBanAddress = new JTextField("");
	protected JTextField txtPathToPIDFile = new JTextField("");
	
	
	public Server(Window w){
		Window window = w;
		init();
		this.setPreferredSize(new Dimension(625, 600));
	}
	
	private void init(){
		
	}
	
}
