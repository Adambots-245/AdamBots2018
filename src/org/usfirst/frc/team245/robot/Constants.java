package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Constants {

	// CAN port map
	// TODO: Put in actual CAN map
	public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0;
	public static final int RIGHT_FRONT_DRIVE_MOTOR_PORT = 2;
	public static final int LEFT_REAR_DRIVE_MOTOR_PORT = 1;
	public static final int RIGHT_REAR_DRIVE_MOTOR_PORT = 3;

	// PWM port map
	// TODO: Put in actual PWM map
	public static final int LEFT_INTAKE_MOTOR_PWM_PORT = 1;
	public static final int RIGHT_INTAKE_MOTOR_PWM_PORT = 2;
	public static final int LEFT_CARRIAGE_MOTOR_PWM_PORT = 3;
	public static final int RIGHT_CARRIAGE_MOTOR_PWM_PORT = 4;

	// PCM port map
	// TODO: Put in actual PCM map
	public static final int LEFT_ARM_FIRST_PNEUMATIC_FORWARD_PORT = 1;
	public static final int LEFT_ARM_FIRST_PNEUMATIC_REVERSE_PORT = 2;
	public static final int LEFT_ARM_SECOND_PNEUMATIC_FORWARD_PORT = 3;
	public static final int LEFT_ARM_SECOND_PNEUMATIC_REVERSE_PORT = 4;
	public static final int RIGHT_ARM_PNEUMATIC_FORWARD_PORT = 5;
	public static final int RIGHT_ARM_PNEUMATIC_REVERSE_PORT = 6;
	
	// motor controller inversion
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
	
	// pneumatic positions
	public static final DoubleSolenoid.Value PNEUMATIC_FORWARD = DoubleSolenoid.Value.kForward;
	public static final DoubleSolenoid.Value PNEUMATIC_REVERSE = DoubleSolenoid.Value.kReverse;
	public static final DoubleSolenoid.Value PNEUMATIC_OFF = DoubleSolenoid.Value.kOff;
	
}
