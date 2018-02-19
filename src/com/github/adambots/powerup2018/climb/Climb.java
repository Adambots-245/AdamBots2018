package com.github.adambots.powerup2018.climb;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

public class Climb {
	
//	// initial conditions
//	public static void init() {
//		climbMotor = Actuators.getClimbMotor();
//	}
//	
	public static void startClimbing(boolean climbButton) {
		Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_SLOW);
	}
	
	public static void climbFaster(boolean climbFasterButton) {
		Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_FAST);
	}
	
	public static void stopClimbing(boolean stopClimbButton) {
		Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
	}
}
