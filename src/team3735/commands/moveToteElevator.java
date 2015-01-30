package team3735.commands;

import team3735.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class moveToteElevator extends Command {

    public moveToteElevator() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.toteElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.toteElevator.move(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.toteElevator.move(Robot.oi.coDriverStick.getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.toteElevator.toteTopLimit.get() || Robot.toteElevator.toteBottomLimit.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.toteElevator.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.toteElevator.move(0);
    }
}
