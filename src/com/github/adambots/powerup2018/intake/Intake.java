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
}
