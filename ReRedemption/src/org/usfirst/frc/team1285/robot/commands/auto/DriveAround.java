package org.usfirst.frc.team1285.robot.commands.auto;

import org.usfirst.frc.team1285.robot.commands.DriveForward;
import org.usfirst.frc.team1285.robot.commands.DriveTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** 
 * @author Neil Balaskandarajah
 * @since August 20th, 2016
 */
public class DriveAround extends CommandGroup {
    
    public  DriveAround() {
/* Drive to defense
 * Drive over defense
 * Drive ahead thru courtyard
 * Turn 180
 * Drive over defense
 */    	
    	addSequential(new DriveForward(10, 5, 0.5));
    	addSequential(new DriveForward(5, 5, 0.8));
    	addSequential(new DriveForward(5, 5, 0.25));
    	addSequential(new DriveTurn(5, 0.5, 0.5, 180));
    	addSequential(new DriveForward(8, 5, 0.75));
    }
}
