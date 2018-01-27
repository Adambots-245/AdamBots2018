package org.usfirst.frc.team245.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Actuators {

	private static TalonSRX rightFrontMotor;
	private static TalonSRX rightRearMotor;
	private static TalonSRX leftFrontMotor;
	private static TalonSRX leftRearMotor;

	//
	public static void init() {
		rightFrontMotor = new TalonSRX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
		rightRearMotor = new TalonSRX(Constants.RIGHT_REAR_DRIVE_MOTOR_PORT);
		leftFrontMotor = new TalonSRX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
		leftRearMotor = new TalonSRX(Constants.LEFT_REAR_DRIVE_MOTOR_PORT);
	}

	public static TalonSRX getRightFrontMotor() {
		return rightFrontMotor;
	}

	public static TalonSRX getRightRearMotor() {
		return rightRearMotor;
	}

	public static TalonSRX getLeftFrontMotor() {
		return leftFrontMotor;
	}

	public static TalonSRX getLeftRearMotor() {
		return leftRearMotor;
	}

}
