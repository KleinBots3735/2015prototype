package team3735.commands;

import team3735.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class rceDown extends Command {

    public rceDown() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.rcElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.rcElevator.moveDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rcElevator.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.rcElevator.move(0);
    }
}
