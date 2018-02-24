package com.github.adambots.powerup2018.smartDash;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Sensors;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Solenoid;
public class SmartDash {

	public static void init() {
		CameraServer.getInstance().startAutomaticCapture();
	}

	public static boolean isMotorRunning(SpeedController motor) {
		double speed = motor.get();
		return Math.abs(speed) > 0;
	}

	public static double Voltage() {
		PowerDistributionPanel pdp = Sensors.getPowerDistributionPanel();
		double voltage = pdp.getVoltage();
		return voltage;
	}


	public static void Currents() {
		PowerDistributionPanel pdp = Sensors.getPowerDistributionPanel();
		int numChannels = 16;
		for (int i=0; i<numChannels ; i++) {
			double current = pdp.getCurrent(i);
			SmartDashboard.putNumber("Current " + i , current);
		}
	}	
	public static double getMatchTime() {
		DriverStation ds = DriverStation.getInstance();
		double time = ds.getMatchTime();
		return time;
	}
	public static void isSolenoidOpen() {
		DoubleSolenoid s = Actuators.getLeftArmOpenPneumatic();
		DoubleSolenoid.Value state = s.get();
		if (state == DoubleSolenoid.Value.kForward) {
			SmartDashboard.putBoolean("open" , true );
			if (state == DoubleSolenoid.Value.kReverse) {
				SmartDashboard.putBoolean("close", false);
			}
		}
		DoubleSolenoid d = Actuators.getRightArmOpenPneumatic();
		DoubleSolenoid.Value state2 = d.get();
		if (state2 == DoubleSolenoid.Value.kForward) {
			SmartDashboard.putBoolean("open" , true );
			if (state2 == DoubleSolenoid.Value.kReverse) {
				SmartDashboard.putBoolean("close", false);
			}
		}
	}

	public static void updateDash() {
		Currents();
		isSolenoidOpen();
		SmartDashboard.putNumber("Voltage", Voltage());
		SmartDashboard.putBoolean("rightFrontMotor" , isMotorRunning(Actuators.getRightFrontMotor()));
		SmartDashboard.putBoolean("rightRearMotor" , isMotorRunning(Actuators.getRightRearMotor()));
		SmartDashboard.putBoolean("leftFrontMotor" , isMotorRunning(Actuators.getLeftFrontMotor()));
		SmartDashboard.putBoolean("leftRearMotor" , isMotorRunning(Actuators.getLeftRearMotor()));
		SmartDashboard.putData("camera", (Sendable) CameraServer.getInstance());
		SmartDashboard.putBoolean("photoEyeStatus" , Sensors.getPhotoEyeValue());
		SmartDashboard.putNumber("encoderValue" , Actuators.getCarriageLiftMotorPosition());
		SmartDashboard.putNumber("gyroAngle" , Sensors.getAngle());
		SmartDashboard.putNumber("matchTime" , getMatchTime());
		SmartDashboard.putBoolean("limitSwitch" , Sensors.getLimitSwitchValue());
	}
}