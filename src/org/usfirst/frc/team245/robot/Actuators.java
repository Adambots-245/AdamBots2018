package org.usfirst.frc.team245.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;

public class Actuators {

	// motor controllers
	private static WPI_TalonSRX rightFrontMotor;
	private static WPI_TalonSRX rightRearMotor;
	private static WPI_TalonSRX leftFrontMotor;
	private static WPI_TalonSRX leftRearMotor;
	private static VictorSP leftIntakeMotor;
	private static VictorSP rightIntakeMotor;
	private static VictorSP leftCarriageMotor;
	private static VictorSP rightCarriageMotor;

	// pneumatics
	private static DoubleSolenoid leftArmFirstPneumatic;
	private static DoubleSolenoid leftArmSecondPneumatic;
	private static DoubleSolenoid rightArmPneumatic;

	// initializes all actuators
	public static void init() {

		// initialize motor controllers
		rightFrontMotor = new WPI_TalonSRX(Constants.RIGHT_FRONT_DRIVE_MOTOR_PORT);
		rightRearMotor = new WPI_TalonSRX(Constants.RIGHT_REAR_DRIVE_MOTOR_PORT);
		leftFrontMotor = new WPI_TalonSRX(Constants.LEFT_FRONT_DRIVE_MOTOR_PORT);
		leftRearMotor = new WPI_TalonSRX(Constants.LEFT_REAR_DRIVE_MOTOR_PORT);
		leftIntakeMotor = new VictorSP(Constants.LEFT_INTAKE_MOTOR_PWM_PORT);
		rightIntakeMotor = new VictorSP(Constants.RIGHT_INTAKE_MOTOR_PWM_PORT);
		leftCarriageMotor = new VictorSP(Constants.LEFT_CARRIAGE_MOTOR_PWM_PORT);
		rightCarriageMotor = new VictorSP(Constants.RIGHT_CARRIAGE_MOTOR_PWM_PORT);

		// initialize pneumatics
		leftArmFirstPneumatic = new DoubleSolenoid(Constants.LEFT_ARM_FIRST_PNEUMATIC_FORWARD_PORT,
				Constants.LEFT_ARM_FIRST_PNEUMATIC_REVERSE_PORT);
		leftArmSecondPneumatic = new DoubleSolenoid(Constants.LEFT_ARM_SECOND_PNEUMATIC_FORWARD_PORT,
				Constants.LEFT_ARM_SECOND_PNEUMATIC_REVERSE_PORT);
		rightArmPneumatic = new DoubleSolenoid(Constants.RIGHT_ARM_PNEUMATIC_FORWARD_PORT,
				Constants.RIGHT_ARM_PNEUMATIC_REVERSE_PORT);

		// invert motorcontrollers
		rightFrontMotor.setInverted(Constants.RIGHT_FRONT_DRIVE_MOTOR_INVERTED);
		rightRearMotor.setInverted(Constants.RIGHT_REAR_DRIVE_MOTOR_INVERTED);
		leftFrontMotor.setInverted(Constants.LEFT_FRONT_DRIVE_MOTOR_INVERTED);
		leftRearMotor.setInverted(Constants.LEFT_REAR_DRIVE_MOTOR_INVERTED);
		leftIntakeMotor.setInverted(Constants.LEFT_INTAKE_MOTOR_INVERTED);
		rightIntakeMotor.setInverted(Constants.RIGHT_INTAKE_MOTOR_INVERTED);
		leftCarriageMotor.setInverted(Constants.LEFT_CARRIAGE_MOTOR_INVERTED);
		rightCarriageMotor.setInverted(Constants.RIGHT_CARRIAGE_MOTOR_INVERTED);

	}

	// cap motor speed
	public static double capSpeed(double speed) {
		speed = Math.min(Constants.MAX_MOTOR_SPEED, speed);
		speed = Math.max(Constants.MIN_MOTOR_SPEED, speed);
		return speed;
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

	public static VictorSP getLeftIntakeMotor() {
		return leftIntakeMotor;
	}

	public static VictorSP getRightIntakeMotor() {
		return rightIntakeMotor;
	}

	public static DoubleSolenoid getLeftArmFirstPneumatic() {
		return leftArmFirstPneumatic;
	}

	public static DoubleSolenoid getLeftArmSecondPneumatic() {
		return leftArmSecondPneumatic;
	}

	public static DoubleSolenoid getRightArmPneumatic() {
		return rightArmPneumatic;
	}

	// set speed of left intake motor
	public static void setLeftIntakeMotor(double speed) {
		leftIntakeMotor.set(capSpeed(speed));
	}

	// set speed of right intake motor
	public static void setRightIntakeMotor(double speed) {
		rightIntakeMotor.set(capSpeed(speed));
	}

	// set speed of left carriage motor
	public static void setLeftCarriageMotor(double speed) {
		leftCarriageMotor.set(capSpeed(speed));
	}

	// set speed of right carriage motor
	public static void setRightCarriageMotor(double speed) {
		rightCarriageMotor.set(capSpeed(speed));
	}

	// set left arm first pneumatic position
	public static void setLeftArmFirstPneumatic(DoubleSolenoid.Value value) {
		leftArmFirstPneumatic.set(value);
	}

	// set left arm second pneumatic position
	public static void setLeftArmSecondPneumatic(DoubleSolenoid.Value value) {
		leftArmSecondPneumatic.set(value);
	}

	// set right arm pneumatic position
	public static void setRightArmPneumatic(DoubleSolenoid.Value value) {
		rightArmPneumatic.set(value);
	}
}
