package org.usfirst.frc.team1285.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveToTower extends CommandGroup {
    
    public  DriveToTower() {
       /*
        * Drive to defense
        * Drive over defense
        * Drive ahead a bit
        * Turn towards tower
        * Drive straight
        * Turn towards tower
        */
    	
    	addSequential(new DriveForward(10, 5, 0.5));
    	addSequential(new DriveForward(5, 5, 0.8));
    	addSequential(new DriveForward(5, 5, 0.25));
    	addSequential(new DriveTurn(5, 0.5, 0.5, 45));
    	addSequential(new DriveForward(8, 5, 0.75));
    	addSequential(new DriveTurn(5, 0.25, 0.25, -45));;
    }
}
