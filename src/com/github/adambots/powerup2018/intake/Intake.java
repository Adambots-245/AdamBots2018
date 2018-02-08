package com.github.adambots.powerup2018.intake;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Intake {

	// initial conditions
	public static void init() {

	}

	// set the speed of the intake wheels
	public static void setIntakeWheelsSpeed(double speed) {
		Actuators.setLeftIntakeMotor(speed);
		Actuators.setRightIntakeMotor(speed);
	}

	// set both first arm pneumatics
	private static void setArmsFirstPneumatic(DoubleSolenoid.Value value) {
		Actuators.setLeftArmFirstPneumatic(value);
		Actuators.setRightArmFirstPneumatic(value);
	}

	// set both second arm pneumatics
	private static void setArmsSecondPneumatic(DoubleSolenoid.Value value) {
		Actuators.setLeftArmSecondPneumatic(value);
		Actuators.setRightArmSecondPneumatic(value);
	}

	// set arm pneumatic position to position from Constants class
	public static void setArmsPosition(int constantPosition) {
		switch (constantPosition) {
		case 1:
			Intake.setArmsFirstPneumatic(Constants.PNEUMATIC_REVERSE);
			Intake.setArmsSecondPneumatic(Constants.PNEUMATIC_REVERSE);
			break;
		case 2:
			Intake.setArmsFirstPneumatic(Constants.PNEUMATIC_FORWARD);
			Intake.setArmsSecondPneumatic(Constants.PNEUMATIC_REVERSE);
			break;
		case 3:
			Intake.setArmsFirstPneumatic(Constants.PNEUMATIC_FORWARD);
			Intake.setArmsSecondPneumatic(Constants.PNEUMATIC_FORWARD);
			break;
		}
	}

	// toggle left pneumatic arm between 3 states
	// TODO: Check behavior of pressing button before teleop
	public static void armsPosition(boolean inButton, boolean midButton, boolean outButton) {
		if (inButton) {
			Intake.setArmsPosition(Constants.ARMS_IN);
		} else if (midButton) {
			Intake.setArmsPosition(Constants.ARMS_MID);
		} else if (outButton) {
			Intake.setArmsPosition(Constants.ARMS_OUT);
		}
	}

	// toggle the carriage wheels
	public static void toggleCarriageWheels(boolean intakeButton, boolean outtakeButton) {
		double speed;
		if (intakeButton) {
			speed = Constants.CARRIAGE_MOTOR_INTAKE_SPEED;
		} else if (outtakeButton) {
			speed = Constants.CARRIAGE_MOTOR_OUTTAKE_SPEED;
		} else {
			speed = Constants.STOP_MOTOR_SPEED;
		}
		Actuators.setLeftCarriageMotor(speed);
		Actuators.setRightCarriageMotor(speed);
	}

	// control the carriage lift
	public static void setCarriageLiftSpeed(double speed) {
		Actuators.setCarriageLiftMotor(speed);
	}

}
