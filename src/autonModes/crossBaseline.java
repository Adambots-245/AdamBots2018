package autonModes;

import org.usfirst.frc.team245.robot.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class crossBaseline {
	
	String waitTimeString;
	static double waitTimeNum;
	
	protected void init(){
		waitTimeString = SmartDashboard.getString("Wait time", "no wait time given");
		waitTimeNum = Double.parseDouble(waitTimeString);
	}
	
	protected static void execute(){
		Timer.delay(waitTimeNum);
		mecDrive(0, Constants.AUTON_MOTOR_SPEED, 0);
		Timer.delay(Constants.AUTON_CROSS_BASELINE_TIME);
	}
	
	public crossBaseline(){
		
	}
}
