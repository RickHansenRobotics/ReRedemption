package org.usfirst.frc.team1285.robot.commands.auto;

import org.usfirst.frc.team1285.robot.commands.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Neil Balaskandarajah
 @since August 21st, 2016
 */
public class DefenceCheval extends CommandGroup {
    /*
     * find distance for drive
     * add arm sequence (sequential)
     * arm down slowly, drive moderate-fast
     */
    public  DefenceCheval() {
        addSequential(new DriveForward(5, 5, 0.6));
    }
}
