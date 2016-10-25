package org.usfirst.frc.team1285.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Neil Balaskandarajah
 *@since August 21st 2016
 */
public class DriveDefence extends CommandGroup {
	/*DTS
	 * need to find distance (very little)
	 */
    public  DriveDefence() {
      addSequential(new DriveForward(2, 5, 0.5));
    }
}
