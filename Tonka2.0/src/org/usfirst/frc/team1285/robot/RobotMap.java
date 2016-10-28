package org.usfirst.frc.team1285.robot;

import edu.wpi.first.wpilibj.DigitalSource;

/**
	 * The RobotMap is a mapping from the ports sensors and actuators are wired into
	 * to a variable name. This provides flexibility changing wiring, makes checking
	 * the wiring easier and significantly reduces the number of magic numbers
	 * floating around.
	 */
	public class RobotMap {
		//**************************************************************************
		//*****************************DRIVE MOTORS*********************************
		//**************************************************************************        
		
		public static final int RIGHT_DRIVE_FRONT                               = 0; 
		public static final int RIGHT_DRIVE_BACK                                = 8;
		
		public static final int LEFT_DRIVE_FRONT                                = 11;
		public static final int LEFT_DRIVE_BACK                                 = 12;
		
		//**************************************************************************
		//************************** DRIVE ENCODERS ********************************
		//**************************************************************************
		
		public static final int LEFT_DRIVE_ENCODER_A                            = 1;
		public static final int LEFT_DRIVE_ENCODER_B                            = 2;
		
		public static final int RIGHT_DRIVE_ENCODER_A                           = 3;
		public static final int RIGHT_DRIVE_ENCODER_B                           = 8;
		
		//**************************************************************************
		//*************************** Digital Sensors ******************************
		//**************************************************************************
		  
		public static final int LIMIT_SWITCH 					 				= 4;
		public static final int OPTICAL_SENSOR 									= 5;
		
		//**************************************************************************
	    //********************* DRIVE ENCODER CONSTANTS ****************************
		//**************************************************************************
		
		public static final int driveWheelRadius = 3;//wheel radius in inches
		public static final int drivePulsePerRotation = 128; //encoder pulse per rotation
		public static final double driveGearRatio = 1/1; //ratio between wheel and encoder
		public static final double driveEncoderPulsePerRot = drivePulsePerRotation*driveGearRatio; //pulse per rotation * gear ratio
		public static final double driveEncoderDistPerTick =(Math.PI*2*driveWheelRadius)/driveEncoderPulsePerRot;
		public static final boolean rightDriveTrainEncoderReverse = false; 
		public static final boolean leftDriveTrainEncoderReverse = false; 
		
		//**************************************************************************
		//******************************* INTAKE MOTORS ****************************
		//**************************************************************************
		
		public static final int RIGHT_INTAKE_ROLLER					=9;
		public static final int LEFT_INTAKE_ROLLER					=10;
		public static final int RIGHT_INTAKE_ARM					=5;
		public static final int LEFT_INTAKE_ARM						=6;
		
		//**************************************************************************
		//*************************** INDEXER MOTORS *******************************
		//**************************************************************************
		
		public static final int LEFT_INDEXER_MOTOR					=1;
		public static final int RIGHT_INDEXER_MOTOR					=2;
		
		//**************************************************************************
		//*************************** SHOOTER MOTORS *******************************
		//**************************************************************************
		
		public static final int RIGHT_SHOOTER_MOTOR					=3;
		public static final int LEFT_SHOOTER_MOTOR					=4;
		public static final int TURRET_MOTOR						=7;
	}
