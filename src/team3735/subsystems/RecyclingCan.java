package team3735.subsystems;

import team3735.RobotMap;
import team3735.commands.moveRecyclingElevator;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RecyclingCan extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Talon RCMotor;
	
	public static Solenoid rcClaw;
	public static Solenoid rcBrake;

	public RecyclingCan(){
		RCMotor = new Talon(RobotMap.RCMotor);
    	rcClaw = new Solenoid(RobotMap.rcClaw);
    	rcBrake = new Solenoid(RobotMap.rcBrake);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new moveRecyclingElevator());
    }
    public void move(double y) {
//    	if(y>=0) {
//    		brakeOn();
//    	}
//    	else {
//    		brakeOff();
//    	}
    	RCMotor.set(y);
    }
    public void brakeOn() {
    	rcBrake.set(true);
    }
    public void brakeOff() {
    	rcBrake.set(false);
    }
}

