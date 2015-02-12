package team3735.subsystems;

import team3735.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

	
public class Intake extends Subsystem {
    
	//Limit Switch
	public static DigitalInput toteStatus;
	
	//Talon
	public static Talon	intakeMotorLeft, 
						intakeMotorRight;
	
	//Solenoid
	public static Solenoid intakeSolenoid;

	public Intake() {
		//Limit Switch
    	toteStatus = new DigitalInput(RobotMap.toteStatus);
    	
    	//Talon
    	intakeMotorLeft = new Talon(RobotMap.intakeMotorleft);
    	intakeMotorRight = new Talon(RobotMap.intakeMotorRight);
    	
    	//Solenoid
    	intakeSolenoid = new Solenoid(RobotMap.intakeSolenoid);
	}
	
	//Limit Switch
    public boolean getToteStatus() {
    	return !toteStatus.get();
    }
    
    //Talon
    public void motorIntake() {
    	//intakeMotorLeft.set(1);
    	//intakeMotorRight.set(-1);
    	intakeMotorLeft.set(0.75);
    	intakeMotorRight.set(-0.75);
    }    
    public void motorRelease() {
    	//intakeMotorLeft.set(-1);
    	//intakeMotorRight.set(1);
    	intakeMotorLeft.set(-0.75);
    	intakeMotorRight.set(0.75);
    }
    public void stopIntake() {
    	intakeMotorLeft.set(0);
    	intakeMotorRight.set(0);
    }
    public void moveIntake(double x) {
    	intakeMotorLeft.set(x);
    	intakeMotorRight.set(x);
    }
    
    //Solenoid
    public void closeIntake() {
    	intakeSolenoid.set(false);
    	intakeSolenoid.set(false);
    }
    public void openIntake() {
    	intakeSolenoid.set(true);
    	intakeSolenoid.set(true);
    }    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

