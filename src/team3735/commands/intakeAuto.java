package team3735.commands;

import team3735.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class intakeAuto extends CommandGroup {
    
    public  intakeAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	requires(Robot.intake);
    	requires(Robot.toteElevator);
    	
    	addSequential(new intake());
    	addSequential(new teDown());
    	addSequential(new teUp(),0.1);
    }
}
