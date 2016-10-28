package org.usfirst.frc.team1285.robot.commands;

import org.usfirst.frc.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeRollersArm extends Command {

    public IntakeRollersArm() {
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.runIntakeArms(Robot.oi.getToolRightY());
    	
    	if(Robot.oi.getToolRightBumper()) {
    		Robot.intake.intake();
    	} else if (Robot.oi.getToolLeftBumper()) {
    		Robot.intake.outtake();
    	} else if (Robot.oi.getToolBButton()) {
    		Robot.intake.halfIntake();
    	} else {
    		Robot.intake.intakeStop();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}