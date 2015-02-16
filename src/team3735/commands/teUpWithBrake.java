package team3735.commands;

import team3735.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class teUpWithBrake extends Command {

    public teUpWithBrake() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.toteElevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.toteElevator.brakeOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.toteElevator.moveUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	try {
			wait(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.toteElevator.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
