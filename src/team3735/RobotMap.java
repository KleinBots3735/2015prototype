package team3735;



/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
//128 = One full revolution on encoder, ~~ 6 inches wheel circumference
public class RobotMap {
	//Joystick Controllers
	public static int driverStick = 0;
	public static int coDriverStick = 1;

	//Analog 
	public static int gyro = 0;
	
	//Digital
		//Limit Switches
		public static int toteStatus = 0;
		public static int toteTopLimit = 1;
		public static int toteBottomLimit = 2;
		public static int rcTopLimit = 3;
		public static int rcBottomLimit = 4;
		//Encoders
		public static int toteEncoderA = 5;
		public static int toteEncoderB = 6;
		public static int driveRightEncoderA = 7;
		public static int driveRightEncoderB = 8;
		public static int driveLeftEncoderA = 9;
		public static int driveLeftEncoderB = 10;
//		public static int rcEncoderA = 11;
//		public static int rcEncoderB = 12;
	
	//Motor Controllers
//	public static int frontLeftMotor = 0;
//	public static int frontRightMotor = 1;
//	public static int rearLeftMotor = 2;
//	public static int rearRightMotor = 3;
	public static int leftDrive = 0;
	public static int rightDrive = 1;
	public static int intakeMotorleft = 4;
	public static int intakeMotorRight = 5;
	public static int toteMotor = 6;
	public static int rcMotor = 7;
	
	public static int servoX = 8;
	public static int servoY = 9;
	
		
	//Solenoids
	public static int intakeSolenoid = 0;
	public static int toteBrake = 1;
	public static int rcClaw = 2;
	
	//Pneumatic Air Compressor
	public static int compressor = 0;
	
	//I2C
	public static int arduino = 2;
	
}
