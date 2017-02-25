package org.usfirst.frc.team6758.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftPosition extends CommandGroup {

    public AutoLeftPosition() {
    	
    	double driveBackSpeed = .15;
    	double driveBackTime = 1.5;
    	
    	double driveForwardSpeed = .2;
    	double driveForwardTime = 1.5;
    	
    	double missFactor = 1;
    	double strafePower = .25;
    	
    	double turnTime = .5;
    	double turnSpeed = .25;
    	
        addSequential(new DriveForward(3, .25));
        addSequential(new TurnClock(turnTime, turnSpeed));
        addSequential(new DriveForward(driveForwardTime, driveForwardSpeed));
        addSequential(new DriveBackwards(driveBackTime, driveBackSpeed));
        addSequential(new StrafeLeft(missFactor, strafePower));
        addSequential(new DriveForward(driveForwardTime, driveForwardSpeed));
        addSequential(new DriveBackwards(driveBackTime, driveBackSpeed));
        addSequential(new StrafeRight(missFactor*2, strafePower));
        addSequential(new DriveForward(driveForwardTime, driveForwardSpeed));
        addSequential(new DriveBackwards(driveBackTime, driveBackSpeed));
        addSequential(new DriveBackwards(1, .25));
        addSequential(new TurnCounter(turnTime, turnSpeed));
        addParallel(new DriveForward(2, .25));
        
        }
}

