package team3735;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	//Joystick Controllers
	public static Joystick driverStick = new Joystick(0);
	public static Joystick coDriverStick = new Joystick(1);
	
	//Motor Controllers
	public static Talon frontLeftMotor = new Talon(0);
	public static Talon frontRightMotor = new Talon(1);
	public static Talon rearLeftMotor = new Talon(2);
	public static Talon rearRightMotor = new Talon(3);
	
	public static RobotDrive drive = new RobotDrive(0,1,2,3);
	
	public static Talon toteMotor = new Talon(4);
	public static Talon RCMotor = new Talon(5);
	
	public static Talon intakeMotorleft = new Talon(6);
	public static Talon intakeMotorRight = new Talon(7);
	
	public static DigitalInput toteBottomLimit = new DigitalInput(0);
	public static DigitalInput toteTopLimit = new DigitalInput(1);
	
	//Pneumatic Air Compressor
	public static Compressor compressor = new Compressor(0);
		
	//Solenoids
	public static Solenoid frontClaw = new Solenoid(0);
	public static Solenoid rearClaw = new Solenoid(1);
	
	//Encoder
	public static Encoder elevatorEncoder = new Encoder(1,0);
}
