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

	public static void mecDrive(double ySpeed, double xSpeed, double zRotation) {
		robotDrive.driveCartesian(ySpeed, xSpeed, zRotation);
	}

}
