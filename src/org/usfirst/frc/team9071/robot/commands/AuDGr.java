package org.usfirst.frc.team9071.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AuDGr extends CommandGroup {

    public AuDGr() {
        addSequential(new DriveCs("f"),1);/*
        addSequential(new DriveCs("pl"),0.5);
        addSequential(new DriveCs("tr"),0.5);
        addSequential(new DriveCs("b"),0.4);
        addSequential(new DriveCs("f"),1);
        addSequential(new GearPegC(true),0.7);*/
    }
}
