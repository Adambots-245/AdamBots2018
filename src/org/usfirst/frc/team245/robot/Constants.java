package org.usfirst.frc.team245.robot;

public class Constants {

	// port mapping

	// CAN
	// TODO: Put in actual CAN map
	public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0;
	public static final int RIGHT_FRONT_DRIVE_MOTOR_PORT = 2;
	public static final int LEFT_REAR_DRIVE_MOTOR_PORT = 1;
	public static final int RIGHT_REAR_DRIVE_MOTOR_PORT = 3;

	// PWM
	// TODO: Put in actual PWM map
	public static final int LEFT_INTAKE_MOTOR_PWM_PORT = 1;
	public static final int RIGHT_INTAKE_MOTOR_PWM_PORT = 2;
	public static final int LEFT_CARRIAGE_MOTOR_PWM_PORT = 3;
	public static final int RIGHT_CARRIAGE_MOTOR_PWM_PORT = 4;

	// inverted
	public static final boolean LEFT_FRONT_DRIVE_MOTOR_INVERTED = true;
	public static final boolean RIGHT_FRONT_DRIVE_MOTOR_INVERTED = true;
	public static final boolean LEFT_REAR_DRIVE_MOTOR_INVERTED = true;
	public static final boolean RIGHT_REAR_DRIVE_MOTOR_INVERTED = true;
	public static final boolean LEFT_INTAKE_MOTOR_INVERTED = false;
	public static final boolean RIGHT_INTAKE_MOTOR_INVERTED = false;
	public static final boolean LEFT_CARRIAGE_MOTOR_INVERTED = false;
	public static final boolean RIGHT_CARRIAGE_MOTOR_INVERTED = false;

	// min and max motor speed
	public static final double MIN_MOTOR_SPEED = -1.0;
	public static final double MAX_MOTOR_SPEED = 1.0;
	public static final double STOP_MOTOR_SPEED = 0;
	public static final double CARRIAGE_MOTOR_OUTTAKE_SPEED = -1.0;
	public static final double CARRIAGE_MOTOR_INTAKE_SPEED = 1.0;

}
