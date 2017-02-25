//This is were everything comes together

package org.usfirst.frc.team6758.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6758.robot.subsystems.*;
import org.usfirst.frc.team6758.robot.RobotMap;
import org.usfirst.frc.team6758.robot.commands.*;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

public class Robot extends IterativeRobot {
		//anything stored here, is available throughout this class.
	
	//Start up subsystems
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain driveTrain = new DriveTrain();
	
	
	public static OI oi; //Not sure about this one either - I do not think we need this
	
	//These are placeholders
	RobotDrive robotDrive;
	CameraServer camera;
	Command autonomousCommand;
	
	SendableChooser<Command> chooser; //This had something to do with autonomous
	public static Boolean autonomousEnabled = true;
	@Override
	public void robotInit() {
		//starts cameras
    	camera = CameraServer.getInstance();
    	camera.startAutomaticCapture(0);
    	camera.startAutomaticCapture(1);
    	
    	//Turns off stupid error message
		robotDrive.setSafetyEnabled(false);
    	
		oi = new OI(); //Not sure about this one
		
		//I JUST DID THIS
		chooser = new SendableChooser<>();
		
		//List of autonomous commands to pick from
		chooser.addDefault("Do Nothing", new Wait(15));
		chooser.addObject("Drive Forward", new AutoDriveForward());
		
		//Asks what autonomous command you would like to run
		SmartDashboard.putData("Autonomous", chooser);
		
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void autonomousInit() {
		autonomousCommand = new AutoDriveForward();
		
		//If there is an autonomous command this will start it
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		}
	
	public Robot() {
		//turn on robot drive
				robotDrive = new RobotDrive( driveTrain.leftfront, driveTrain.leftback, driveTrain.rightfront , driveTrain.rightback);
				
				robotDrive.setExpiration(0.1);
		}
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run(); 
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}