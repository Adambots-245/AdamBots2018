package autonModes;

import org.usfirst.frc.team245.robot.Constants;

import com.github.adambots.powerup2018.drive.Drive;

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
		Timer time = new Timer();
		if (time.get() > waitTimeNum){
		Drive.mecDrive(0, Constants.AUTON_MOTOR_SPEED, 0);
		}
	}
	
	public crossBaseline(){
		
	}
}
