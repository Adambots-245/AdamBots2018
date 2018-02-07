package com.github.adambots.powerup2018.intake;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

public class Intake {

	// set the speed of the intake wheels
	public static void setIntakeWheelsSpeed(double speed) {
		Actuators.setLeftIntakeMotor(speed);
		Actuators.setRightIntakeMotor(speed);
	}

	// set the speed of the carriage wheels
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

	// toggle left pneumatic arm between 3 states
	// TODO: Check behavior of pressing button before teleop
	public static void toggleLeftArm(int buttonPresses) {
		int position = buttonPresses % 3;
		switch (position) {
		case 0:
			Actuators.setLeftArmFirstPneumatic(Constants.PNEUMATIC_REVERSE);
			Actuators.setLeftArmSecondPneumatic(Constants.PNEUMATIC_REVERSE);
			break;
		case 1:
			Actuators.setLeftArmFirstPneumatic(Constants.PNEUMATIC_FORWARD);
			Actuators.setLeftArmSecondPneumatic(Constants.PNEUMATIC_REVERSE);
			break;
		case 2:
			Actuators.setLeftArmFirstPneumatic(Constants.PNEUMATIC_FORWARD);
			Actuators.setLeftArmSecondPneumatic(Constants.PNEUMATIC_FORWARD);
			break;
		}
	}

	// toggle right pneumatic arm
	public static void toggleRightArm(int buttonPresses) {
		int position = buttonPresses % 2;
		switch (position) {
		case 0:
			Actuators.setRightArmPneumatic(Constants.PNEUMATIC_FORWARD);
			break;
		case 1:
			Actuators.setRightArmPneumatic(Constants.PNEUMATIC_REVERSE);
			break;
		}
	}

}
