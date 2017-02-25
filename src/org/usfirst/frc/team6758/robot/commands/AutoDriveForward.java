package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveForward extends CommandGroup {

	public AutoDriveForward() {
    	
    	double driveBackSpeed = .15;
    	double driveBackTime = 1.5;
    	
    	double driveForwardSpeed = .2;
    	double driveForwardTime = 1.5;
    	
    	double missFactor = 1;
    	double strafePower = .25;
    	
        addSequential(new DriveForward(1, .25));
        addSequential(new DriveForward(driveForwardTime, driveForwardSpeed));
        addSequential(new DriveBackwards(driveBackTime, driveBackSpeed));
        addSequential(new StrafeLeft(missFactor, strafePower));
        addSequential(new DriveForward(driveForwardTime, driveForwardSpeed));
        addSequential(new DriveBackwards(driveBackTime, driveBackSpeed));
        addSequential(new DriveBackwards(.75, .25));
        addSequential(new StrafeLeft(2, .5));
        addSequential(new DriveForward(2, .5));
        }
}

