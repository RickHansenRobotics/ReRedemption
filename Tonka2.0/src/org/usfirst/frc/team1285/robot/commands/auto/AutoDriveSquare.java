package org.usfirst.frc.team1285.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveSquare extends CommandGroup {
    
    public  AutoDriveSquare() {

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveForward(10, 5, 0.5));
    	addSequential(new DriveTurn(5, 0.5, -0.5, 90));
    	
    	addSequential(new DriveForward(10, 5, 0.5));
    	addSequential(new DriveTurn(5, 0.5, -0.5, 90));
    	
    	addSequential(new DriveForward(10, 5, 0.5));
    	addSequential(new DriveTurn(5, 0.5, -0.5, 90));
    	
    	addSequential(new DriveForward(10, 5, 0.5));
    	addSequential(new DriveTurn(5, 0.5, -0.5, 90));
    }
}
