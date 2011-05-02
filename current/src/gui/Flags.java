package gui;

import java.awt.Dimension;

import javax.swing.*;

public class Flags extends JPanel {
	
	private Window window;
	
	//Good Flags
	protected JSpinner spnAgility = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnCloaking = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnRapidFire = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnGenocide = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnGuidedMissile = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnInvisibleBullet = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnLaser = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnMachineGun = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnNarrow = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnOscillationOverthruster = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnPhantomZone = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnQuickTurn = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnSuperBulet = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnSeer = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnShield = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnSteamroller = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnStealth = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnShockwave = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnTiny = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnTheif = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnUseless = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnHighSpeed = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnWings = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnJumping = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	protected JSpinner spnRicocheting = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
	
	//Bad Flags
	protected JSpinner spnBlindness = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnBouncy = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnColourBlindness = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnForwardOnly = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnJamming = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnLeftTurnOnly = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnMomentum = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnNoJumping = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnObesity = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnReverseControlls = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnReverseOnly = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnRightTurnOnly = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnTriggerHappy = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	protected JSpinner spnWideAngle = new JSpinner(new SpinnerNumberModel(-1, -1, 999, 1));
	
	//Other editable fields
	protected JCheckBox chkAllGoodFlags = new JCheckBox("All good flags on", true);
	protected JCheckBox chkAllBadFlags = new JCheckBox("All bad flags on", false);
	protected JCheckBox chkAntidoteFlags = new JCheckBox("Antidote flags", false);
	protected JCheckBox chkFlagsOnBuildings = new JCheckBox("Flags on buildings", false);
	protected JSpinner spnExtraFlags = new JSpinner(new SpinnerNumberModel(0, 0, 999, 1));
	protected JSpinner spnNumberOfFlags = new JSpinner(new SpinnerNumberModel(30, 0, 999, 1));
	
	//Labels 43
	private JLabel lblAgility = new JLabel("Agility");
	private JLabel lblCloaking = new JLabel("Cloaking");
	private JLabel lblRapidFire = new JLabel("Rapid Fire");
	private JLabel lblGenocide = new JLabel("Genocide");
	private JLabel lblGuidedMissile = new JLabel("Guided Missile");
	private JLabel lblInvisibleBullet = new JLabel("Invisible Bullet");
	private JLabel lblLaser = new JLabel("Laser");
	private JLabel lblMachineGun = new JLabel("Machine Gun");
	private JLabel lblNarrow = new JLabel("Narrow");
	private JLabel lblOscillationOverthruster = new JLabel("Oscillation Overthruster");
	private JLabel lblPhantomZone = new JLabel("Phantom Zone");
	private JLabel lblQuickTurn = new JLabel("BLLAAAAQuickturnAHHHH");
	private JLabel lblSuperBullet = new JLabel("Super Bullet");
	private JLabel lblSeer = new JLabel("Seer");
	private JLabel lblSteamroller = new JLabel("Steamroller");
	private JLabel lblStealth = new JLabel("Stealth");
	private JLabel lblShockwave = new JLabel("Shockwave");
	private JLabel lblTiny = new JLabel("Tiny");
	private JLabel lblTheif = new JLabel("Theif");
	private JLabel lblUseless = new JLabel("Useless");
	private JLabel lblHighSpeed = new JLabel("High Speed");
	private JLabel lblWings = new JLabel("Wings");
	private JLabel lblJumping = new JLabel("Jumping");
	private JLabel lblRicocheting = new JLabel("Ricocheting");
	private JLabel lblBlindness = new JLabel("Blindness");
	private JLabel lblBouncy = new JLabel("Bouncy");
	private JLabel lblColourblindness = new JLabel("Colour Blindness");
	private JLabel lblForwardOnly = new JLabel("Forward Only");
	private JLabel lblJamming = new JLabel("Jamming");
	private JLabel lblLeftTurnOnly = new JLabel("Left Turn Only");
	private JLabel lblMomentum = new JLabel("Momentum");
	private JLabel lblNoJumping = new JLabel("No Jumping");
	private JLabel lblObesity = new JLabel("Obesity");
	private JLabel lblReverseControlls = new JLabel("Reverse Controlls");
	private JLabel lblReverseOnly = new JLabel("Reverse Only");
	private JLabel lblRightTurnOnly = new JLabel("Right Turn Only");
	private JLabel lblTriggerHappy = new JLabel("Trigger Happy");
	private JLabel lblWideAngle = new JLabel("Wide Angle");
	private JLabel lblExtraFlags = new JLabel("Extra Flags");
	private JLabel lblFlagsOnBuildings = new JLabel("Flags On Buildings");
	private JLabel lblGoodFlags = new JLabel("Good Flags");
	private JLabel lblBadFlags = new JLabel("Bad Flags");
	
