package team3735;


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
	public static int driverStick = 0;
	public static int coDriverStick = 1;
	
	//Motor Controllers
	public static int frontLeftMotor = 0;
	public static int frontRightMotor = 1;
	public static int rearLeftMotor = 2;
	public static int rearRightMotor = 3;
	
	public static int toteMotor = 6;
	public static int RCMotor = 7;
	
	public static int intakeMotorleft = 4;
	public static int intakeMotorRight = 5;
	
	//Pneumatic Air Compressor
	public static int compressor = 0;
		
	//Solenoids
	public static int intake = 0;
	public static int rcClaw = 1;
	public static int toteBrake = 2;
	public static int rcBrake = 3;
	
	//Encoder
	public static int toteBottomLimit = 0;
	public static int toteTopLimit = 1;
	public static int rcBottomLimit = 2;
	public static int rcTopLimit = 3;
	public static int toteElevatorEncoderA = 4;
	public static int toteElevatorEncoderB = 5;
	public static int rcElevatorEncoderA = 6;
	public static int rcElevatorEncoderB = 7;
}
