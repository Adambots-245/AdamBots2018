package com.github.adambots.powerup2018.smartDash;

import org.usfirst.frc.team245.robot.Actuators;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDash {
	
	public static void init() {
		CameraServer.getInstance().startAutomaticCapture();
	}
	
	public static boolean isMotorRunning(SpeedController motor) {
		double speed = motor.get();
		return Math.abs(speed) > 0;
	}
	
	public static void updateDash() {
		// SmartDashboard.putNumber("batteryPercentage", PowerDistributionPanel.getVoltage());
		SmartDashboard.putBoolean("rightFrontMotor" , isMotorRunning(Actuators.getRightFrontMotor()));
		SmartDashboard.putBoolean("rightRearMotor" , isMotorRunning(Actuators.getRightRearMotor()));
		SmartDashboard.putBoolean("leftFrontMotor" , isMotorRunning(Actuators.getLeftFrontMotor()));
		SmartDashboard.putBoolean("leftRearMotor" , isMotorRunning(Actuators.getLeftRearMotor()));
		// SmartDashboard.putData("camera", CameraServer.getInstance());
		// SmartDashboard.putData("carriageEncoder" , Encoder.getRaw());
	}
}