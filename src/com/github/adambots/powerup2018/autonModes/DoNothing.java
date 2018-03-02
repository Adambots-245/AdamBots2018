package com.github.adambots.powerup2018.autonModes;

import org.usfirst.frc.team245.robot.Constants;

import com.github.adambots.powerup2018.drive.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class DoNothing extends Command {

	public DoNothing() {
		// FINISHED!
	}

	@Override
	protected void initialize() {
		double STOP = Constants.STOP_MOTOR_SPEED;
		Drive.autonDrive(STOP, STOP, STOP, STOP);
	}

	@Override
	protected void execute() {

		System.out.println("DO NOTHING IS RUNNING");

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
