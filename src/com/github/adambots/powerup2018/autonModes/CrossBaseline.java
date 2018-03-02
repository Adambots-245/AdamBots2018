package com.github.adambots.powerup2018.autonModes;

import org.usfirst.frc.team245.robot.Constants;

import com.github.adambots.powerup2018.drive.Drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class CrossBaseline extends Command {

	private Timer time;
	private double timeToCross;
	private double percentSpeed;

	public CrossBaseline(double time, double percentSpeed) {
		this.timeToCross = time;
		this.percentSpeed = percentSpeed;
	}

	@Override
	protected void initialize() {
		time = new Timer();
		time.start();
	}

	@Override
	protected void execute() {
		System.out.println("CROSS BASELINE IS RUNNING");
		try {
			if (time.get() < timeToCross) {
				Drive.autonDrive(0, percentSpeed * Constants.MAX_MOTOR_SPEED, 0);
			} else {
				double stop = Constants.STOP_MOTOR_SPEED;
				Drive.autonDrive(stop, stop, stop, stop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		time.stop();
	}

	@Override
	protected void interrupted() {

	}

}
