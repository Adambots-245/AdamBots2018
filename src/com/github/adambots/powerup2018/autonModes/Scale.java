package com.github.adambots.powerup2018.autonModes;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

import com.github.adambots.powerup2018.auton.AutonConstants;
import com.github.adambots.powerup2018.auton.AutonRoutine;
//import com.github.adambots.powerup2018.auton.Play;
import com.github.adambots.powerup2018.auton.Time;
import com.github.adambots.powerup2018.drive.Drive;
import com.github.adambots.powerup2018.field.Field;
import com.github.adambots.powerup2018.intake.Intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Scale extends AutonRoutine{

	private boolean leftScaleValue;
	private boolean rightScaleValue;
	double time;
	private static char position = Field.getScale(); 
	
		public Scale(){

		}	

		protected void init(){
			Intake.setArmsPosition(Constants.ARMS_IN);
			time = Time.getTime();
			
			if(position != 'L'){
				rightScaleValue = true;
			}else{
				leftScaleValue = true;	
			}
			if(leftScaleValue){
//				Play.readRecording("/Documents/ghostMode.txt"); ///TODO: call actual pathway on roborio
			}
			else if(rightScaleValue){
//				Play.readRecording("/Documents/ghostMode.txt");
			}
		}
		public void execute() { //check the cross baseline values 
			/*if(time < AutonConstants.GHOSTCODE_CROSS_TIME) {
				Drive.autonDrive(0, AutonConstants.SWITCH_SPEED, 0);
			}*/
			//if(leftScaleValue){
				//Play.playRecording();			

			//}

		}
	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end() {
		Drive.autonDrive(0, 0, 0, 0);
		Actuators.setCarriageLiftMotorSpeed(0);

	}

	
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
