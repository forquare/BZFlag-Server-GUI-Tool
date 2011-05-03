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
	protected JSpinner spnSuperBullet = new JSpinner(new SpinnerNumberModel(0, -1, 999, 1));
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
	protected JCheckBox chkAllBadFlags = new JCheckBox("All bad flags on", true);
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
	private JLabel lblQuickTurn = new JLabel("Quick Turn");
	private JLabel lblSuperBullet = new JLabel("Super Bullet");
	private JLabel lblSeer = new JLabel("Seer");
	private JLabel lblShield = new JLabel("Shield");
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
	private JLabel lblColourBlindness = new JLabel("Colour Blindness");
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
	private JLabel lblNumberOfFlags = new JLabel("Number Of Flags");
	private JLabel lblGoodFlags = new JLabel("Good Flags");
	private JLabel lblGoodFlags2 = new JLabel("More Good Flags");
	private JLabel lblBadFlags = new JLabel("Bad Flags");
	
	private final String NORTH = SpringLayout.NORTH;
	private final String EAST = SpringLayout.EAST;
	private final String SOUTH = SpringLayout.SOUTH;
	private final String WEST = SpringLayout.WEST;
	
	public Flags(Window w){
		Window window = w;
		init();
		this.setPreferredSize(new Dimension(625, 600));
	}
	
	private void init(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		this.add(lblGoodFlags);
		layout.putConstraint(NORTH, lblGoodFlags, 10, NORTH, this);
		layout.putConstraint(WEST, lblGoodFlags, 10, WEST, this);
		
		this.add(lblGoodFlags2);
		layout.putConstraint(NORTH, lblGoodFlags2, 10, NORTH, this);
		layout.putConstraint(WEST, lblGoodFlags2, 250, WEST, this);
		
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
		
		this.add(spnLaser);
		layout.putConstraint(NORTH, spnLaser, 5, SOUTH, spnInvisibleBullet);
		layout.putConstraint(WEST, spnLaser, 10, WEST, this);
		this.add(lblLaser);
		layout.putConstraint(NORTH, lblLaser, 5, NORTH, spnLaser);
		layout.putConstraint(WEST, lblLaser, 10, EAST, spnLaser);
		
		this.add(spnMachineGun);
		layout.putConstraint(NORTH, spnMachineGun, 5, SOUTH, spnLaser);
		layout.putConstraint(WEST, spnMachineGun, 10, WEST, this);
		this.add(lblMachineGun);
		layout.putConstraint(NORTH, lblMachineGun, 5, NORTH, spnMachineGun);
		layout.putConstraint(WEST, lblMachineGun, 10, EAST, spnMachineGun);
		
		this.add(spnNarrow);
		layout.putConstraint(NORTH, spnNarrow, 5, SOUTH, spnMachineGun);
		layout.putConstraint(WEST, spnNarrow, 10, WEST, this);
		this.add(lblNarrow);
		layout.putConstraint(NORTH, lblNarrow, 5, NORTH, spnNarrow);
		layout.putConstraint(WEST, lblNarrow, 10, EAST, spnNarrow);
		
		this.add(spnOscillationOverthruster);
		layout.putConstraint(NORTH, spnOscillationOverthruster, 5, SOUTH, spnNarrow);
		layout.putConstraint(WEST, spnOscillationOverthruster, 10, WEST, this);
		this.add(lblOscillationOverthruster);
		layout.putConstraint(NORTH, lblOscillationOverthruster, 5, NORTH, spnOscillationOverthruster);
		layout.putConstraint(WEST, lblOscillationOverthruster, 10, EAST, spnOscillationOverthruster);
		
		this.add(spnPhantomZone);
		layout.putConstraint(NORTH, spnPhantomZone, 5, SOUTH, spnOscillationOverthruster);
		layout.putConstraint(WEST, spnPhantomZone, 10, WEST, this);
		this.add(lblPhantomZone);
		layout.putConstraint(NORTH, lblPhantomZone, 5, NORTH, spnPhantomZone);
		layout.putConstraint(WEST, lblPhantomZone, 10, EAST, spnPhantomZone);
		
		this.add(spnQuickTurn);
		layout.putConstraint(NORTH, spnQuickTurn, 5, SOUTH, spnPhantomZone);
		layout.putConstraint(WEST, spnQuickTurn, 10, WEST, this);
		this.add(lblQuickTurn);
		layout.putConstraint(NORTH, lblQuickTurn, 5, NORTH, spnQuickTurn);
		layout.putConstraint(WEST, lblQuickTurn, 10, EAST, spnQuickTurn);
		
		this.add(spnSuperBullet);
		layout.putConstraint(NORTH, spnSuperBullet, 5, SOUTH, spnQuickTurn);
		layout.putConstraint(WEST, spnSuperBullet, 10, WEST, this);
		this.add(lblSuperBullet);
		layout.putConstraint(NORTH, lblSuperBullet, 5, NORTH, spnSuperBullet);
		layout.putConstraint(WEST, lblSuperBullet, 10, EAST, spnSuperBullet);
		
		this.add(spnSeer);
		layout.putConstraint(NORTH, spnSeer, 5, SOUTH, spnSuperBullet);
		layout.putConstraint(WEST, spnSeer, 10, WEST, this);
		this.add(lblSeer);
		layout.putConstraint(NORTH, lblSeer, 5, NORTH, spnSeer);
		layout.putConstraint(WEST, lblSeer, 10, EAST, spnSeer);
		
		this.add(spnShield);
		layout.putConstraint(NORTH, spnShield, 5, SOUTH, spnSeer);
		layout.putConstraint(WEST, spnShield, 10, WEST, this);
		this.add(lblShield);
		layout.putConstraint(NORTH, lblShield, 5, NORTH, spnShield);
		layout.putConstraint(WEST, lblShield, 10, EAST, spnShield);
		
		this.add(spnSteamroller);
		layout.putConstraint(NORTH, spnSteamroller, 5, SOUTH, spnShield);
		layout.putConstraint(WEST, spnSteamroller, 10, WEST, this);
		this.add(lblSteamroller);
		layout.putConstraint(NORTH, lblSteamroller, 5, NORTH, spnSteamroller);
		layout.putConstraint(WEST, lblSteamroller, 10, EAST, spnSteamroller);
		
		this.add(spnStealth);
		layout.putConstraint(NORTH, spnStealth, 5, SOUTH, spnSteamroller);
		layout.putConstraint(WEST, spnStealth, 10, WEST, this);
		this.add(lblStealth);
		layout.putConstraint(NORTH, lblStealth, 5, NORTH, spnStealth);
		layout.putConstraint(WEST, lblStealth, 10, EAST, spnStealth);
		
		this.add(spnShockwave);
		layout.putConstraint(NORTH, spnShockwave, 5, SOUTH, lblGoodFlags);
		layout.putConstraint(WEST, spnShockwave, 250, WEST, this);
		this.add(lblShockwave);
		layout.putConstraint(NORTH, lblShockwave, 5, NORTH, spnShockwave);
		layout.putConstraint(WEST, lblShockwave, 10, EAST, spnShockwave);
		
		this.add(spnTiny);
		layout.putConstraint(NORTH, spnTiny, 5, SOUTH, spnShockwave);
		layout.putConstraint(WEST, spnTiny, 250, WEST, this);
		this.add(lblTiny);
		layout.putConstraint(NORTH, lblTiny, 5, NORTH, spnTiny);
		layout.putConstraint(WEST, lblTiny, 10, EAST, spnTiny);
		
		this.add(spnTheif);
		layout.putConstraint(NORTH, spnTheif, 5, SOUTH, spnTiny);
		layout.putConstraint(WEST, spnTheif, 250, WEST, this);
		this.add(lblTheif);
		layout.putConstraint(NORTH, lblTheif, 5, NORTH, spnTheif);
		layout.putConstraint(WEST, lblTheif, 10, EAST, spnTheif);
		
		this.add(spnUseless);
		layout.putConstraint(NORTH, spnUseless, 5, SOUTH, spnTheif);
		layout.putConstraint(WEST, spnUseless, 250, WEST, this);
		this.add(lblUseless);
		layout.putConstraint(NORTH, lblUseless, 5, NORTH, spnUseless);
		layout.putConstraint(WEST, lblUseless, 10, EAST, spnUseless);
		
		this.add(spnHighSpeed);
		layout.putConstraint(NORTH, spnHighSpeed, 5, SOUTH, spnUseless);
		layout.putConstraint(WEST, spnHighSpeed, 250, WEST, this);
		this.add(lblHighSpeed);
		layout.putConstraint(NORTH, lblHighSpeed, 5, NORTH, spnHighSpeed);
		layout.putConstraint(WEST, lblHighSpeed, 10, EAST, spnHighSpeed);
		
		this.add(spnWings);
		layout.putConstraint(NORTH, spnWings, 5, SOUTH, spnHighSpeed);
		layout.putConstraint(WEST, spnWings, 250, WEST, this);
		this.add(lblWings);
		layout.putConstraint(NORTH, lblWings, 5, NORTH, spnWings);
		layout.putConstraint(WEST, lblWings, 10, EAST, spnWings);
		
		this.add(spnJumping);
		layout.putConstraint(NORTH, spnJumping, 5, SOUTH, spnWings);
		layout.putConstraint(WEST, spnJumping, 250, WEST, this);
		this.add(lblJumping);
		layout.putConstraint(NORTH, lblJumping, 5, NORTH, spnJumping);
		layout.putConstraint(WEST, lblJumping, 10, EAST, spnJumping);
		
		this.add(spnRicocheting);
		layout.putConstraint(NORTH, spnRicocheting, 5, SOUTH, spnJumping);
		layout.putConstraint(WEST, spnRicocheting, 250, WEST, this);
		this.add(lblRicocheting);
		layout.putConstraint(NORTH, lblRicocheting, 5, NORTH, spnRicocheting);
		layout.putConstraint(WEST, lblRicocheting, 10, EAST, spnRicocheting);
		
		this.add(chkAllGoodFlags);
		layout.putConstraint(NORTH, chkAllGoodFlags, 5, SOUTH, spnRicocheting);
		layout.putConstraint(WEST, chkAllGoodFlags, 250, WEST, this);
		
		this.add(lblBadFlags);
		layout.putConstraint(NORTH, lblBadFlags, 10, NORTH, this);
		layout.putConstraint(WEST, lblBadFlags, 430, WEST, this);
		
		this.add(spnBlindness);
		spnBlindness.setEnabled(false);
		layout.putConstraint(NORTH, spnBlindness, 5, SOUTH, lblBadFlags);
		layout.putConstraint(WEST, spnBlindness, 430, WEST, this);
		this.add(lblBlindness);
		layout.putConstraint(NORTH, lblBlindness, 5, NORTH, spnBlindness);
		layout.putConstraint(WEST, lblBlindness, 10, EAST, spnBlindness);
		
		this.add(spnBouncy);
		spnBouncy.setEnabled(false);
		layout.putConstraint(NORTH, spnBouncy, 5, SOUTH, spnBlindness);
		layout.putConstraint(WEST, spnBouncy, 430, WEST, this);
		this.add(lblBouncy);
		layout.putConstraint(NORTH, lblBouncy, 5, NORTH, spnBouncy);
		layout.putConstraint(WEST, lblBouncy, 10, EAST, spnBouncy);
		
		this.add(spnColourBlindness);
		spnColourBlindness.setEnabled(false);
		layout.putConstraint(NORTH, spnColourBlindness, 5, SOUTH, spnBouncy);
		layout.putConstraint(WEST, spnColourBlindness, 430, WEST, this);
		this.add(lblColourBlindness);
		layout.putConstraint(NORTH, lblColourBlindness, 5, NORTH, spnColourBlindness);
		layout.putConstraint(WEST, lblColourBlindness, 10, EAST, spnColourBlindness);
		
		this.add(spnForwardOnly);
		spnForwardOnly.setEnabled(false);
		layout.putConstraint(NORTH, spnForwardOnly, 5, SOUTH, spnColourBlindness);
		layout.putConstraint(WEST, spnForwardOnly, 430, WEST, this);
		this.add(lblForwardOnly);
		layout.putConstraint(NORTH, lblForwardOnly, 5, NORTH, spnForwardOnly);
		layout.putConstraint(WEST, lblForwardOnly, 10, EAST, spnForwardOnly);
		
		this.add(spnJamming);
		spnJamming.setEnabled(false);
		layout.putConstraint(NORTH, spnJamming, 5, SOUTH, spnForwardOnly);
		layout.putConstraint(WEST, spnJamming, 430, WEST, this);
		this.add(lblJamming);
		layout.putConstraint(NORTH, lblJamming, 5, NORTH, spnJamming);
		layout.putConstraint(WEST, lblJamming, 10, EAST, spnJamming);
		
		this.add(spnLeftTurnOnly);
		spnLeftTurnOnly.setEnabled(false);
		layout.putConstraint(NORTH, spnLeftTurnOnly, 5, SOUTH, spnJamming);
		layout.putConstraint(WEST, spnLeftTurnOnly, 430, WEST, this);
		this.add(lblLeftTurnOnly);
		layout.putConstraint(NORTH, lblLeftTurnOnly, 5, NORTH, spnLeftTurnOnly);
		layout.putConstraint(WEST, lblLeftTurnOnly, 10, EAST, spnLeftTurnOnly);
		
		this.add(spnMomentum);
		spnMomentum.setEnabled(false);
		layout.putConstraint(NORTH, spnMomentum, 5, SOUTH, spnLeftTurnOnly);
		layout.putConstraint(WEST, spnMomentum, 430, WEST, this);
		this.add(lblMomentum);
		layout.putConstraint(NORTH, lblMomentum, 5, NORTH, spnMomentum);
		layout.putConstraint(WEST, lblMomentum, 10, EAST, spnMomentum);
		
		this.add(spnNoJumping);
		spnNoJumping.setEnabled(false);
		layout.putConstraint(NORTH, spnNoJumping, 5, SOUTH, spnMomentum);
		layout.putConstraint(WEST, spnNoJumping, 430, WEST, this);
		this.add(lblNoJumping);
		layout.putConstraint(NORTH, lblNoJumping, 5, NORTH, spnNoJumping);
		layout.putConstraint(WEST, lblNoJumping, 10, EAST, spnNoJumping);
		
		this.add(spnObesity);
		spnObesity.setEnabled(false);
		layout.putConstraint(NORTH, spnObesity, 5, SOUTH, spnNoJumping);
		layout.putConstraint(WEST, spnObesity, 430, WEST, this);
		this.add(lblObesity);
		layout.putConstraint(NORTH, lblObesity, 5, NORTH, spnObesity);
		layout.putConstraint(WEST, lblObesity, 10, EAST, spnObesity);
		
		this.add(spnReverseControlls);
		spnReverseControlls.setEnabled(false);
		layout.putConstraint(NORTH, spnReverseControlls, 5, SOUTH, spnObesity);
		layout.putConstraint(WEST, spnReverseControlls, 430, WEST, this);
		this.add(lblReverseControlls);
		layout.putConstraint(NORTH, lblReverseControlls, 5, NORTH, spnReverseControlls);
		layout.putConstraint(WEST, lblReverseControlls, 10, EAST, spnReverseControlls);
		
		this.add(spnReverseOnly);
		spnReverseOnly.setEnabled(false);
		layout.putConstraint(NORTH, spnReverseOnly, 5, SOUTH, spnReverseControlls);
		layout.putConstraint(WEST, spnReverseOnly, 430, WEST, this);
		this.add(lblReverseOnly);
		layout.putConstraint(NORTH, lblReverseOnly, 5, NORTH, spnReverseOnly);
		layout.putConstraint(WEST, lblReverseOnly, 10, EAST, spnReverseOnly);
		
		this.add(spnRightTurnOnly);
		spnRightTurnOnly.setEnabled(false);
		layout.putConstraint(NORTH, spnRightTurnOnly, 5, SOUTH, spnReverseOnly);
		layout.putConstraint(WEST, spnRightTurnOnly, 430, WEST, this);
		this.add(lblRightTurnOnly);
		layout.putConstraint(NORTH, lblRightTurnOnly, 5, NORTH, spnRightTurnOnly);
		layout.putConstraint(WEST, lblRightTurnOnly, 10, EAST, spnRightTurnOnly);
		
		this.add(spnTriggerHappy);
		spnTriggerHappy.setEnabled(false);
		layout.putConstraint(NORTH, spnTriggerHappy, 5, SOUTH, spnRightTurnOnly);
		layout.putConstraint(WEST, spnTriggerHappy, 430, WEST, this);
		this.add(lblTriggerHappy);
		layout.putConstraint(NORTH, lblTriggerHappy, 5, NORTH, spnTriggerHappy);
		layout.putConstraint(WEST, lblTriggerHappy, 10, EAST, spnTriggerHappy);
		
		this.add(spnWideAngle);
		spnWideAngle.setEnabled(false);
		layout.putConstraint(NORTH, spnWideAngle, 5, SOUTH, spnTriggerHappy);
		layout.putConstraint(WEST, spnWideAngle, 430, WEST, this);
		this.add(lblWideAngle);
		layout.putConstraint(NORTH, lblWideAngle, 5, NORTH, spnWideAngle);
		layout.putConstraint(WEST, lblWideAngle, 10, EAST, spnWideAngle);
		
		this.add(chkAllBadFlags);
		layout.putConstraint(NORTH, chkAllBadFlags, 5, SOUTH, spnWideAngle);
		layout.putConstraint(WEST, chkAllBadFlags, 430, WEST, this);
		
		this.add(chkAntidoteFlags);
		layout.putConstraint(NORTH, chkAntidoteFlags, 0, NORTH, spnSeer);
		layout.putConstraint(WEST, chkAntidoteFlags, 250, WEST, this);
		
		this.add(chkFlagsOnBuildings);
		layout.putConstraint(NORTH, chkFlagsOnBuildings, 5, SOUTH, chkAntidoteFlags);
		layout.putConstraint(WEST, chkFlagsOnBuildings, 250, WEST, this);
		
		this.add(spnExtraFlags);
		layout.putConstraint(NORTH, spnExtraFlags, 5, SOUTH, chkFlagsOnBuildings);
		layout.putConstraint(WEST, spnExtraFlags, 250, WEST, this);
		this.add(lblExtraFlags);
		layout.putConstraint(NORTH, lblExtraFlags, 5, NORTH, spnExtraFlags);
		layout.putConstraint(WEST, lblExtraFlags, 10, EAST, spnExtraFlags);
		
		this.add(spnNumberOfFlags);
		layout.putConstraint(NORTH, spnNumberOfFlags, 5, SOUTH, spnExtraFlags);
		layout.putConstraint(WEST, spnNumberOfFlags, 250, WEST, this);
		this.add(lblNumberOfFlags);
		layout.putConstraint(NORTH, lblNumberOfFlags, 5, NORTH, spnNumberOfFlags);
		layout.putConstraint(WEST, lblNumberOfFlags, 10, EAST, spnNumberOfFlags);
	}
	
	protected int getSpnAgility(){
		return Integer.parseInt(spnAgility.getValue().toString());
	}

	protected void setSpnAgility(int i){
		spnAgility.setValue(i);
	}

	protected int getSpnCloaking(){
		return Integer.parseInt(spnCloaking.getValue().toString());
	}

	protected void setSpnCloaking(int i){
		spnCloaking.setValue(i);
	}

	protected int getSpnRapidFire(){
		return Integer.parseInt(spnRapidFire.getValue().toString());
	}

	protected void setSpnRapidFire(int i){
		spnRapidFire.setValue(i);
	}

	protected int getSpnGenocide(){
		return Integer.parseInt(spnGenocide.getValue().toString());
	}

	protected void setSpnGenocide(int i){
		spnGenocide.setValue(i);
	}

	protected int getSpnGuidedMissile(){
		return Integer.parseInt(spnGuidedMissile.getValue().toString());
	}

	protected void setSpnGuidedMissile(int i){
		spnGuidedMissile.setValue(i);
	}

	protected int getSpnInvisibleBullet(){
		return Integer.parseInt(spnInvisibleBullet.getValue().toString());
	}

	protected void setSpnInvisibleBullet(int i){
		spnInvisibleBullet.setValue(i);
	}

	protected int getSpnLaser(){
		return Integer.parseInt(spnLaser.getValue().toString());
	}

	protected void setSpnLaser(int i){
		spnLaser.setValue(i);
	}

	protected int getSpnMachineGun(){
		return Integer.parseInt(spnMachineGun.getValue().toString());
	}

	protected void setSpnMachineGun(int i){
		spnMachineGun.setValue(i);
	}

	protected int getSpnNarrow(){
		return Integer.parseInt(spnNarrow.getValue().toString());
	}

	protected void setSpnNarrow(int i){
		spnNarrow.setValue(i);
	}

	protected int getSpnOscillationOverthruster(){
		return Integer.parseInt(spnOscillationOverthruster.getValue().toString());
	}

	protected void setSpnOscillationOverthruster(int i){
		spnOscillationOverthruster.setValue(i);
	}

	protected int getSpnPhantomZone(){
		return Integer.parseInt(spnPhantomZone.getValue().toString());
	}

	protected void setSpnPhantomZone(int i){
		spnPhantomZone.setValue(i);
	}

	protected int getSpnQuickTurn(){
		return Integer.parseInt(spnQuickTurn.getValue().toString());
	}

	protected void setSpnQuickTurn(int i){
		spnQuickTurn.setValue(i);
	}

	protected int getSpnSuperBullet(){
		return Integer.parseInt(spnSuperBullet.getValue().toString());
	}

	protected void setSpnSuperBullet(int i){
		spnSuperBullet.setValue(i);
	}

	protected int getSpnSeer(){
		return Integer.parseInt(spnSeer.getValue().toString());
	}

	protected void setSpnSeer(int i){
		spnSeer.setValue(i);
	}

	protected int getSpnShield(){
		return Integer.parseInt(spnShield.getValue().toString());
	}

	protected void setSpnShield(int i){
		spnShield.setValue(i);
	}

	protected int getSpnSteamroller(){
		return Integer.parseInt(spnSteamroller.getValue().toString());
	}

	protected void setSpnSteamroller(int i){
		spnSteamroller.setValue(i);
	}

	protected int getSpnStealth(){
		return Integer.parseInt(spnStealth.getValue().toString());
	}

	protected void setSpnStealth(int i){
		spnStealth.setValue(i);
	}

	protected int getSpnShockwave(){
		return Integer.parseInt(spnShockwave.getValue().toString());
	}

	protected void setSpnShockwave(int i){
		spnShockwave.setValue(i);
	}

	protected int getSpnTiny(){
		return Integer.parseInt(spnTiny.getValue().toString());
	}

	protected void setSpnTiny(int i){
		spnTiny.setValue(i);
	}

	protected int getSpnTheif(){
		return Integer.parseInt(spnTheif.getValue().toString());
	}

	protected void setSpnTheif(int i){
		spnTheif.setValue(i);
	}

	protected int getSpnUseless(){
		return Integer.parseInt(spnUseless.getValue().toString());
	}

	protected void setSpnUseless(int i){
		spnUseless.setValue(i);
	}

	protected int getSpnHighSpeed(){
		return Integer.parseInt(spnHighSpeed.getValue().toString());
	}

	protected void setSpnHighSpeed(int i){
		spnHighSpeed.setValue(i);
	}

	protected int getSpnWings(){
		return Integer.parseInt(spnWings.getValue().toString());
	}

	protected void setSpnWings(int i){
		spnWings.setValue(i);
	}

	protected int getSpnJumping(){
		return Integer.parseInt(spnJumping.getValue().toString());
	}

	protected void setSpnJumping(int i){
		spnJumping.setValue(i);
	}

	protected int getSpnRicocheting(){
		return Integer.parseInt(spnRicocheting.getValue().toString());
	}

	protected void setSpnRicocheting(int i){
		spnRicocheting.setValue(i);
	}

	protected int getSpnBlindness(){
		return Integer.parseInt(spnBlindness.getValue().toString());
	}

	protected void setSpnBlindness(int i){
		spnBlindness.setValue(i);
	}

	protected int getSpnBouncy(){
		return Integer.parseInt(spnBouncy.getValue().toString());
	}

	protected void setSpnBouncy(int i){
		spnBouncy.setValue(i);
	}

	protected int getSpnColourBlindness(){
		return Integer.parseInt(spnColourBlindness.getValue().toString());
	}

	protected void setSpnColourBlindness(int i){
		spnColourBlindness.setValue(i);
	}

	protected int getSpnForwardOnly(){
		return Integer.parseInt(spnForwardOnly.getValue().toString());
	}

	protected void setSpnForwardOnly(int i){
		spnForwardOnly.setValue(i);
	}

	protected int getSpnJamming(){
		return Integer.parseInt(spnJamming.getValue().toString());
	}

	protected void setSpnJamming(int i){
		spnJamming.setValue(i);
	}

	protected int getSpnLeftTurnOnly(){
		return Integer.parseInt(spnLeftTurnOnly.getValue().toString());
	}

	protected void setSpnLeftTurnOnly(int i){
		spnLeftTurnOnly.setValue(i);
	}

	protected int getSpnMomentum(){
		return Integer.parseInt(spnMomentum.getValue().toString());
	}

	protected void setSpnMomentum(int i){
		spnMomentum.setValue(i);
	}

	protected int getSpnNoJumping(){
		return Integer.parseInt(spnNoJumping.getValue().toString());
	}

	protected void setSpnNoJumping(int i){
		spnNoJumping.setValue(i);
	}

	protected int getSpnObesity(){
		return Integer.parseInt(spnObesity.getValue().toString());
	}

	protected void setSpnObesity(int i){
		spnObesity.setValue(i);
	}

	protected int getSpnReverseControlls(){
		return Integer.parseInt(spnReverseControlls.getValue().toString());
	}

	protected void setSpnReverseControlls(int i){
		spnReverseControlls.setValue(i);
	}

	protected int getSpnReverseOnly(){
		return Integer.parseInt(spnReverseOnly.getValue().toString());
	}

	protected void setSpnReverseOnly(int i){
		spnReverseOnly.setValue(i);
	}

	protected int getSpnRightTurnOnly(){
		return Integer.parseInt(spnRightTurnOnly.getValue().toString());
	}

	protected void setSpnRightTurnOnly(int i){
		spnRightTurnOnly.setValue(i);
	}

	protected int getSpnTriggerHappy(){
		return Integer.parseInt(spnTriggerHappy.getValue().toString());
	}

	protected void setSpnTriggerHappy(int i){
		spnTriggerHappy.setValue(i);
	}

	protected int getSpnWideAngle(){
		return Integer.parseInt(spnWideAngle.getValue().toString());
	}

	protected void setSpnWideAngle(int i){
		spnWideAngle.setValue(i);
	}

	protected boolean getChkAllGoodFlags(){
		return chkAllGoodFlags.isSelected();
	}

	protected void setChkAllGoodFlags(boolean b){
		chkAllGoodFlags.setSelected(b);
	}

	protected boolean getChkAllBadFlags(){
		return chkAllBadFlags.isSelected();
	}

	protected void setChkAllBadFlags(boolean b){
		chkAllBadFlags.setSelected(b);
	}

	protected boolean getChkAntidoteFlags(){
		return chkAntidoteFlags.isSelected();
	}

	protected void setChkAntidoteFlags(boolean b){
		chkAntidoteFlags.setSelected(b);
	}

	protected boolean getChkFlagsOnBuildings(){
		return chkFlagsOnBuildings.isSelected();
	}

	protected void setChkFlagsOnBuildings(boolean b){
		chkFlagsOnBuildings.setSelected(b);
	}

	protected int getSpnExtraFlags(){
		return Integer.parseInt(spnExtraFlags.getValue().toString());
	}

	protected void setSpnExtraFlags(int i){
		spnExtraFlags.setValue(i);
	}

	protected int getSpnNumberOfFlags(){
		return Integer.parseInt(spnNumberOfFlags.getValue().toString());
	}

	protected void setSpnNumberOfFlags(int i){
		spnNumberOfFlags.setValue(i);
	}
	
	private void setGoodFlagsEnabled(boolean b){
		
	}
	
	private void setBadFlagsEnabled(boolean b){
		
	}
}