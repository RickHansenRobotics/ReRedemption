package org.usfirst.frc.team1285.robot.subsystems;

import org.usfirst.frc.team1285.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
		//Rollers
	CANTalon rightIntakeRoller;
	CANTalon leftIntakeRoller;
	
		//Arms
	CANTalon rightIntakeArm;
	CANTalon leftIntakeArm;	
	{
	
		//SPEED CONTROLLERS
		//ROLLERS
	rightIntakeRoller = new CANTalon(RobotMap.RIGHT_INTAKE_ROLLER) ;
	leftIntakeRoller = new CANTalon(RobotMap.LEFT_INTAKE_ROLLER) ;
	
		//ARMS
	rightIntakeArm = new CANTalon(RobotMap.RIGHT_INTAKE_ARM) ;
	leftIntakeArm = new CANTalon(RobotMap.LEFT_INTAKE_ARM) ;
	
	}
	
	public void intake()  {
		rightIntakeRoller.set(1);
		leftIntakeRoller.set(-1);
	}
	public void outtake()  {
		rightIntakeRoller.set(-1);
		leftIntakeRoller.set(1);
	}
	public void intakeStop()  {
		rightIntakeRoller.set(0);
		leftIntakeRoller.set(0);
	}
	
	

	@Override
	protected void initDefaultCommand() {
	}
		/*public void runIntakeRollers (double pwmVal)
    	{
    		rightIntakeRoller.set(pwmVal);
		    leftIntakeRoller.set(pwmVal);
    	}
		
		public void runIntakeArms (double pwmVal)
		{
			rightIntakeArm.set(pwmVal);
			leftIntakeArm.set(pwmVal);
			*/
	
		

		public void runIntakeArms(double toolRightY) {
			
		}
		
}
