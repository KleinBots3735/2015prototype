package team3735;

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
	public Button driverButtonX = new JoystickButton(RobotMap.driverStick, 1);
	public Button driverButtonA = new JoystickButton(RobotMap.driverStick, 2);
	public Button driverButtonB = new JoystickButton(RobotMap.driverStick, 3);
	public Button driverButtonY = new JoystickButton(RobotMap.driverStick, 4);
	public Button driverButtonLB = new JoystickButton(RobotMap.driverStick, 5);
	public Button driverButtonRB = new JoystickButton(RobotMap.driverStick, 6);
	public Button driverButtonLT = new JoystickButton(RobotMap.driverStick, 7);
	public Button driverButtonRT = new JoystickButton(RobotMap.driverStick, 8);
	
	public Button coDriverButtonX = new JoystickButton(RobotMap.coDriverStick, 1);
	public Button coDriverButtonA = new JoystickButton(RobotMap.coDriverStick, 2);
	public Button coDriverButtonB = new JoystickButton(RobotMap.coDriverStick, 3);
	public Button coDriverButtonY = new JoystickButton(RobotMap.coDriverStick, 4);
	public Button coDriverButtonLB = new JoystickButton(RobotMap.coDriverStick, 5);
	public Button coDriverButtonRB = new JoystickButton(RobotMap.coDriverStick, 6);
	public Button coDriverButtonLT = new JoystickButton(RobotMap.coDriverStick, 7);
	public Button coDriverButtonRT = new JoystickButton(RobotMap.coDriverStick, 8);
	
	public OI()
	{
		//driverButtonX.whileHeld(new moveToteElevator());
	}
}

