package team3735;

import team3735.commands.driveWithJoy;
import team3735.commands.intake;
import team3735.commands.rceUp;
import team3735.subsystems.Drivetrain;
import team3735.subsystems.Intake;
import team3735.subsystems.RecyclingCan;
import team3735.subsystems.ToteElevator;
import team3735.subsystems.Vision;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static ToteElevator toteElevator;
	public static Intake intake;
	public static Drivetrain drivetrain;
	public static RecyclingCan rcElevator;
	public static Vision vision;
	
	public static I2C arduino;
	
	public static boolean trueSpeed;

	public static boolean isTrueSpeed() {
		return trueSpeed;
	}

	public static void setTrueSpeed(boolean trueSpeed) {
		Robot.trueSpeed = trueSpeed;
	}
	
	Command autonomousCommand;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		toteElevator = new ToteElevator();
		drivetrain = new Drivetrain();
		rcElevator = new RecyclingCan();
		intake = new Intake();
		vision = new Vision();
		oi = new OI();
		trueSpeed = false;
		
		arduino = new I2C(I2C.Port.kOnboard,0);
		
		SmartDashboard.putData(drivetrain);
		SmartDashboard.putData(toteElevator);
		SmartDashboard.putData(rcElevator);
		
		SmartDashboard.putData("DriveWithJoy", new driveWithJoy());
		SmartDashboard.putData("Intake", new intake());
		SmartDashboard.putData("Move Recycling Elevator", new rceUp());
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        arduino.write(2, 1);
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
        arduino.write(2, 2);
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
        SmartDashboard.putNumber("Encoder", Robot.toteElevator.getEncoderRate());
        System.out.println(Robot.toteElevator.getEncoderCount());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
