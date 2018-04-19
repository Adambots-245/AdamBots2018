package com.github.adambots.powerup2018.climb;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

import com.github.adambots.powerup2018.controller.Gamepad;

public class Climb {
	
//	// initial conditions
//	public static void init() {
//		climbMotor = Actuators.getClimbMotor();
//	}
//	
	
	
	
	public static void stopClimbing(boolean overrideButton) {
		double current = Actuators.getClimbMotor().getOutputCurrent();
		if (current > Constants.CLIMB_MAX_CURRENT) {
			double rumbleIntensity = Constants.RUMBLE_INTENSITY;
			int rumbleTime = 1;
			if ( !overrideButton ) {
				Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
				Gamepad.secondary.rumble(rumbleIntensity, rumbleIntensity, rumbleTime);
				System.out.println("CLIMB MOTOR CURRENT = [" + current + "]");					
			}
		}
	}
	
	public static void startClimbing(double climbTrigger) {
		if (climbTrigger > Constants.CLIMB_MIN_SPEED) {
			Actuators.setClimbMotorSpeed(climbTrigger);
		} else {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
		} 
	}
	
	public static void reverseClimbing(double climbTrigger, double climbReverseTrigger) {
		if (climbTrigger > Constants.CLIMB_MIN_SPEED) {
			Actuators.setClimbMotorSpeed(climbTrigger);
		} else if (climbReverseTrigger > Constants.CLIMB_MIN_SPEED) {
			Actuators.setClimbMotorSpeed(-climbReverseTrigger);
		} else {
			Actuators.setClimbMotorSpeed(Constants.CLIMB_SPEED_STOP);
		}
	}
	}
