package org.usfirst.frc.team9071.robot;

import org.usfirst.frc.team9071.robot.commands.GearPegC;
import org.usfirst.frc.team9071.robot.commands.RopeC;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick s01 = new Joystick(0);
	Joystick s02 = new Joystick(1);
	Button b11 = new JoystickButton(s01,1);
	Button b12 = new JoystickButton(s01,2);
	Button b13 = new JoystickButton(s01,3);
	Button b14 = new JoystickButton(s01,4);
	Button b21 = new JoystickButton(s02,1);
	Button b22 = new JoystickButton(s02,2);
	Button b23 = new JoystickButton(s02,3);
	Button b24 = new JoystickButton(s02,4);
	
	public OI() {
		b11.whileHeld(new GearPegC(false));
		b12.whileHeld(new GearPegC(true));
		b21.whileHeld(new GearPegC(false));
		b22.whileHeld(new GearPegC(true));
		b13.whileHeld(new RopeC(false));
		b14.whileHeld(new RopeC(true));
		b23.whileHeld(new RopeC(false));
		b24.whileHeld(new RopeC(true));
	}
	public Joystick j1() {
		return s01;
	}
	public Joystick j21() {
		return s02;
	}
}
