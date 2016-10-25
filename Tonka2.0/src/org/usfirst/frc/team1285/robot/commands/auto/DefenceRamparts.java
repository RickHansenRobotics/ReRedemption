package org.usfirst.frc.team1285.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Neil Balaskandarajah
 *@since August 21st, 2016
 */
public class DefenceRamparts extends CommandGroup {
  /*DTS
   * need to find distance  
   */
    public  DefenceRamparts() {
       addSequential(new DriveForward(9, 5, 0.8));
    }
}
