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

	private static double sgnSquare(double x) {
		return Math.signum(x) * Math.pow(x, 2);
	}

	// driving with Mecanum (input squared for smoother control)
	public static void mecDrive(double rightSpeed, double forwardSpeed, double zRotation) {
		robotDrive.driveCartesian(sgnSquare(rightSpeed), sgnSquare(forwardSpeed), sgnSquare(zRotation));
	}

	// driving with field-centric Mecanum (input squared for smoother control)
	public static void mecDrive(double rightSpeed, double forwardSpeed, double zRotation, double gyroAngle) {
		robotDrive.driveCartesian(sgnSquare(rightSpeed), sgnSquare(forwardSpeed), sgnSquare(zRotation), gyroAngle);
	}

}
