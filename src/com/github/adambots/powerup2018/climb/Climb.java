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
		if (climbTrigger > 0.05) {
			Actuators.setClimbMotorSpeed(climbTrigger);
		} else {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
		}
	}
	
	public static void reverseClimbing(double climbTrigger, double climbReverseTrigger) {
		if (climbTrigger > 0.05) {
			Actuators.setClimbMotorSpeed(climbTrigger);
		} else if (climbReverseTrigger > 0.05) {
			Actuators.setClimbMotorSpeed(-climbReverseTrigger);
		} else {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
		}
	}
	
}
