package com.github.adambots.powerup2018.dash;

import org.usfirst.frc.team245.robot.Actuators;

import com.github.adambots.powerup2018.auton.AutonConstants;
import com.github.adambots.powerup2018.auton.AutonRoutine;
import com.github.adambots.powerup2018.autonModes.CrossBaseline;
import com.github.adambots.powerup2018.autonModes.DoNothing;
import com.github.adambots.powerup2018.autonModes.Switch;
import com.github.adambots.powerup2018.autonModes.Switch_Scale;
import com.github.adambots.powerup2018.field.Field;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dash {

	private static SendableChooser<String> positionChooser = new SendableChooser<String>();
	private static SendableChooser<AutonRoutine> autonChooser = new SendableChooser<AutonRoutine>();

	public static void init() {
		putMatchTime();
		putPositionChooser();
		putAutonChooser();
		CameraServer.getInstance().startAutomaticCapture().setResolution(960, 720);
	}

	public static void putPositionChooser() {
		positionChooser.addDefault("None", null);
		positionChooser.addObject("Left", "L");
		positionChooser.addObject("Right", "R");
		positionChooser.addObject("Middle", "M");
		SmartDashboard.putData("Position on Field", positionChooser);
	}
	
	public static void putAutonChooser() {
		autonChooser.addDefault("Do Nothing", new DoNothing());
		autonChooser.addObject("Cross Baseline",
				new CrossBaseline(AutonConstants.CROSS_BASELINE_TIME, AutonConstants.CROSS_BASELINE_SPEED));
		autonChooser.addObject("Switch", new Switch());
		autonChooser.addObject("Switch/Scale", new Switch_Scale());
		SmartDashboard.putData("Auton Choices", autonChooser);
	}

	public static String getPositionSelected() {
		return positionChooser.getSelected();
	}

	public static AutonRoutine getAutonSelected() {
		return autonChooser.getSelected();
	}
	public static void putEncoderValue(){
		SmartDashboard.putNumber("Encoder Value", Actuators.getCarriageLiftMotorPosition());
	}
	public static void putMatchTime() {
		SmartDashboard.putNumber("Match Time", Field.getMatchTime());
	}
	
	
}
