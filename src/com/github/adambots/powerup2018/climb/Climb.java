package com.github.adambots.powerup2018.climb;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Climb {
	
//	// initial conditions
//	public static void init() {
//		climbMotor = Actuators.getClimbMotor();
//	}
//	
	public static void startClimbing(boolean climbButton) {
		if (climbButton) {
			Actuators.getClimbMotor().set(Constants.CLIMB_SPEED_SLOW);
		}
	}
	
	public static void climbFaster(boolean climbFasterButton) {
		if (climbFasterButton) {
			Actuators.getClimbMotor().set(Constants.CLIMB_SPEED_FAST);
		}
	}
	
	public static void stopClimbing(boolean stopClimbButton) {
		Actuators.getClimbMotor().set(Constants.CLIMB_SPEED_STOP);
	}
}
