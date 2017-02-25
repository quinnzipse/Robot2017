package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoForwardOnly extends CommandGroup {

    public AutoForwardOnly() {
    	
    	addSequential(new Wait(0));
    	addSequential(new DriveForward(15, 1));
    	
    }
}