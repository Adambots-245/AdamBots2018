/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team245.robot;

import com.github.adambots.powerup2018.auton.AutonConstants;
import com.github.adambots.powerup2018.auton.Time;
import com.github.adambots.powerup2018.climb.Climb;
import com.github.adambots.powerup2018.controller.Gamepad;
import com.github.adambots.powerup2018.dash.Dash;
import com.github.adambots.powerup2018.drive.Drive;
import com.github.adambots.powerup2018.intake.Intake;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	private String positionSelected;
	private Command autoSelected;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		System.out.println("Got here");
		Dash.init();
		Actuators.init();
		Gamepad.init();
		Sensors.init();
		Intake.init();
		Drive.init();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString line to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		Sensors.zeroGyro();
		Time.init();
		positionSelected = Dash.getPositionSelected();
		autoSelected = Dash.getAutonSelected();
		autoSelected.start();
		System.out.println("Auto selected: " + autoSelected);

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
//		if(time.get() < AutonConstants.CROSS_BASELINE_TIME) {
//			Drive.autonDrive(0, AutonConstants.CROSS_BASELINE_SPEED, 0);
//		} else {
//			Drive.autonDrive(0, 0, 0);
//		}
		if (autoSelected != null) {
			System.out.println(autoSelected);
			autoSelected.start();
			Scheduler.getInstance().run();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Gamepad.update();
		Drive.mecDrive(Gamepad.primary.getLeftX(), Gamepad.primary.getLeftY(), Gamepad.primary.getRightX());

		Intake.resetEncoderOnLimitSwitch();

		Intake.setIntakeWheelsSpeed(Gamepad.secondary.getLeftY());
		Intake.toggleCarriageWheels(Gamepad.secondary.getLeftY(), Gamepad.secondary.getLB());
		Intake.armsPosition(Gamepad.secondary.getX(), Gamepad.secondary.getY(), Gamepad.secondary.getB());
		Intake.setCarriageLiftSpeed(Gamepad.secondary.getRightY(), Gamepad.secondary.getRB());

		System.out.println("lift position = [" + Actuators.getCarriageLiftMotorPosition() + "]");

		Climb.startClimbing(Gamepad.secondary.getRightTrigger());

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		Climb.reverseClimbing(Gamepad.secondary.getRightTrigger(), Gamepad.secondary.getLeftTrigger());
	}
}