	private final String NORTH = SpringLayout.NORTH;
	private final String EAST = SpringLayout.EAST;
	private final String SOUTH = SpringLayout.SOUTH;
	private final String WEST = SpringLayout.WEST;
	
	public Flags(Window w){
		Window window = w;
		init();
		this.setPreferredSize(new Dimension(500, 600));
	}
	
	private void init(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.add(lblGoodFlags);
		layout.putConstraint(NORTH, lblGoodFlags, 10, NORTH, this);
		layout.putConstraint(WEST, lblGoodFlags, 60, WEST, this);
		
		this.add(spnAgility);
		layout.putConstraint(NORTH, spnAgility, 5, SOUTH, lblGoodFlags);
		layout.putConstraint(WEST, spnAgility, 10, WEST, this);
		this.add(lblAgility);
		layout.putConstraint(NORTH, lblAgility, 5, NORTH, spnAgility);
		layout.putConstraint(WEST, lblAgility, 10, EAST, spnAgility);
		
		this.add(spnCloaking);
		layout.putConstraint(NORTH, spnCloaking, 5, SOUTH, spnAgility);
		layout.putConstraint(WEST, spnCloaking, 10, WEST, this);
		this.add(lblCloaking);
		layout.putConstraint(NORTH, lblCloaking, 5, NORTH, spnCloaking);
		layout.putConstraint(WEST, lblCloaking, 10, EAST, spnCloaking);
		
		this.add(spnRapidFire);
		layout.putConstraint(NORTH, spnRapidFire, 5, SOUTH, spnCloaking);
		layout.putConstraint(WEST, spnRapidFire, 10, WEST, this);
		this.add(lblRapidFire);
		layout.putConstraint(NORTH, lblRapidFire, 5, NORTH, spnRapidFire);
		layout.putConstraint(WEST, lblRapidFire, 10, EAST, spnRapidFire);
		
		this.add(spnGenocide);
		layout.putConstraint(NORTH, spnGenocide, 5, SOUTH, spnRapidFire);
		layout.putConstraint(WEST, spnGenocide, 10, WEST, this);
		this.add(lblGenocide);
		layout.putConstraint(NORTH, lblGenocide, 5, NORTH, spnGenocide);
		layout.putConstraint(WEST, lblGenocide, 10, EAST, spnGenocide);
		
		this.add(spnGuidedMissile);
		layout.putConstraint(NORTH, spnGuidedMissile, 5, SOUTH, spnGenocide);
		layout.putConstraint(WEST, spnGuidedMissile, 10, WEST, this);
		this.add(lblGuidedMissile);
		layout.putConstraint(NORTH, lblGuidedMissile, 5, NORTH, spnGuidedMissile);
		layout.putConstraint(WEST, lblGuidedMissile, 10, EAST, spnGuidedMissile);
		
		this.add(spnInvisibleBullet);
		layout.putConstraint(NORTH, spnInvisibleBullet, 5, SOUTH, spnGuidedMissile);
		layout.putConstraint(WEST, spnInvisibleBullet, 10, WEST, this);
		this.add(lblInvisibleBullet);
		layout.putConstraint(NORTH, lblInvisibleBullet, 5, NORTH, spnInvisibleBullet);
		layout.putConstraint(WEST, lblInvisibleBullet, 10, EAST, spnInvisibleBullet);
		
		
	}
	
}