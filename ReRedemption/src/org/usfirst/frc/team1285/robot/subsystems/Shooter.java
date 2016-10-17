package org.usfirst.frc.team1285.robot.subsystems;

import org.usfirst.frc.team1285.robot.NumberConstants;
import org.usfirst.frc.team1285.robot.RobotMap;
import org.usfirst.frc.team1285.robot.utilities.PIDController;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	
	CANTalon rightShooterMotor;
	CANTalon leftShooterMotor;
	
	public PIDController shooterPID;
	
	Counter optical;
	
	public boolean shooterState = false;
	
	public void changeState(boolean state){
	shooterState = state;		
	}
	
	public Shooter(){
		
		optical = new Counter();
		//optical.setUpSource(RobotMap.OPTICAL_SENSOR);
		optical.setUpDownCounterMode();
		optical.setDistancePerPulse(1);
		
		rightShooterMotor = new CANTalon(RobotMap.RIGHT_SHOOTER_MOTOR);
		leftShooterMotor = new CANTalon(RobotMap.LEFT_SHOOTER_MOTOR);
		
		
		shooterPID = new PIDController(NumberConstants.pShooter,
				                       NumberConstants.iShooter,
				                       NumberConstants.dShooter);
	}
	
	
	public void setRPM (double rpm) {
		double output = shooterPID.calcPID(rpm, getRPM(), 50);
		setRightShooterMotorSpeed (output+NumberConstants.mValue*rpm+NumberConstants.bValue);
		setLeftShooterMotorSpeed(output+NumberConstants.mValue*rpm+NumberConstants.bValue);
	}
	
	public double getOptic(){
		return optical.get();
	}
	
	public double getRPM(){
		return optical.getRate()*60;
	}
	public void setRightShooterMotorSpeed (double power){
		rightShooterMotor.set(power);
		
	}
	public void setLeftShooterMotorSpeed (double power){
		leftShooterMotor.set(-power);
		
	}
	
	
	
	@Override
	protected void initDefaultCommand() {

	}

}
