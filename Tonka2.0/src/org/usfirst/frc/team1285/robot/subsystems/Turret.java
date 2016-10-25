package org.usfirst.frc.team1285.robot.subsystems;

import org.usfirst.frc.team1285.robot.NumberConstants;
import org.usfirst.frc.team1285.robot.RobotMap;
import org.usfirst.frc.team1285.robot.commands.TurretCommand;
import org.usfirst.frc.team1285.robot.utilities.PIDController;

import edu.wpi.first.wpilibj.CANSpeedController;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDeviceStatus;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Turret extends Subsystem {
    
	CANTalon turretMotor;
	
	public PIDController turretPID;
	
	public boolean encoderConnected = false;
	
	
	public Turret() {
		
		turretMotor = new CANTalon(RobotMap.TURRET_MOTOR);
		turretMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		turretMotor.configEncoderCodesPerRev(1024);
		turretMotor.reverseSensor(false);
		
		FeedbackDeviceStatus status = turretMotor.isSensorPresent(FeedbackDevice.CtreMagEncoder_Relative);
		
		turretMotor.setProfile(0);
		turretMotor.setPID(0.3, 0, 0);
		turretMotor.changeControlMode(CANTalon.TalonControlMode.Position);

		//turretMotor.changeControlMode(CANTalon.TalonControlMode.Voltage);
		
		switch(status){
		case FeedbackStatusPresent:
			System.out.println("ENCODER FOUND");
			encoderConnected = true;
			break;
		case FeedbackStatusNotPresent:
			System.out.println("ENCODER NOT FOUND");
			break;
		case FeedbackStatusUnknown:
			System.out.println("ENCODER NOT FOUND");
			break;
		}
		
		resetEncoder();
		
		
		turretPID = new PIDController(NumberConstants.pTurret,
									  NumberConstants.iTurret,
									  NumberConstants.dTurret);
	}

	public double turretEncoderGet(){
		return turretMotor.getPosition()*360/15.428571;
	}
	
	public void resetEncoder(){
		turretMotor.setPosition(0);
	}
	
	public void turnTurret(double input) {
		turretMotor.set(input);
	} 
	
	public void turretSet(double angle, double speed) {
		double output = turretPID.calcPID(angle, turretEncoderGet(), 0.5);
		turnTurret (output*speed);
	}
	
	public void setTarget(double angle){
		angle = angle*15.428571/360;
		turretMotor.set(angle);
	}
	
	public void disableTurret(){
		turretMotor.disableControl();
	}
	
	public double getSetpoint(){
		return turretMotor.getSetpoint()*360/15.428571;
	}
	
	public double getPGain(){
		return turretMotor.getP();
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new TurretCommand());
    }
}

