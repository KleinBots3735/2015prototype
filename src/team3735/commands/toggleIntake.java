package team3735.commands;

import team3735.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class toggleIntake extends Command {
	
	public static boolean isOpen;
	
    public toggleIntake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	isOpen = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Command run");
    	if(isOpen) {
    		Robot.intake.closeIntake();
    		isOpen = false;
    	}
    	else if(!isOpen) {
    		Robot.intake.openIntake();
    		isOpen = true;
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
