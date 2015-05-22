package team3735.subsystems;

import team3735.RobotMap;
import team3735.commands.accDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	public static RobotDrive drive;
	public static Encoder leftDriveEncoder, rightDriveEncoder;
	
	public Drivetrain() {
		leftDriveEncoder = new Encoder(RobotMap.driveLeftEncoderA,RobotMap.driveLeftEncoderB);
		rightDriveEncoder = new Encoder(RobotMap.driveRightEncoderA,RobotMap.driveRightEncoderB);
		drive = new RobotDrive(RobotMap.leftDrive,RobotMap.rightDrive);
	}
    public void initDefaultCommand() {
        //setDefaultCommand(new team3735.commands.tankDrive());
    	setDefaultCommand(new accDrive());
    	//setDefaultCommand(new driveWithJoy());
    }
    
    public double getLeftCount() {
    	return leftDriveEncoder.get();
    }
    public double getLeftSpeed() {
    	return leftDriveEncoder.getRate();
    } 
    public double getRightCount() {
    	return -rightDriveEncoder.get();
    }
    public double getRightSpeed() {
    	return rightDriveEncoder.getRate();
    }
    
    public void move(double x, double y) {
    	double moveValue = x;
    	double rotateValue = y;
    	drive.arcadeDrive(moveValue, rotateValue);
    	
//    	System.out.println("Left: " + l);
//    	System.out.println("Right: " + r);
    }
    
    public void tankDrive(double x, double y) {
    	double master = x;
    	double slave = y;
    	System.out.println("X: " + x + " Y: " + y);
    	System.out.println("Left: " + getLeftCount() + " Right: " + getRightCount());
	    if(x > 0 && y > 0){
	    	master = x*.8; //left side
	    	slave = y*.8; //right side
	    	double diff = getLeftCount()-getRightCount();
	    	
    		if(diff > 0){//right side is slower
	    		slave*=1.1;
	    	}
	    	else if(diff < 0){//left side is slower
	    		slave*=.9;
	    	}
    	}
    	drive.tankDrive(master, slave);
    }
}
