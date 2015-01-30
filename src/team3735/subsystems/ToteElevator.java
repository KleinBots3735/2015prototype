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
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Talon toteMotor;
	public static Talon intakeMotorLeft;
	public static Talon intakeMotorRight;
	
	public DigitalInput toteBottomLimit;
	public DigitalInput toteTopLimit;
	
	public static Solenoid intake;
	public static Solenoid toteBrake;
	
	public static Encoder elevatorEncoder;

	public ToteElevator(){
    	toteMotor = new Talon(RobotMap.toteMotor);
    	intakeMotorLeft = new Talon(RobotMap.intakeMotorleft);
    	intakeMotorRight = new Talon(RobotMap.intakeMotorRight);
    	toteTopLimit = new DigitalInput(RobotMap.toteTopLimit);
    	toteBottomLimit = new DigitalInput(RobotMap.toteBottomLimit);
    	intake = new Solenoid(RobotMap.intake);
    	toteBrake = new Solenoid(RobotMap.toteBrake);
    	elevatorEncoder = new Encoder(RobotMap.toteElevatorEncoderA,RobotMap.toteElevatorEncoderB);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new moveToteElevator());
    }
    public void intake() {
    	closeIntake();
    	intakeMotorLeft.set(1);
    	intakeMotorRight.set(-1);
    }
    public void release() {
    	closeIntake();
    	intakeMotorLeft.set(-1);
    	intakeMotorRight.set(1);
    }
    public void stopIntake() {
    	openIntake();
    	intakeMotorLeft.set(0);
    	intakeMotorRight.set(0);
    }
    public void move(double y) {
//    	if(y>=0) {
//    		brakeOn();
//    	}
//    	else {
//    		brakeOff();
//    	}
    	toteMotor.set(y);
    }
    public void brakeOn() {
    	toteBrake.set(true);
    }
    public void brakeOff() {
    	toteBrake.set(false);
    }
    public void openIntake() {
    	intake.set(false);
    }
    public void closeIntake() {
    	intake.set(true);
    }
    public int getCount() {
    	return elevatorEncoder.get();
    }
}

