package org.usfirst.frc.team1285.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1285.robot.Robot;

/**
 *
 */
public class DriveTurn extends Command {
	
	private double timeOut;
	private double leftSpeed;
	private double rightSpeed;
	private double angle;	
	
    public DriveTurn(double timeOut, double leftSpeed, double rightSpeed, double angle) {
    	this.timeOut = timeOut;
    	this.leftSpeed = leftSpeed;
    	this.rightSpeed = rightSpeed;
    	this.angle = angle;
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeOut);
    	
    	Robot.drive.resetEncoders() ;
    	//Robot.drive.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.runRightDrive(leftSpeed);
    	Robot.drive.runLeftDrive(rightSpeed);
    	Robot.drive.driveTurn(timeOut, leftSpeed, rightSpeed, angle);
    	
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
