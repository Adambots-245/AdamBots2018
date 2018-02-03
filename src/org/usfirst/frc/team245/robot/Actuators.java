package org.usfirst.frc.team245.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Actuators {

	// motor controllers
	private static WPI_TalonSRX rightFrontMotor;
	private static WPI_TalonSRX rightRearMotor;
	private static WPI_TalonSRX leftFrontMotor;
	private static WPI_TalonSRX leftRearMotor;

	// initialzies all actuators
	public static void init() {

		// initialize Talons
		rightFrontMotor = new WPI_TalonSRX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
		rightRearMotor = new WPI_TalonSRX(Constants.RIGHT_REAR_DRIVE_MOTOR_PORT);
		leftFrontMotor = new WPI_TalonSRX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
		leftRearMotor = new WPI_TalonSRX(Constants.LEFT_REAR_DRIVE_MOTOR_PORT);

		// set Talons inverted
		rightFrontMotor.setInverted(Constants.RIGHT_FRONT_DRIVE_MOTOR_INVERTED);
		rightRearMotor.setInverted(Constants.RIGHT_REAR_DRIVE_MOTOR_INVERTED);
		leftFrontMotor.setInverted(Constants.LEFT_FRONT_DRIVE_MOTOR_INVERTED);
		leftRearMotor.setInverted(Constants.LEFT_REAR_DRIVE_MOTOR_INVERTED);

	}

	public static WPI_TalonSRX getRightFrontMotor() {
		return rightFrontMotor;
	}

	public static WPI_TalonSRX getRightRearMotor() {
		return rightRearMotor;
	}

	public static WPI_TalonSRX getLeftFrontMotor() {
		return leftFrontMotor;
	}

	public static WPI_TalonSRX getLeftRearMotor() {
		return leftRearMotor;
	}

}
