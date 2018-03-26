package com.github.adambots.powerup2018.autonModes;

import org.usfirst.frc.team245.robot.Constants;

import com.github.adambots.powerup2018.auton.AutonRoutine;
import com.github.adambots.powerup2018.auton.Time;
import com.github.adambots.powerup2018.drive.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class CrossBaseline extends AutonRoutine {

	private double timeToCross;
	private double percentSpeed;

	public CrossBaseline(double time, double percentSpeed) {
		this.timeToCross = time;
		this.percentSpeed = percentSpeed;
	}

	@Override
	public void initialize() {

	}

	@Override
	public void execute() {
		double time = Time.getTime();
		System.out.println("CROSS BASELINE IS RUNNING");
		try {
			if (time < timeToCross) {
				Drive.autonDrive(0, percentSpeed * Constants.MAX_MOTOR_SPEED, 0);
			} else {
				double stop = Constants.STOP_MOTOR_SPEED;
				Drive.autonDrive(stop, stop, stop, stop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	protected boolean isFinished() {
		return true;
	}

	
	protected void end() {

	}

	
	protected void interrupted() {

	}

}
