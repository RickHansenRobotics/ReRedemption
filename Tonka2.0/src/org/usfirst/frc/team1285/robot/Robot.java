
package org.usfirst.frc.team1285.robot;

import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1285.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1285.robot.subsystems.Indexer;
import org.usfirst.frc.team1285.robot.subsystems.Intake;
import org.usfirst.frc.team1285.robot.subsystems.Shooter;
import org.usfirst.frc.team1285.robot.subsystems.Turret;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	
//Subsystems
	public static final Drivetrain drive = new Drivetrain();
	public static final Intake intake = new Intake();
	public static final Indexer indexer = new Indexer();
	public static final Shooter shooter = new Shooter();
	public static final Turret turret = new Turret();
	public static OI oi;
	
// USB Camera
	CameraServer server;
	
	public SendableChooser autoChooser;
	
	/*
    Command autonomousCommand = new DriveForward(0, 16, 1);
    
    public SendableChooser defenceChooser;
    public SendableChooser locationChooser;
  
    public static int defenceLocation;
    public static int selectedDefence;
    public static int autoNumber;
    public static int defencePosition;
    */
	
    {server = CameraServer.getInstance();
	server.setQuality(25);
	// the camera name (ex "cam0") can be found through the roborio web
	// interface
	
	server.startAutomaticCapture("cam0");
    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
		/*
		defenceChooser = new SendableChooser();
		locationChooser = new SendableChooser();
		
		defenceChooser.addDefault("Rock Wall", NumberConstants.ROCKWALL);
		defenceChooser.addDefault("Rough Terrain", NumberConstants.ROUGHTERRAIN);
		defenceChooser.addObject("Moat", NumberConstants.MOAT);
		defenceChooser.addObject("Ramparts", NumberConstants.RAMPARTS);
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
		autoChooser.addObject("Backwards Rough Terrain", 5);
		autoChooser.addObject("Backwards Rock Wall", 6);
		autoChooser.addObject("Backwards Moat", 7);
		
		SmartDashboard.putData("Defence Mode", defenceChooser);
		SmartDashboard.putData("Location", locationChooser);
		SmartDashboard.putData("Autonomous", autoChooser);
		
		SmartDashboard.putData("AUTONOMOUS", null);
	*/
		updateSmartDashboard(); 
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		updateSmartDashboard();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
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
        updateSmartDashboard();
    }
    
    public void updateSmartDashboard() {
		SmartDashboard.putNumber("Right Drive Encoder", Math.round(drive.getRightEncoderDist()));
		SmartDashboard.putNumber("Left Drive Encoder", Math.round(drive.getLeftEncoderDist()));
		SmartDashboard.putNumber("Turret Encoder", turret.turretEncoderGet());
		SmartDashboard.putNumber("Shooter RPM", shooter.getRPM());
		SmartDashboard.putBoolean("Limit Switch", indexer.getLimitSwitch());
		SmartDashboard.putNumber("Turret Setpoint", turret.getSetpoint());
		SmartDashboard.putNumber("Turret P", turret.getPGain());
	}

	/**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
