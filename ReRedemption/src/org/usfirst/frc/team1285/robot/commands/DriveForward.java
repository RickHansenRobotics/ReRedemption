package org.usfirst.frc.team1285.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1285.robot.Robot;

/**
 *
 */
public class DriveForward extends Command {
	
	private double distance;
	private double timeOut;
	private double speed;
	private double epsilon;
	
	 public DriveForward(double distance, double timeOut, double speed) {
		 this(distance, speed, timeOut, 1);
	 }
	
    public DriveForward(double distance, double timeOut, double speed, double epsilon) {
    	this.distance = distance;
    	this.timeOut = timeOut;
    	this.speed = speed;
    	this.epsilon = epsilon;
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeOut);
    	
    	Robot.drive.resetEncoders() ;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveStraight(distance, speed, epsilon);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut()  ||  Robot.drive.drivePID.isDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.runRightDrive(0);
    	Robot.drive.runLeftDrive(0);
    	Robot.drive.drivePID.resetPID();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
