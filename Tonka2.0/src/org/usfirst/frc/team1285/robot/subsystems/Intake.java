package org.usfirst.frc.team1285.robot.subsystems;

import org.usfirst.frc.team1285.robot.RobotMap;
import org.usfirst.frc.team1285.robot.commands.IntakeRollersArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	// Rollers
	CANTalon rightIntakeRoller;
	CANTalon leftIntakeRoller;

	// Arms
	CANTalon rightIntakeArm;
	CANTalon leftIntakeArm;

	{

		// SPEED CONTROLLERS
		// ROLLERS
		rightIntakeRoller = new CANTalon(RobotMap.RIGHT_INTAKE_ROLLER);
		leftIntakeRoller = new CANTalon(RobotMap.LEFT_INTAKE_ROLLER);

		// ARMS
		rightIntakeArm = new CANTalon(RobotMap.RIGHT_INTAKE_ARM);
		leftIntakeArm = new CANTalon(RobotMap.LEFT_INTAKE_ARM);

	}

	public void intake() {
		rightIntakeRoller.set(1);
		leftIntakeRoller.set(-1);
	}

	public void outtake() {
		rightIntakeRoller.set(-1);
		leftIntakeRoller.set(1);
	}

	public void intakeStop() {
		rightIntakeRoller.set(0);
		leftIntakeRoller.set(0);
	}
	
	public void halfIntake() {
		rightIntakeRoller.set(0.5);
		leftIntakeRoller.set(-0.5);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new IntakeRollersArm());
	}

	public void runIntakeArms(double input) {
		rightIntakeArm.set(input);
		leftIntakeArm.set(-input);
	}

}
