package team3735.subsystems;

import team3735.Robot;
import team3735.RobotMap;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
    
	public static double cameraY; //up and down
	public static double cameraX; //side to side
	public static Servo servoX;
	public static Servo servoY;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Vision() {
		servoX = new Servo(RobotMap.servoX);
		servoY= new Servo(RobotMap.servoY);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new team3735.commands.moveCamera());
    }
    
    public void moveCamera() {
    	cameraX += Robot.oi.coDriverStick.getZ();
    	cameraY += Robot.oi.coDriverStick.getY();
    	servoX.setAngle(cameraX);
    	servoX.setAngle(cameraY);    	
    }
}

