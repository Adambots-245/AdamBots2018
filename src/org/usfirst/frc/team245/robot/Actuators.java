package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.PWMTalonSRX;

public class Actuators {
	
	private static PWMTalonSRX rightFrontMotor;
	private static PWMTalonSRX rightRearMotor;
	private static PWMTalonSRX leftFrontMotor;
	private static PWMTalonSRX leftRearMotor;
	
	// 
	public static void init() {
		rightFrontMotor = new PWMTalonSRX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
		rightRearMotor = new PWMTalonSRX(Constants.RIGHT_REAR_DRIVE_MOTOR_PORT);
		leftFrontMotor = new PWMTalonSRX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
		leftRearMotor = new PWMTalonSRX(Constants.LEFT_REAR_DRIVE_MOTOR_PORT);
	}

	public static PWMTalonSRX getRightFrontMotor() {
		return rightFrontMotor;
	}

	public static PWMTalonSRX getRightRearMotor() {
		return rightRearMotor;
	}

	public static PWMTalonSRX getLeftFrontMotor() {
		return leftFrontMotor;
	}

	public static PWMTalonSRX getLeftRearMotor() {
		return leftRearMotor;
	}
	
	
}
