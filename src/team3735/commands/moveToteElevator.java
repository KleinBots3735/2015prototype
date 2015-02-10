package team3735.commands;

import team3735.Robot;
import team3735.subsystems.ToteElevator;
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
    	ToteElevator.toteEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double Y = Robot.oi.coDriverStick.getY();
    	Robot.toteElevator.move(-Y);
//    	if(!Robot.toteElevator.getBottomLimit() && (Y > 0)) {
//    		Robot.toteElevator.move(Y);
//    	}
//    	else if(!Robot.toteElevator.getTopLimit() && (Y < 0)) {
//    		Robot.toteElevator.move(Y);
//    	}
//    	
    	//System.out.println("Encoder: " + ToteElevator.toteEncoder.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	if(ToteElevator.moveValue>0) {
//    		return Robot.toteElevator.getTopLimit();
//    	}
//    	else if(ToteElevator.moveValue<0) {
//        	return Robot.toteElevator.getBottomLimit();
//    	}
//    	else return false;
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.toteElevator.move(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
