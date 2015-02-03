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
						toteTopLimit, 
						toteStatus ;
	
	//Encoder
	public static Encoder toteEncoder;

	//Talons
	public static Talon toteMotor, 
						intakeMotorLeft, 
						intakeMotorRight;
	
	//Solenoids
	public static Solenoid intakeLeft,
						   intakeRight,
						   toteBrake;	
	
	public static double moveValue;

	public ToteElevator() {
		//Limit Switches 
		toteTopLimit = new DigitalInput(RobotMap.toteTopLimit);
    	toteBottomLimit = new DigitalInput(RobotMap.toteBottomLimit);
    	toteStatus = new DigitalInput(RobotMap.toteStatus);
    	
    	//Encoder
    	toteEncoder = new Encoder(RobotMap.toteEncoderA,RobotMap.toteEncoderB);

    	//Talons
    	toteMotor = new Talon(RobotMap.toteMotor);
    	intakeMotorLeft = new Talon(RobotMap.intakeMotorleft);
    	intakeMotorRight = new Talon(RobotMap.intakeMotorRight);
    	
    	//Solenoids
    	intakeLeft = new Solenoid(RobotMap.intakeLeft);
    	intakeRight = new Solenoid(RobotMap.intakeRight);
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
    public boolean getToteStatus() {
    	return !toteStatus.get();
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
//    	if(y>=0) {
//    		brakeOn();
//    	}
//    	else {
//    		brakeOff();
//    	}
    	toteMotor.set(y);
    	moveValue = -y;
    }
    public void motorIntake() {
    	//intakeMotorLeft.set(1);
    	//intakeMotorRight.set(-1);
    	intakeMotorLeft.set(-0.75);
    	intakeMotorRight.set(0.75);
    }    
    public void motorRelease() {
    	//intakeMotorLeft.set(-1);
    	//intakeMotorRight.set(1);
    	intakeMotorLeft.set(0.75);
    	intakeMotorRight.set(-0.75);
    }
    public void stopIntake() {
    	intakeMotorLeft.set(0);
    	intakeMotorRight.set(0);
    }
    
    public void moveIntake(double x) {
    	intakeMotorLeft.set(x);
    	intakeMotorRight.set(x);
    }
    
    //Solenoids
    public void closeIntake() {
    	intakeLeft.set(false);
    	intakeRight.set(false);
    }
    public void openIntake() {
    	intakeLeft.set(true);
    	intakeRight.set(true);
    }    
    public void brakeOn() {
    	toteBrake.set(true);
    }
    public void brakeOff() {
    	toteBrake.set(false);
    }
}

