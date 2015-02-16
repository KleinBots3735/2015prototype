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
public class ToteElevator extends Subsystem {
    
    //Limit Switches
	public DigitalInput toteBottomLimit, 
						toteTopLimit;
	
	//Encoder
	public static Encoder toteEncoder;

	//Talons
	public static Talon toteMotor;
	
	//Solenoids
	public static Solenoid toteBrake;	
	
	public static double moveValue;
	
	public static int level;

	public ToteElevator() {
		//Limit Switches 
		toteTopLimit = new DigitalInput(RobotMap.toteTopLimit);
    	toteBottomLimit = new DigitalInput(RobotMap.toteBottomLimit);
    	
    	//Encoder
    	toteEncoder = new Encoder(RobotMap.toteEncoderA,RobotMap.toteEncoderB);

    	//Talons
    	toteMotor = new Talon(RobotMap.toteMotor);
    	
    	//Solenoids
    	toteBrake = new Solenoid(RobotMap.toteBrake);
    	
	}
	
    public void initDefaultCommand() {
    }
    //Limit Switches
    public boolean getTopLimit() {
    	return !toteTopLimit.get();
    }
    public boolean getBottomLimit() {
    	return !toteBottomLimit.get();
    }

    
    //Encoder
    public int getEncoderCount() {
    	return toteEncoder.get();
    }
    public double getEncoderRate() {
    	return toteEncoder.getDistance() + toteEncoder.getEncodingScale() + toteEncoder.getRaw();
    }
	public void resetEncoder() {
		toteEncoder.reset();
	}

    
    //Talons
    public void move(double y) {
    	toteMotor.set(y);
    }
    
    public void moveUp(){
    	brakeOn();
    	if(getTopLimit()){
    		move(0);
    	}
    	else {
    		move(-1);
    	}
    }
    
    public void moveDown(){
    	brakeOff();
    	if(getBottomLimit()){
    		move(0);
    	}
    	else {
    		move(1);
    	}
    }

    //Solenoids
    public void brakeOn() {
    	toteBrake.set(false);
    }
    public void brakeOff() {
    	toteBrake.set(true);
    }

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		ToteElevator.level = level;
	}  
    
}

