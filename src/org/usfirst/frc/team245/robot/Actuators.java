package org.usfirst.frc.team245.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
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
	private static TalonSRX carriageLiftMotor;
	private static TalonSRX climbMotor;
	
	// pneumatics
	private static DoubleSolenoid leftArmOpenPneumatic;
	private static DoubleSolenoid leftArmMidPneumatic;
	private static DoubleSolenoid rightArmOpenPneumatic;
	private static DoubleSolenoid rightArmMidPneumatic;

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
		carriageLiftMotor = new TalonSRX(Constants.CARRIAGE_LIFT_MOTOR_PORT);
		climbMotor = new TalonSRX(Constants.CLIMB_MOTOR_PORT);	
		
		//Brake Motors
		carriageLiftMotor.setNeutralMode(NeutralMode.Brake);		
		//Coast Motors
		rightFrontMotor.setNeutralMode(NeutralMode.Coast);
		rightRearMotor.setNeutralMode(NeutralMode.Coast);
		leftFrontMotor.setNeutralMode(NeutralMode.Coast);
		leftRearMotor.setNeutralMode(NeutralMode.Coast);

		// initialize pneumatics
		leftArmOpenPneumatic = new DoubleSolenoid(Constants.LEFT_ARM_OPEN_PNEUMATIC_FORWARD_PORT,
				Constants.LEFT_ARM_OPEN_PNEUMATIC_REVERSE_PORT);
		leftArmMidPneumatic = new DoubleSolenoid(Constants.LEFT_ARM_MID_PNEUMATIC_FORWARD_PORT,
				Constants.LEFT_ARM_MID_PNEUMATIC_REVERSE_PORT);
		rightArmOpenPneumatic = new DoubleSolenoid(Constants.RIGHT_ARM_OPEN_PNEUMATIC_FORWARD_PORT,
				Constants.RIGHT_ARM_OPEN_PNEUMATIC_REVERSE_PORT);
		rightArmMidPneumatic = new DoubleSolenoid(Constants.RIGHT_ARM_MID_PNEUMATIC_FORWARD_PORT,
				Constants.RIGHT_ARM_MID_PNEUMATIC_REVERSE_PORT);

		// invert motor controllers
		rightFrontMotor.setInverted(Constants.RIGHT_FRONT_DRIVE_MOTOR_INVERTED);
		rightRearMotor.setInverted(Constants.RIGHT_REAR_DRIVE_MOTOR_INVERTED);
		leftFrontMotor.setInverted(Constants.LEFT_FRONT_DRIVE_MOTOR_INVERTED);
		leftRearMotor.setInverted(Constants.LEFT_REAR_DRIVE_MOTOR_INVERTED);
		leftIntakeMotor.setInverted(Constants.LEFT_INTAKE_MOTOR_INVERTED);
		rightIntakeMotor.setInverted(Constants.RIGHT_INTAKE_MOTOR_INVERTED);
		leftCarriageMotor.setInverted(Constants.LEFT_CARRIAGE_MOTOR_INVERTED);
		rightCarriageMotor.setInverted(Constants.RIGHT_CARRIAGE_MOTOR_INVERTED);
		
		carriageLiftMotor.enableCurrentLimit(false);
		//carriageLiftMotor.configPeakCurrentLimit(5, 100);
		//carriageLiftMotor.configContinuousCurrentLimit(5, 100);

		// set talon neutral modes
		rightFrontMotor.setNeutralMode(Constants.RIGHT_FRONT_DRIVE_MOTOR_NEUTRAL);
		rightRearMotor.setNeutralMode(Constants.RIGHT_REAR_DRIVE_MOTOR_NEUTRAL);
		leftFrontMotor.setNeutralMode(Constants.LEFT_FRONT_DRIVE_MOTOR_NEUTRAL);
		leftRearMotor.setNeutralMode(Constants.LEFT_REAR_DRIVE_MOTOR_NEUTRAL);

	}

	// cap motor speed
	public static double capSpeed(double speed) {
		speed = Math.min(Constants.MAX_MOTOR_SPEED, speed);
		speed = Math.max(Constants.MIN_MOTOR_SPEED, speed);
		return speed;
	}

	// raise value to power but keep sign
	public static double sgnPow(double x, double pow) {
		return Math.signum(x) * Math.pow(Math.abs(x), pow);
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

	public static TalonSRX getCarriageLiftMotor() {
		return carriageLiftMotor;
	}

	public static int getCarriageLiftMotorPosition() {
		return carriageLiftMotor.getSelectedSensorPosition(Constants.CARRIAGE_LIFT_ENCODER_SENSOR);
	}
	
	public static TalonSRX getClimbMotor() {
		return climbMotor;
	}

	public static DoubleSolenoid getLeftArmOpenPneumatic() {
		return leftArmOpenPneumatic;
	}

	public static DoubleSolenoid getLeftArmMidPneumatic() {
		return leftArmMidPneumatic;
	}

	public static DoubleSolenoid getRightArmOpenPneumatic() {
		return rightArmOpenPneumatic;
	}

	public static DoubleSolenoid getRightArmMidPnuematic() {
		return rightArmMidPneumatic;
	}

	// set speed of right front drive motor
	public static void setRightFrontMotor(double speed) {
		rightFrontMotor.set(ControlMode.PercentOutput, capSpeed(speed));
	}

	// set speed of right rear drive motor
	public static void setRightRearMotor(double speed) {
		rightRearMotor.set(ControlMode.PercentOutput, capSpeed(speed));
	}

	// set speed of left front drive motor
	public static void setLeftFrontMotor(double speed) {
		leftFrontMotor.set(ControlMode.PercentOutput, capSpeed(speed));
	}

	// set speed of left rear drive motor
	public static void setLeftRearMotor(double speed) {
		leftRearMotor.set(ControlMode.PercentOutput, capSpeed(speed));
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
	
	// set speed of carriage lift motor
	public static void setCarriageLiftMotorSpeed(double speed) {
		carriageLiftMotor.set(ControlMode.PercentOutput , capSpeed(speed));
	}

	// set speed of climb motor
	public static void setClimbMotorSpeed(double speed) {
		climbMotor.set(ControlMode.PercentOutput, capSpeed(speed));
	}
		
	// set left arm first pneumatic position
	public static void setLeftArmOpenPneumatic(DoubleSolenoid.Value value) {
		leftArmOpenPneumatic.set(value);
		System.out.println("LEFT ARM OPEN PNEUMATIC: " + value);
	}

	// set left arm second pneumatic position
	public static void setLeftArmMidPneumatic(DoubleSolenoid.Value value) {
		leftArmMidPneumatic.set(value);
		System.out.println("LEFT ARM MID PNEUMATIC: " + value);
	}

	// set right arm first pneumatic position
	public static void setRightArmOpenPneumatic(DoubleSolenoid.Value value) {
		rightArmOpenPneumatic.set(value);
		System.out.println("RIGHT ARM OPEN PNEUMATIC: " + value);
	}

	// set right arm second pneumatic position
	public static void setRightArmMidPneumatic(DoubleSolenoid.Value value) {
		rightArmMidPneumatic.set(value);
		System.out.println("RIGHT ARM MID PNEUMATIC: " + value);
	}
	
}
