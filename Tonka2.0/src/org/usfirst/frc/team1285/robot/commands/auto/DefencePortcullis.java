package org.usfirst.frc.team1285.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Neil Balaskandarajah
 *@sicne August 21st, 2016
 */
public class DefencePortcullis extends CommandGroup {
    /* 
     * need to find distance for drive
     * insert arm before (parallel or sequential?)
     * if parallel, very slow drive with moderate arm
     * if sequential, moderate-slow arm with fast drive
     */
    public  DefencePortcullis() {
        addSequential(new DriveForward(5,3, 0.3));
    }
}
