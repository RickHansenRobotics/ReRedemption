package org.usfirst.frc.team1285.robot.commands;

import org.usfirst.frc.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RevShooter extends Command {
	
	public double rpm;
	
	public void changeRPM(double rpm){		
		this.rpm = rpm;		
	}

    public RevShooter(double rpm) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.rpm = rpm;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.shooterState = true;
    }

    
    protected void execute() {   	
    	Robot.shooter.setRPM(rpm);    	
    }

    // .Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.shooter.shooterState;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.setLeftShooterMotorSpeed(0);
    	Robot.shooter.setRightShooterMotorSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.setLeftShooterMotorSpeed(0);
    	Robot.shooter.setRightShooterMotorSpeed(0);
    }
}
