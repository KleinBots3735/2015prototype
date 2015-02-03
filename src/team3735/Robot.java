package team3735;

import team3735.commands.driveWithJoy;
import team3735.commands.intake;
import team3735.commands.moveRecyclingElevator;
import team3735.commands.moveToteElevator;
import team3735.subsystems.Drivetrain;
import team3735.subsystems.Intake;
import team3735.subsystems.RecyclingCan;
import team3735.subsystems.ToteElevator;
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
	
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		toteElevator = new ToteElevator();
		drivetrain = new Drivetrain();
		rcElevator = new RecyclingCan();
		oi = new OI();
		
		SmartDashboard.putData(drivetrain);
		SmartDashboard.putData(toteElevator);
		SmartDashboard.putData(rcElevator);
		
		SmartDashboard.putData("DriveWithJoy", new driveWithJoy());
		SmartDashboard.putData("Intake", new intake());
		SmartDashboard.putData("Move Recycling Elevator", new moveRecyclingElevator());
		SmartDashboard.putData("Move Tote Elevator", new moveToteElevator());
		
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

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
