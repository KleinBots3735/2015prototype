package team3735;

import team3735.commands.accSpeed;
import team3735.commands.closeIntake;
import team3735.commands.intakeNoLimit;
import team3735.commands.openIntake;
import team3735.commands.releaseTote;
import team3735.commands.toggleIntake;
import team3735.commands.trueSpeed;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public Joystick driverStick = new Joystick(RobotMap.driverStick);
	public Joystick coDriverStick = new Joystick(RobotMap.coDriverStick);
	
	public Button driverButtonX = new JoystickButton(driverStick, 1);
	public Button driverButtonA = new JoystickButton(driverStick, 2);
	public Button driverButtonB = new JoystickButton(driverStick, 3);
	public Button driverButtonY = new JoystickButton(driverStick, 4);
	public Button driverButtonLB = new JoystickButton(driverStick, 5);
	public Button driverButtonRB = new JoystickButton(driverStick, 6);
	public Button driverButtonLT = new JoystickButton(driverStick, 7);
	public Button driverButtonRT = new JoystickButton(driverStick, 8);
	public Button driverButtonStart = new JoystickButton(driverStick, 9);
	public Button driverButtonBack = new JoystickButton(driverStick, 10);
	public Button coDriverButtonX = new JoystickButton(coDriverStick, 1);
	public Button coDriverButtonA = new JoystickButton(coDriverStick, 2);
	public Button coDriverButtonB = new JoystickButton(coDriverStick, 3);
	public Button coDriverButtonY = new JoystickButton(coDriverStick, 4);
	public Button coDriverButtonLB = new JoystickButton(coDriverStick, 5);
	public Button coDriverButtonRB = new JoystickButton(coDriverStick, 6);
	public Button coDriverButtonLT = new JoystickButton(coDriverStick, 7);
	public Button coDriverButtonRT = new JoystickButton(coDriverStick, 8);
	
	public OI() {
		driverButtonRB.whileHeld(new intakeNoLimit());
		driverButtonRT.whileHeld(new releaseTote());
		driverButtonLB.whenPressed(new toggleIntake());
		driverButtonLT.whenPressed(new closeIntake());
		driverButtonLT.whileHeld(new intakeNoLimit());
		driverButtonLT.whenReleased(new openIntake());
		//coDriverButtonB.whenPressed(new moveToteElevator());
		driverButtonStart.whenPressed(new trueSpeed());
		driverButtonBack.whenPressed(new accSpeed());
	}
}

