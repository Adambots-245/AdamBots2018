package com.github.adambots.powerup2018.auton;

import org.usfirst.frc.team245.robot.Actuators;

public class Auton {

	public static void DoNothing() {
		
		Actuators.getLeftFrontMotor().set(ControlMode.PercentOutput, 0);
		Actuators.getRightFrontMotor().set(ControlMode.PercentOutput, 0);
		Actuators.getLeftRearMotor().set(ControlMode.PercentOutput, 0);
		Actuators.getRightRearMotor().set(ControlMode.PercentOutput, 0);
		
	}
	
	public static void CrossBaseline() {
		
		// TODO: set delay and time limits
		Actuators.getLeftFrontMotor().set(ControlMode.PercentOutput, 50);
		Actuators.getRightFrontMotor().set(ControlMode.PercentOutput, 50);
		Actuators.getLeftRearMotor().set(ControlMode.PercentOutput, 50);
		Actuators.getRightRearMotor().set(ControlMode.PercentOutput, 50);
	}
}
