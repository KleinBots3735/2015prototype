package team3735.subsystems;

import team3735.Robot;
import team3735.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToteElevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
    }
    public void intake(){
    	RobotMap.intakeMotorleft.set(1);
    	RobotMap.intakeMotorRight.set(-1);
    }
    public void release() {
    	RobotMap.intakeMotorleft.set(-1);
    	RobotMap.intakeMotorRight.set(1);
    }
    public void stopIntake() {
    	RobotMap.intakeMotorleft.set(0);
    	RobotMap.intakeMotorRight.set(0);
    }
    public void move(double y) {
    	Robot.toteMotor.set(y);
    }
    public int getCount() {
    	return RobotMap.elevatorEncoder.get();
    }
}

