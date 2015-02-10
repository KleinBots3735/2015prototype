package team3735.subsystems;

import team3735.RobotMap;
import team3735.commands.accDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static RobotDrive drive;
	public static Encoder leftDriveEncoder, rightDriveEncoder;
	public static boolean realSpeed;
	
	public Drivetrain() {
		leftDriveEncoder = new Encoder(RobotMap.driveLeftEncoderA,RobotMap.driveLeftEncoderB);
		rightDriveEncoder = new Encoder(RobotMap.driveRightEncoderA,RobotMap.driveRightEncoderB);
		drive = new RobotDrive(RobotMap.frontLeftMotor,RobotMap.rearLeftMotor,RobotMap.frontRightMotor,RobotMap.rearRightMotor);
		realSpeed = false;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new accDrive());
    	//setDefaultCommand(new driveWithJoy());
    }
    
    public double getLeftEncoder() {
    	return leftDriveEncoder.get();
    }
    public double getRightEncoder() {
    	return rightDriveEncoder.get();
    }
    
    public void move(double x, double y) {
    	double moveValue = x;
    	double rotateValue = y;
    	drive.arcadeDrive(moveValue, rotateValue);
    }
    
    
    
//    public void realSpeedTrue() {
//    	realSpeed = true;
//    }
    
//    public void realSpeedFalse() {
//    	realSpeed = false;
//    }
    
//    public boolean getRealSpeed() {
//    	return realSpeed;
//    }
}

