package org.usfirst.frc.team1285.robot.commands.auto;

import org.usfirst.frc.team1285.robot.commands.DriveForward;
import org.usfirst.frc.team1285.robot.commands.DriveTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** 
 * @author Neil Balaskandarajah
 * @since August 20th, 2016
 */
public class DriveTurnCourt2 extends CommandGroup {
    
    public  DriveTurnCourt2() {
/* 
 * Turn to face position
 * Drive to position
 * Turn to tower
 */    	
    	addSequential(new DriveTurn(5, 0.5, 0.5, 180));
    	addSequential(new DriveForward(8, 5, 0.75));
    	addSequential(new DriveTurn(5, 0.5, 0.5, 180));
    }
}
