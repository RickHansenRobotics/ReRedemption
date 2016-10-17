package org.usfirst.frc.team1285.robot.commands.auto;

import org.usfirst.frc.team1285.robot.commands.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Neil Balaskandarajah
 *@since August 21st 2016
 */
public class DefenceRoughTerrain extends CommandGroup {
	/*DTS
	 * need to find distance 
	 */
    public  DefenceRoughTerrain() {
      addSequential(new DriveForward(8, 5, 0.75));
    }
}
