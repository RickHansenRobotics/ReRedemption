package org.usfirst.frc.team1285.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Neil Balaskandarajah
 * @since August 21st 2016
 */
public class DefenceRockWall extends CommandGroup {
    
    public  DefenceRockWall() {
       /*DTS
        * Need to find values for distance
        */
    	addSequential(new DriveForward(10, 5, 0.8));
    }
}
