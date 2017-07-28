package org.usfirst.frc.team9071.robot.subsystems;

import org.usfirst.frc.team9071.robot.commands.GearPegC;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends Subsystem {
	
	SpeedController gr = new Talon(4);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new GearPegC(false));
    }
    
    public void up() {
    	gr.set(-.5);
    	Timer.delay(0.1);
    	stop();
    }
    
    public void down() {
    	gr.set(.3);
    	Timer.delay(0.1);
    	stop();
    }
    public void stop() {
    	gr.stopMotor();
    }
}

