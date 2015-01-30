package team3735.commands;

import team3735.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class intake extends Command {

    public intake() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.toteElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.toteElevator.motorIntake();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.toteElevator.toteStatus.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.toteElevator.stopIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.toteElevator.stopIntake();
    }
}