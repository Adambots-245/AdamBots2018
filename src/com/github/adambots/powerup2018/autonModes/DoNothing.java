package com.github.adambots.powerup2018.autonModes;

import org.usfirst.frc.team245.robot.Constants;

import com.github.adambots.powerup2018.auton.AutonRoutine;
import com.github.adambots.powerup2018.drive.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class DoNothing extends AutonRoutine {

	public DoNothing() {
		// FINISHED!
	}

	@Override
	public void initialize() {
		double STOP = Constants.STOP_MOTOR_SPEED;
		Drive.autonDrive(STOP, STOP, STOP, STOP);
	}

	@Override
	public void execute() {

		System.out.println("DO NOTHING IS RUNNING");

	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	
	protected void end() {
		// TODO Auto-generated method stub

	}

	
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
