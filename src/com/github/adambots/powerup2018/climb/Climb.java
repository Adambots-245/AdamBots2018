package com.github.adambots.powerup2018.climb;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

public class Climb {
	
//	// initial conditions
//	public static void init() {
//		climbMotor = Actuators.getClimbMotor();
//	}
//	
	public static void startClimbing(double climbTrigger) {
		if (climbTrigger > 0 && climbTrigger <= 0.85) {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_SLOW);
		} else if (climbTrigger > 0.85 && climbTrigger <= 1.0) {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_FAST);
		} else {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
		}
	}
	
	public static void reverseClimbing(double climbTrigger) {
		if (climbTrigger > 0 && climbTrigger <= 0.85) {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_SLOW);
		} else if (climbTrigger > 0.85 && climbTrigger <= 1.0) {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_REVERSE);
		} else {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
		}
	}
	
}
