package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Constants {

	//need photoeye port
	public static final int PHOTOEYE_PORT = 0;
	
	// CAN port map
	// TODO: Put in actual CAN map
	public static final int LEFT_FRONT_DRIVE_MOTOR_PORT = 0;
	public static final int RIGHT_FRONT_DRIVE_MOTOR_PORT = 1;
	public static final int LEFT_REAR_DRIVE_MOTOR_PORT = 4;
	public static final int RIGHT_REAR_DRIVE_MOTOR_PORT = 3;
	public static final int CARRIAGE_LIFT_MOTOR_PORT = 2;
	// PWM port map
	// TODO: Put in actual PWM map
	public static final int LEFT_INTAKE_MOTOR_PWM_PORT = 0;
	public static final int RIGHT_INTAKE_MOTOR_PWM_PORT = 2;
	public static final int LEFT_CARRIAGE_MOTOR_PWM_PORT = 1;
	public static final int RIGHT_CARRIAGE_MOTOR_PWM_PORT = 3;

	// PCM port map
	// TODO: Put in actual PCM map
	public static final int LEFT_ARM_OPEN_PNEUMATIC_FORWARD_PORT = 2;
	public static final int LEFT_ARM_OPEN_PNEUMATIC_REVERSE_PORT = 3;
	public static final int LEFT_ARM_MID_PNEUMATIC_FORWARD_PORT = 0;
	public static final int LEFT_ARM_MID_PNEUMATIC_REVERSE_PORT = 1;
	public static final int RIGHT_ARM_OPEN_PNEUMATIC_FORWARD_PORT = 4;
	public static final int RIGHT_ARM_OPEN_PNEUMATIC_REVERSE_PORT = 5;
	public static final int RIGHT_ARM_MID_PNEUMATIC_FORWARD_PORT = 6;
	public static final int RIGHT_ARM_MID_PNEUMATIC_REVERSE_PORT = 7;

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
	public static final int ARMS_IN = 1;
	public static final int ARMS_MID = 2;
	public static final int ARMS_OUT = 3;

	// carriage lift
	// TODO: Find actual limits, increment, phase, and PID for carriage
	public static final com.ctre.phoenix.motorcontrol.FeedbackDevice QUAD_ENCODER = com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder;
	public static final int CARRIAGE_LIFT_ENCODER_SENSOR = 0;
	public static final int CARRIAGE_LIFT_START_POSITION = 0;
	public static final int CARRIAGE_LIFT_FORWARD_LIMIT = 1024;
	public static final int CARRIAGE_LIFT_REVERSE_LIMIT = -1024;
	public static final boolean CARRIAGE_LIFT_FORWARD_LIMIT_ENABLED = false;
	public static final boolean CARRIAGE_LIFT_REVERSE_LIMIT_ENABLED = false;
	public static final double CARRIAGE_LIFT_POSITION_INCREMENT = 512;
	public static final boolean CARRIGE_LIFT_MOTOR_PHASE = false;	

	// PID values
	public static final int CARRIAGE_LIFT_PID_PROFILE = 0;
	public static final int CARRIAGE_LIFT_TIMEOUT = 0;
	public static final double CARRIAGE_LIFT_P = .1;
	public static final double CARRIAGE_LIFT_I = .01;
	public static final double CARRIAGE_LIFT_D = .01;
}

