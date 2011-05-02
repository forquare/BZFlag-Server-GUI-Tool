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
	
	private GamePlay tabGamePlay;
	private Server tabServer;
	private Flags tabFlags;
	
	private JTabbedPane tabMainPane;
	private JButton btnLaunchServer;
	private JButton btnKillServer;
	private JButton btnImportSettings;
	private JButton btnExportSettings;
	private JLabel lblVersion;
	
	private final String NORTH = SpringLayout.NORTH;
	private final String EAST = SpringLayout.EAST;
	private final String SOUTH = SpringLayout.SOUTH;
	private final String WEST = SpringLayout.WEST;
	
	
	public Window(Controller c){
		controller = c;
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BZFlag Server GUI");
        setResizable(false);
	}
	
	/*
	 * Testing only!
	 */
	public Window(){
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BZFlag Server GUI");
        setResizable(false);
	}
	
	private void init(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.add(tabMainPane);
		layout.putConstraint(NORTH, tabMainPane, 10, NORTH, this);
		layout.putConstraint(WEST, tabMainPane, 10, WEST, this);
		layout.putConstraint(EAST, tabMainPane, 10, EAST, this);
		
	}

}
