package team3735.commands;

import team3735.Robot;
import team3735.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveWithJoy extends Command {

    public driveWithJoy() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.move(RobotMap.driverStick.getX(), RobotMap.driverStick.getY());
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
