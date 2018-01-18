package org.usfirst.frc.team245.robot;

public class Actuators {
	
	private static CANTalon rightFrontMotor;
	private static CANTalon rightRearMotor;
	private static CANTalon leftFrontMotor;
	private static CANTalon leftRearMotor;
	
	// 
	public static void init() {
		rightFrontMotor = new CANTalon(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT)
		rightRearMotor = new CANTalon(Constants.RIGHT_REAR_DRIVE_MOTOR_PORT)
		leftFrontMotor = new CANTalon(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
		leftRearMotor = new CANTalon(Constants.LEFT_REAR_DRIVE_MOTOR_PORT);
	}

	public static CANTalon getRightFrontMotor() {
		return rightFrontMotor;
	}

	public static CANTalon getRightRearMotor() {
		return rightRearMotor;
	}

	public static CANTalon getLeftFrontMotor() {
		return leftFrontMotor;
	}

	public static CANTalon getLeftRearMotor() {
		return leftRearMotor;
	}
	
	
}
