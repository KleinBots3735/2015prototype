package team3735.subsystems;

import team3735.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RecyclingCan extends Subsystem {
    
	//Limit Switches
	public static DigitalInput rcTopLimit, rcBottomLimit;
	
	//Encoder
	public static Encoder rcEncoder;

	//Talons
	public static Talon rcMotor;
	
	//Solenoids
	public static Solenoid rcClaw;
	
	public RecyclingCan() {
		//Limit Switches
		rcTopLimit = new DigitalInput(RobotMap.rcTopLimit);
		rcBottomLimit = new DigitalInput(RobotMap.rcBottomLimit);
		
		//Talons
		rcMotor = new Talon(RobotMap.rcMotor);
		
		//Solenoids
    	rcClaw = new Solenoid(RobotMap.rcClaw);
	}
	
    public void initDefaultCommand() {
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
    	rcMotor.set(y);
    }
    
    public void moveUp(){
    	rcMotor.set(1);
    }
    public void moveDown(){
    	rcMotor.set(-1);
    }
    
    //Solenoids
    public void openClaw() {
    	rcClaw.set(true);
    }
    public void closeClaw() {
    	rcClaw.set(false);
    }
}

