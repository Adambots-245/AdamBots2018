package com.github.adambots.powerup2018.climb;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

public class Climb {
	
//	// initial conditions
//	public static void init() {
//		climbMotor = Actuators.getClimbMotor();
//	}
//	
	public static void startClimbing(boolean climbButton, boolean climbFasterButton) {
		Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_SLOW);
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_SLOW);
		} else if (climbFasterButton) {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_FAST);
		} else {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
	}
	
	public static void reverseClimbing(boolean climbButton, boolean reverseButton) {
		if (climbButton) {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_SLOW);
		} else if (reverseButton) {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_REVERSE);
		} else {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
		}
	}
	
}
