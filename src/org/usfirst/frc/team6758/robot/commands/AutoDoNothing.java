package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDoNothing extends CommandGroup {

    public AutoDoNothing() {

    	addSequential(new Wait(15));
    	
    }
}
