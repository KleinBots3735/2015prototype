package team3735.subsystems;

import team3735.RobotMap;
import team3735.commands.moveRecyclingElevator;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RecyclingCan extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Limit Switches
	public static DigitalInput rcTopLimit;
	public static DigitalInput rcBottomLimit;
	
	//Encoder
	public static Encoder rcEncoder;

	//Talons
	public static Talon rcMotor;
	
	//Solenoids
	public static Solenoid rcClaw;
	public static Solenoid rcBrake;
	
	public RecyclingCan() {
		rcTopLimit = new DigitalInput(RobotMap.rcTopLimit);
		rcBottomLimit = new DigitalInput(RobotMap.rcBottomLimit);
		
		rcMotor = new Talon(RobotMap.rcMotor);
		
    	rcClaw = new Solenoid(RobotMap.rcClaw);
    	rcBrake = new Solenoid(RobotMap.rcBrake);
    	
    	rcEncoder = new Encoder(RobotMap.rcEncoderA,RobotMap.rcEncoderB);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new moveRecyclingElevator());
    }
    //Limit Switches
    public boolean getTopLimit() {
    	return rcTopLimit.get();
    }
    public boolean getBottomLimit() {
    	return rcBottomLimit.get();
    }
    
    //Encoder
    public double getEncoderCount() {
    	return rcEncoder.get();
    }
    
    //Talons
    public void move(double y) {
//    	if(y>=0) {
//    		brakeOn();
//    	}
//    	else {
//    		brakeOff();
//    	}
    	rcMotor.set(y);
    }
    
    //Solenoids
    public void openClaw() {
    	rcClaw.set(true);
    }
    public void closeClaw() {
    	rcClaw.set(false);
    }
    public void brakeOn() {
    	rcBrake.set(true);
    }
    public void brakeOff() {
    	rcBrake.set(false);
    }
}

