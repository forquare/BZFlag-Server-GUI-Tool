/*
 * Copyright (c) 2011, Ben Lavery
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package gui;

import java.awt.event.KeyEvent;

import javax.swing.*;

import general.Controller;

/**
 * Creates the main window and inserts a JTabbedPane
 * for which JPanels sit in.
 *
 * @author benlavery
 * @version 110502
 */
public class Window extends JFrame{
	
	private Controller controller;
	
	private GamePlay tabGamePlay = new GamePlay();
	private Server tabServer = new Server();
	private Flags tabFlags = new Flags(this);
	
	private JTabbedPane tabMainPane = new JTabbedPane();
	private JButton btnLaunchServer = new JButton("Launch Server");
	private JButton btnKillServer = new JButton("Kill Server");
	private JButton btnImportSettings = new JButton("Import Settings");
	private JButton btnExportSettings = new JButton("Export Settings");
	
	private final String NORTH = SpringLayout.NORTH;
	private final String EAST = SpringLayout.EAST;
	private final String SOUTH = SpringLayout.SOUTH;
	private final String WEST = SpringLayout.WEST;
	
	
	public Window(Controller c){
		controller = c;
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BZFlag Server GUI - BETA");
        setResizable(false);
	}
	
	/*
	 * Testing only!
	 */
	public Window(){
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BZFlag Server GUI - BETA");
        setResizable(true);
        pack();
        setVisible(true);
	}
	
	private void init(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		tabMainPane.addTab("Game Play", tabGamePlay);
		tabMainPane.setMnemonicAt(0, KeyEvent.VK_1);
		tabMainPane.addTab("Server", tabServer);
		tabMainPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabMainPane.addTab("Flags", tabFlags);
		tabMainPane.setMnemonicAt(2, KeyEvent.VK_3);
		
		this.add(tabMainPane);
		layout.putConstraint(NORTH, tabMainPane, 10, NORTH, this);
		layout.putConstraint(WEST, tabMainPane, 10, WEST, this);
		
		this.add(btnImportSettings);
		layout.putConstraint(NORTH, btnImportSettings, 5, SOUTH, tabMainPane);
		layout.putConstraint(WEST, btnImportSettings, 0, WEST, tabMainPane);
		
		this.add(btnExportSettings);
		layout.putConstraint(NORTH, btnExportSettings, 5, SOUTH, tabMainPane);
		layout.putConstraint(WEST, btnExportSettings, 5, EAST, btnImportSettings);
		
		this.add(btnLaunchServer);
		layout.putConstraint(NORTH, btnLaunchServer, 5, SOUTH, tabMainPane);
		layout.putConstraint(EAST, btnLaunchServer, 0, EAST, tabMainPane);
		
		this.add(btnKillServer);
		layout.putConstraint(NORTH, btnKillServer, 5, SOUTH, tabMainPane);
		layout.putConstraint(EAST, btnKillServer, 5, WEST, btnLaunchServer);
		
	}

}
