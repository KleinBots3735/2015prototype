package team3735.subsystems;

import team3735.RobotMap;
import team3735.commands.driveWithJoy;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static RobotDrive drive;
	
	public Drivetrain(){
		drive = new RobotDrive(RobotMap.frontLeftMotor,RobotMap.rearLeftMotor,RobotMap.frontRightMotor,RobotMap.rearRightMotor);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new driveWithJoy());
    }
    public void move(double x, double y){
    	double moveValue = x;
    	double rotateValue = y;
    	drive.arcadeDrive(moveValue, rotateValue);
    }    
}

