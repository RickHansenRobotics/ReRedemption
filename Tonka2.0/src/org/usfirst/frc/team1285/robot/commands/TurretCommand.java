package org.usfirst.frc.team1285.robot.commands;

import org.usfirst.frc.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurretCommand extends Command {

	// private commands for different angles
	private TurnTurret straightAngle;
	private TurnTurret leftAngle;
	private TurnTurret rightAngle;

	public TurretCommand() {
		requires(Robot.turret);
		straightAngle = new TurnTurret(0, 1, 3);
		leftAngle = new TurnTurret(90, 1, 3);
		rightAngle = new TurnTurret(-90, 1, 3);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.turret.encoderConnected) {
			if (Robot.oi.getToolLeftX() > 0.9) {
				// cancelTurret();
				// rightAngle.start();
				Robot.turret.setTarget(-71);
			} else if (Robot.oi.getToolLeftX() < -0.9) {
				// cancelTurret();
				// leftAngle.start();
				Robot.turret.setTarget(71);
			} else if (Robot.oi.getToolLeftY() < -0.9) {
				// cancelTurret();
				// straightAngle.start();
				Robot.turret.setTarget(0);
			}
		}
	}

	public void cancelTurret() {
		rightAngle.cancel();
		leftAngle.cancel();
		straightAngle.cancel();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
