package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveForward extends CommandGroup {

    public AutoDriveForward() {
    	
        addSequential(new DriveForward(3.3, .25));
        addSequential(new Wait(.5));
        addSequential(new DriveBackwards(2, .1));
        addSequential(new DriveBackwards(1.2, .25));
        addSequential(new Wait(.1));
        addSequential(new StrafeLeft(1, .25));
        addSequential(new StrafeLeft(1, 1));
    }
}
