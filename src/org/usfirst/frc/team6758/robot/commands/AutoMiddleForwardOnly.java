package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMiddleForwardOnly extends CommandGroup {

    public AutoMiddleForwardOnly() {

    	addSequential(new Wait(0));
    	addSequential(new StrafeRight(1, .5));
    	addSequential(new StrafeLeft(1, .5));
    	addSequential(new Wait(0));
    	addSequential(new DriveForward(4, .5));
    	
    }
}
