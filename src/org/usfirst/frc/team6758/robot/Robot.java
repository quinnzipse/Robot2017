//This is were everything comes together

package org.usfirst.frc.team6758.robot;

import org.usfirst.frc.team6758.robot.commands.*;
import org.usfirst.frc.team6758.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6758.robot.subsystems.ExampleSubsystem;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
		//anything stored here, is available throughout this class.
	
	//Start up subsystems
	public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static DriveTrain driveTrain = new DriveTrain();

	Command autonomousCommand;
	
	SendableChooser<CommandGroup> chooser; 
	
	@Override
	public void robotInit() {
		//starts cameras
    	CameraServer camera = CameraServer.getInstance();
    	camera.startAutomaticCapture(0);
    	camera.startAutomaticCapture(1);
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
		
		chooser = new SendableChooser<>();

		//List of autonomous commands to pick from
		chooser.addDefault("Do Nothing", new AutoDoNothing());
		chooser.addObject("Middle Start", new AutoDriveForward());
		chooser.addObject("Left Start", new AutoLeftPosition());
		chooser.addObject("Right Start", new AutoRightPosition());
		chooser.addObject("Drive Forward (Right or Left)", new AutoForwardOnly());
		chooser.addObject("Drive Forward (Middle)", new AutoMiddleForwardOnly());

		//Asks what autonomous command you would like to run
		SmartDashboard.putData("Autonomous", chooser);
		
		DriveTrain.leftback.setVoltageRampRate(6);
		DriveTrain.leftfront.setVoltageRampRate(6);
		DriveTrain.rightback.setVoltageRampRate(6);
		DriveTrain.rightfront.setVoltageRampRate(6);
		
		autonomousCommand = chooser.getSelected();
		
		//If there is an autonomous command this will start it
		if (autonomousCommand != null){
			autonomousCommand.start();
		}
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		DriveTrain.leftback.setVoltageRampRate(0);
		DriveTrain.leftfront.setVoltageRampRate(0);
		DriveTrain.rightback.setVoltageRampRate(0);
		DriveTrain.rightfront.setVoltageRampRate(0); 
		
		new DriveWithJoystick().start();
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