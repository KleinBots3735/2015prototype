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
	public DigitalInput toteBottomLimit;
	public DigitalInput toteTopLimit;
	public DigitalInput toteStatus;
	
	//Encoder
	public static Encoder toteEncoder;

	//Talons
	public static Talon toteMotor;
	public static Talon intakeMotorLeft;
	public static Talon intakeMotorRight;
	
	//Solenoids
	public static Solenoid intake;
	public static Solenoid toteBrake;	

	public ToteElevator(){
    	toteMotor = new Talon(RobotMap.toteMotor);
    	intakeMotorLeft = new Talon(RobotMap.intakeMotorleft);
    	intakeMotorRight = new Talon(RobotMap.intakeMotorRight);
    	toteTopLimit = new DigitalInput(RobotMap.toteTopLimit);
    	toteBottomLimit = new DigitalInput(RobotMap.toteBottomLimit);
    	toteStatus = new DigitalInput(RobotMap.toteStatus);
    	intake = new Solenoid(RobotMap.intake);
    	toteBrake = new Solenoid(RobotMap.toteBrake);
    	toteEncoder = new Encoder(RobotMap.toteEncoderA,RobotMap.toteEncoderB);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new moveToteElevator());
    }
    //Limit Switches
    public boolean getTopLimit() {
    	return toteTopLimit.get();
    }
    public boolean getBottomLimit() {
    	return toteBottomLimit.get();
    }
    public boolean getToteStatus() {
    	return toteStatus.get();
    }
    
    //Encoder
    public int getEncoderCount() {
    	return toteEncoder.get();
    }
    
    //Talons
    public void move(double y) {
//    	if(y>=0) {
//    		brakeOn();
//    	}
//    	else {
//    		brakeOff();
//    	}
    	toteMotor.set(y);
    }
    public void motorIntake() {
    	intakeMotorLeft.set(1);
    	intakeMotorRight.set(-1);
    }    
    public void motorRelease() {
    	intakeMotorLeft.set(-1);
    	intakeMotorRight.set(1);
    }
    public void stopIntake() {
    	intakeMotorLeft.set(0);
    	intakeMotorRight.set(0);
    }
    
    //Solenoids
    public void openIntake() {
    	intake.set(false);
    }
    public void closeIntake() {
    	intake.set(true);
    }    
    public void brakeOn() {
    	toteBrake.set(true);
    }
    public void brakeOff() {
    	toteBrake.set(false);
    }
}

