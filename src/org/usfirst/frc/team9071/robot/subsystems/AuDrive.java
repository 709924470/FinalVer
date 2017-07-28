package org.usfirst.frc.team9071.robot.subsystems;

import org.usfirst.frc.team9071.robot.commands.DriveCs;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AuDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	RobotDrive ed = new RobotDrive(0,2,1,3);
	ADXRS450_Gyro myGyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCs(""));
    	ed.setInvertedMotor(MotorType.kFrontRight, true);
    	ed.setInvertedMotor(MotorType.kRearRight, true);
    	myGyro.reset();
    }
    private double angle(){
    	return myGyro.getAngle();
    }
    public void jsdrive(Joystick js, double speed) {
    	if(speed>1.0) {
    		speed = 1.0;
    	}else if(speed<1.0) {
    		speed = 0.0;
    	}
    	ed.mecanumDrive_Cartesian(speed*-js.getY(), -speed*js.getX(), js.getZ(), 0);
    }
    public void forward() {
    	ed.mecanumDrive_Cartesian(.7, 0, -angle()/30 ,0);
    }
    public void tleft() {
    	ed.mecanumDrive_Cartesian(.7, 0, -30 ,angle());
    }
    public void tright() {
    	ed.mecanumDrive_Cartesian(0, 0, 30 ,angle());
    }
    public void pleft () {
    	ed.mecanumDrive_Cartesian(0, .7, -angle()/30 ,0);
    }
    public void pright() {
    	ed.mecanumDrive_Cartesian(0, -.7, -angle()/30 ,0);
    }
    public void back() {
    	ed.mecanumDrive_Cartesian(-.7, 0, -angle()/30 ,0);
    }
    public void stop() {
    	ed.stopMotor();
    }
}

