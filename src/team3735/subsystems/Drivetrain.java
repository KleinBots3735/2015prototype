package team3735.subsystems;

import team3735.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void move(double x, double y)
    {
    	double moveValue = x;
    	double rotateValue = y;
    	RobotMap.drive.arcadeDrive(moveValue, rotateValue);
    }
    
    
}

