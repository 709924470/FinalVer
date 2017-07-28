package org.usfirst.frc.team9071.robot.commands;

import org.usfirst.frc.team9071.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RopeC extends Command {
	
	boolean qui = false;

    public RopeC(boolean quic) {
    	requires(Robot.rope);
    	this.qui = quic;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(qui) {
    		Robot.rope.quick();
    	}else {
    		Robot.rope.slow();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rope.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
