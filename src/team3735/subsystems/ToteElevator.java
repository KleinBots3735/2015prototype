package team3735.subsystems;

import team3735.RobotMap;
import team3735.commands.moveToteElevator;
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
    	setDefaultCommand(new moveToteElevator());
    }
    //Limit Switches
    public boolean getTopLimit() {
    	return !toteTopLimit.get();
    }
    public boolean getBottomLimit() {
    	return toteBottomLimit.get();
    }

    
    //Encoder
    public int getEncoderCount() {
    	return toteEncoder.get();
    }
    public double getEncoderRate() {
    	return toteEncoder.getDistance() + toteEncoder.getEncodingScale() + toteEncoder.getRaw();
    }
    
    //Talons
    public void move(double y) {
    	if(y < 0) {
    		brakeOff();
    	}
    	else {
    		brakeOn();
    	}
    	toteMotor.set(y);
    }

    //Solenoids
    public void brakeOn() {
    	toteBrake.set(false);
    }
    public void brakeOff() {
    	toteBrake.set(true);
    }
}

