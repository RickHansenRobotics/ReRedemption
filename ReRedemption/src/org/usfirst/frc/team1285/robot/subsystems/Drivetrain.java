package org.usfirst.frc.team1285.robot.subsystems;

import org.usfirst.frc.team1285.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1285.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team1285.robot.utilities.Nav6;
import edu.wpi.first.wpilibj.SerialPort;
import org.usfirst.frc.team1285.robot.NumberConstants;
import org.usfirst.frc.team1285.robot.utilities.PIDController;

/**
 *
 */
public class Drivetrain extends Subsystem {
  
	//Gyro Object
	SerialPort serial_port;
	Nav6 nav6;
	
	//Speed Controllers (Talons) Right
	CANTalon rightDriveFront;
	CANTalon rightDriveBack;
	
	//Speed Controllers (Talons) Left
	CANTalon leftDriveFront;
	CANTalon leftDriveBack;
	
	//Encoders
	Encoder leftDrive;
	Encoder rightDrive;
	
	//PID Controllers for Drive and Gyro
	public PIDController drivePID;
	
	public Drivetrain() {
		//SPEED CONTROLLERS
		//Right Speed Controllers
		rightDriveFront = new CANTalon(RobotMap.RIGHT_DRIVE_FRONT);
		rightDriveBack = new CANTalon(RobotMap.RIGHT_DRIVE_BACK);
		
		//Left Speed Controllers
		leftDriveFront = new CANTalon(RobotMap.LEFT_DRIVE_FRONT);
		leftDriveBack = new CANTalon(RobotMap.LEFT_DRIVE_BACK);
		
		//ENCODERS
		//Right Encoders
		rightDrive = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_A,
								 RobotMap.RIGHT_DRIVE_ENCODER_B,
								 RobotMap.rightDriveTrainEncoderReverse,
								 Encoder.EncodingType.k4X);
		
		rightDrive.setDistancePerPulse(RobotMap.driveEncoderDistPerTick);
		
		//Left Encoders
		leftDrive = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_A,
								RobotMap.LEFT_DRIVE_ENCODER_B,
								RobotMap.leftDriveTrainEncoderReverse,
								Encoder.EncodingType.k4X);
		
		leftDrive.setDistancePerPulse(RobotMap.driveEncoderDistPerTick);
				
		/*GYRO
		try {
			serial_port = new SerialPort(57600, SerialPort.Port.kOnboard) ;
			
			byte update_rate_hz = 50;
			nav6 = new Nav6(serial_port, update_rate_hz) ;
		}
			catch( Exception ex ) {
				
			}
			
			boolean is_calibrating = nav6.isCalibrating();
			if (!is_calibrating) {
				Timer.delay( 0.3 );
				nav6.zeroYaw();
				}
			
			
	}
/************************GYRO FUNCTIONS************************/
   /* 
    /**
     * This function is used to check if the gyro is connected
     * 
     * @return Returns true or false depending on the state of the gyro
     */
		/*
    public boolean gyroConnected(){
    	return nav6.isConnected();
    }
    
    /**
     * This function is used to check if the gyro is calibrating
     * 
     * @return Returns true or false depending on the state of the gyro
     */
		/*
    public boolean gyroCalibrating(){
    	return nav6.isCalibrating();
    }
    
    /**
     * This function returns the YAW reading from the gyro
     * 
     * @return Returns YAW
     */
		/*
    public double getYaw(){
    	return nav6.getYaw();
    }
    
    /**
     * This function returns the PITCH reading from the gyro
     * 
     * @return Returns PITCH
     */
		/*
    public double getPitch(){
    	return nav6.getPitch();
    }
    
    /**
     * This function returns the ROLL reading from the gyro
     * 
     * @return Returns ROLL
     */
		/*
    public double getRoll(){
    	return nav6.getRoll();
    }
    
    /**
     * This function returns the heading from the gyro
     * 
     * @return Returns compass heading
     */
		/*
    public double getCompassHeading(){
    	return nav6.getCompassHeading();
    }
    
    /**
     * Resets the gyro back to zero
     */
		/*
    public void resetGyro(){
    	nav6.zeroYaw();
    	*/
/**************************************************************/
    	//PID
		drivePID = new PIDController(NumberConstants.pDrive,
									 NumberConstants.iDrive,
									 NumberConstants.dDrive);
		}
    
    //PID
    // Average Distance Method
	public double getAverageDistance() {
		return (getRightEncoderDist() + getLeftEncoderDist()) /2;
	}
    
	// Drive Straight Method
	public void driveStraight (double setpoint, double speed, double epsilon)
	{
		double output = drivePID.calcPID(setpoint, getAverageDistance(), 1);
		
		runRightDrive(-output*speed);
		runLeftDrive(output*speed);	
	
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
    	public void runRightDrive (double pwmVal)
    	{
    		rightDriveFront.set(pwmVal);
		    rightDriveBack.set(pwmVal);
    	}
    	    	
    	public double getRightEncoderDist(){
    		return rightDrive.getDistance();
    	}
    		
    	public double getLeftEncoderDist(){
			return leftDrive.getDistance();
    	}    
    	
    	public void runLeftDrive (double pwmVal)
		    {
    		leftDriveFront.set(pwmVal);
    		leftDriveBack.set(pwmVal);
    }

		public void resetEncoders() {
			// TODO Auto-generated method stub
			
		}

		public void driveTurn(double timeOut, double leftSpeed, double rightSpeed, double angle) {
			// TODO Auto-generated method stub
			
		}
}

