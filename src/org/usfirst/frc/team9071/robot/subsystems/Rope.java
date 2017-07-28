package org.usfirst.frc.team9071.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Rope extends Subsystem {
	
	SpeedController rp = new Talon(5);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void quick() {
    	rp.set(-1);
    	Timer.delay(0.1);
    	stop();
    }
    public void slow() {
    	rp.set(-.45);
    	Timer.delay(0.1);
    	stop();
    }
    public void stop() {
    	rp.stopMotor();
    }
}

