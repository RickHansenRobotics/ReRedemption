
package org.usfirst.frc.team1285.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1285.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1285.robot.subsystems.Indexer;
import org.usfirst.frc.team1285.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
//Subsystems
	public static final Drivetrain drive = new Drivetrain();
	public static final Intake intake = new Intake();
	public static final Indexer indexer = new Indexer();
	public static OI oi;

    Command autonomousCommand;
  /*public SendableChooser autoChooser;
    public SendableChooser defenceChooser;
    public SendableChooser locationChooser;
  
    public static int defenceLocation;
    public static int selectedDefence;
    public static int autoNumber;
    public static int defencePosition;
  */
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
/*
 * defenceChooser = new SendableChooser();
		locationChooser = new SendableChooser();
		
		defenceChooser.addDefault("Rock Wall", NumberConstants.ROCKWALL);
		defenceChooser.addDefault("Rough Terrain", NumberConstants.ROUGHTERRAIN);
		defenceChooser.addObject("Moat", NumberConstants.MOAT);
		defenceChooser.addObject("Ramparts", NumberConstants.RAMPARTS);
		defenceChooser.addObject("Portcullis", NumberConstants.PORTCULLIS);
		defenceChooser.addObject("Cheval de Frise", NumberConstants.CHEVAL);	
				
		locationChooser.addObject("2", 1);
		locationChooser.addDefault("3", 2);
		locationChooser.addObject("4", 3);
		locationChooser.addObject("5", 4);
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("No Auto", 0);
		autoChooser.addObject("SpyShot", 1);
		autoChooser.addObject("Breach", 2);
		autoChooser.addDefault("Breach&Shoot", 3);
		autoChooser.addObject("Two Ball", 4);
//		autoChooser.addObject("Backwards Rough Terrain", 5);
//		autoChooser.addObject("Backwards Rock Wall", 6);
//		autoChooser.addObject("Backwards Moat", 7);
		
		SmartDashboard.putData("Defence Mode", defenceChooser);
		SmartDashboard.putData("Location", locationChooser);
		SmartDashboard.putData("End Location", endLocationChooser);
		SmartDashboard.putData("Autonomous", autoChooser);
		
		updateSmartDashboard();
 */
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateSmartDashboard() ;
    }
    
    public void updateSmartDashboard() {
		SmartDashboard.putNumber("Right Drive Encoder", Math.round(drive.getRightEncoderDist()));
		SmartDashboard.putNumber("Left Drive Encoder", Math.round(drive.getLeftEncoderDist()));
	}

	/**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
