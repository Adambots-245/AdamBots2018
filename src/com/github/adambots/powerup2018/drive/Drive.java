package com.github.adambots.powerup2018.drive;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class Drive {

	public static void init() {

	}

	private static double capSpeed(double speed) {
		speed = Math.min(Constants.MAX_MOTOR_SPEED, speed);
		speed = Math.max(Constants.MIN_MOTOR_SPEED, speed);
		return speed;
	}

	public static void mecDrive(double ySpeed, double xSpeed, double zRotation) {

		double leftFrontSpeed = ySpeed - zRotation - xSpeed;
		double rightFrontSpeed = -(ySpeed + zRotation + xSpeed);
		double leftRearSpeed = ySpeed - zRotation + xSpeed;
		double rightRearSpeed = -(ySpeed + zRotation - xSpeed);

		leftFrontSpeed = capSpeed(leftFrontSpeed);
		rightFrontSpeed = capSpeed(rightFrontSpeed);
		leftRearSpeed = capSpeed(leftRearSpeed);
		rightRearSpeed = capSpeed(rightRearSpeed);

		Actuators.getLeftFrontMotor().set(ControlMode.PercentOutput, leftFrontSpeed);
		Actuators.getRightFrontMotor().set(ControlMode.PercentOutput, rightFrontSpeed);
		Actuators.getLeftRearMotor().set(ControlMode.PercentOutput, leftRearSpeed);
		Actuators.getRightRearMotor().set(ControlMode.PercentOutput, rightRearSpeed);
	}

}
