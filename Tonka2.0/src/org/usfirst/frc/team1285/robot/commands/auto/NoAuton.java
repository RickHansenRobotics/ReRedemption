package org.usfirst.frc.team1285.robot.commands.auto;

import org.usfirst.frc.team1285.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
*
*/
public class NoAuton extends Command {

   public NoAuton() {
       this.requires(Robot.drive);
   }

   protected void initialize() {
   }

   protected void execute() {
   	Robot.drive.runLeftDrive(0);
   	Robot.drive.runRightDrive(0);
   }

   protected boolean isFinished() {
       return false;
   }

   protected void end() {
   }

   protected void interrupted() {
   }
}