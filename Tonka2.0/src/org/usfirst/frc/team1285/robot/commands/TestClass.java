package org.usfirst.frc.team1285.robot.commands;

import org.usfirst.frc.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestClass extends Command {

	private double angle;
	private double timeout;
	
    public TestClass(double angle, double timeout) {
        requires(Robot.turret);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.turret.setTarget(angle);
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut() || Math.abs(Robot.turret.turretEncoderGet()-angle) < 1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.turret.disableTurret();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.turret.disableTurret();
    }
}
