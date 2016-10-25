package org.usfirst.frc.team1285.robot.commands;

import org.usfirst.frc.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnTurret extends Command {
	
	private double angle;
	private double speed;
	private double timeOut;

    public TurnTurret(double angle, double speed, double timeOut) {
        this.angle = angle;
        this.speed = speed;
        this.timeOut = timeOut;
    	requires(Robot.turret);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeOut);
    	Robot.turret.turretPID.resetPID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.turret.turretSet(angle, speed);
    }
    
    public void changeAngle(double angle) {
		this.angle = angle;
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.turret.turretPID.isDone() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.turret.turretPID.resetPID();
    	Robot.turret.turnTurret(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.turret.turretPID.resetPID();
    	Robot.turret.turnTurret(0);
    }
}
