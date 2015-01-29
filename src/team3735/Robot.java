
package team3735;

import team3735.subsystems.Drivetrain;
import team3735.subsystems.ToteElevator;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	RobotMap robotMap;
	public static ToteElevator toteElevator;
	public static Drivetrain drivetrain;
	RobotDrive drive;
	Joystick driverStick;
	Joystick coDriverStick;
	public static Talon toteMotor;
	Talon RCMotor;
	Talon intakeMotorLeft;
	Talon intakeMotorRight;
	//DigitalInput toteBottomLimit;
	//DigitalInput toteTopLimit;
	Compressor compressor;
	//Solenoid frontClaw;
	//Solenoid rearClaw;
	//Encoder elevatorEncoder;
	
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		//oi = new OI();
    	//myRobot = new RobotDrive(0,1,2,3);
    	// instantiate the command used for the autonomous period
    	driverStick = new Joystick(0);
    	coDriverStick = new Joystick(1);
    	drive = new RobotDrive(0,1,2,3);
    	
    	toteMotor = new Talon(4);
    	RCMotor = new Talon(5);
    	
    	intakeMotorLeft = new Talon(6);
    	intakeMotorRight = new Talon(7);
    	
    	 //toteBottomLimit = new DigitalInput(0);
    	 //toteTopLimit = new DigitalInput(1);
    	
    	//Pneumatic Air Compressor
    	 //compressor = new Compressor(0);
    		
    	//Solenoids
    	 //frontClaw = new Solenoid(0);
    	 //rearClaw = new Solenoid(1);
    	
    	//Encoder
    	//elevatorEncoder = new Encoder(1,0);
    	 //compressor.start();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        while(isEnabled()) {
        	drive.arcadeDrive(driverStick.getZ(), driverStick.getY());
        	toteMotor.set(coDriverStick.getY());
        	Timer.delay(0.01);
        }
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
