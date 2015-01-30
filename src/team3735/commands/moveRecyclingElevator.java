package team3735.commands;

import team3735.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class moveRecyclingElevator extends Command {

    public moveRecyclingElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.rcElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.toteElevator.move(Robot.oi.coDriverStick.getZ());
    	Robot.rcElevator.move(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        		//Robot.rcElevator.toteTopLimit.get() || Robot.rcElevator.toteBottomLimit.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.toteElevator.move(0);
    }
}