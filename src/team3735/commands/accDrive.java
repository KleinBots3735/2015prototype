package team3735.commands;

import team3735.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class accDrive extends Command {

    public accDrive() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double y = -Robot.oi.driverStick.getY();
    	double z = -Robot.oi.driverStick.getZ();
    	if(Robot.drivetrain.getRealSpeed()) {
    		double ACF = 0.25;
	    	
		    	if(Math.abs(y) < 0.25) {
		    		ACF = 0.25;
		    	}
		    	else if(Math.abs(y) >= 0.25 && Math.abs(y) < 0.75) {
		    		ACF = 0.5;
		    	}
		    	else if(Math.abs(y) >= 0.75) {
		    		ACF = 0.75;
		    	}
	    	
	    	Robot.drivetrain.move(y*ACF, z*0.75);
    	}
    	else {
    		Robot.drivetrain.move(y, z);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
