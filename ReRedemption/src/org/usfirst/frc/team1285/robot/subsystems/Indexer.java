package org.usfirst.frc.team1285.robot.subsystems;

import org.usfirst.frc.team1285.robot.RobotMap;
import org.usfirst.frc.team1285.robot.commands.IndexBoulder;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Indexer extends Subsystem {
    //Indexer Talons
   CANTalon rightIndexerMotor;
   CANTalon leftIndexerMotor;
   {
   rightIndexerMotor = new CANTalon(RobotMap.RIGHT_INDEXER_MOTOR);
   leftIndexerMotor = new CANTalon(RobotMap.LEFT_INDEXER_MOTOR);
   }
   
   public void lift() {
   	rightIndexerMotor.set(1);
   	leftIndexerMotor.set(1);
   }
   
   public void lower() {
	rightIndexerMotor.set(-1);
	leftIndexerMotor.set(-1);
   }
   
   public void indexerStop() {
	rightIndexerMotor.set(0);
	leftIndexerMotor.set(0);
   }
    public void initDefaultCommand() {
    	setDefaultCommand(new IndexBoulder());
       
   
    	}
	}

