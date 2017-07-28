package org.usfirst.frc.team9071.robot.commands;

import org.usfirst.frc.team9071.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCs extends Command {
	String me ="";

    public DriveCs(String m) {
        requires(Robot.adr);
        this.me = m;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(me) {
    	case "f":
    		Robot.adr.forward();
    		break;
    	case "tl":
    		Robot.adr.tleft();
    		break;
    	case "tr":
    		Robot.adr.tright();
    		break;
    	case "pl":
    		Robot.adr.pleft();
    		break;
    	case "pr":
    		Robot.adr.pright();
    		break;
    	case "b":
    		Robot.adr.back();
    		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.adr.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
