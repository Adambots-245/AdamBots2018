package com.github.adambots.powerup2018.drive;

import org.usfirst.frc.team245.robot.Actuators;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive {

	private static MecanumDrive robotDrive;

	// precondition: run Actuators.init()
	public static void init() {
		robotDrive = new MecanumDrive(Actuators.getLeftFrontMotor(), Actuators.getLeftRearMotor(),
				Actuators.getRightFrontMotor(), Actuators.getRightRearMotor());
	}

	// driving with Mecanum (input squared for smoother control)
	public static void mecDrive(double rightSpeed, double forwardSpeed, double zRotation) {
		robotDrive.driveCartesian(Actuators.sgnPow(rightSpeed, 2), Actuators.sgnPow(forwardSpeed, 2),
				Actuators.sgnPow(zRotation, 2));
	}

	// driving with field-centric Mecanum (input squared for smoother control)
	public static void mecDrive(double rightSpeed, double forwardSpeed, double zRotation, double gyroAngle) {
		robotDrive.driveCartesian(Actuators.sgnPow(rightSpeed, 2), Actuators.sgnPow(forwardSpeed, 2),
				Actuators.sgnPow(zRotation, 2), gyroAngle);
	}

	public static void autonDrive(double leftFrontSpeed, double rightFrontSpeed, double leftRearSpeed,
			double rightRearSpeed) {
		Actuators.setLeftFrontMotor(leftFrontSpeed);
		Actuators.setRightFrontMotor(rightFrontSpeed);
		Actuators.setLeftRearMotor(leftRearSpeed);
		Actuators.setRightRearMotor(rightRearSpeed);
	}

	public static void autonDrive(double rightSpeed, double forwardSpeed, double zRotation) {
		robotDrive.driveCartesian(rightSpeed, forwardSpeed, zRotation);
	}
}
