package com.github.adambots.powerup2018.autonModes;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.powerup2018.auton.AutonConstants;
import com.github.adambots.powerup2018.dash.Dash;
import com.github.adambots.powerup2018.drive.Drive;
import com.github.adambots.powerup2018.field.Field;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Switch extends Command {

	private String position;
	private char switchPosition;
	private Timer timer;
	private char turn = Character.MIN_VALUE;

	public Switch() {
		// FINISHED!
	}

	public Switch(char turn) {
		this.turn = turn;
	}

	@Override
	protected void initialize() {
		position = Dash.getPositionSelected();
		switchPosition = Field.getScale();
		if (turn != Character.MIN_VALUE) {
			if (position.equalsIgnoreCase(String.valueOf(switchPosition))) {
				turn = 'S';
			} else {
				turn = switchPosition;
			}
		}
		timer = new Timer();
	}

	@Override
	protected void execute() {
		double time = timer.get();
		System.out.println("SWITCH IS RUNNING");
		if (time <= AutonConstants.SWITCH_STRAIGHT_END_TIME) {
			double speed = AutonConstants.SWITCH_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
		} else if (time < (AutonConstants.SWITCH_STRAIGHT_END_TIME + AutonConstants.SWITCH_TURN_TIME) && turn == 'S') {
			double delta = AutonConstants.SWITCH_GYRO_POSITION - Sensors.getGyroAngle();
			double leftSpeed, rightSpeed;
			if (position.equalsIgnoreCase("L")) {
				leftSpeed = -delta;
				rightSpeed = delta;
			} else if (position.equalsIgnoreCase("R")) {
				leftSpeed = delta;
				rightSpeed = -delta;
			} else {
				leftSpeed = Constants.STOP_MOTOR_SPEED;
				rightSpeed = Constants.STOP_MOTOR_SPEED;
			}
			Drive.autonDrive(leftSpeed, rightSpeed, leftSpeed, rightSpeed);
		} else if (turn == 'S') {
			Actuators.setLeftCarriageMotor(AutonConstants.SWITCH_CARRIAGE_WHEEL_SPEED);
			Actuators.setRightCarriageMotor(-AutonConstants.SWITCH_CARRIAGE_WHEEL_SPEED);
		}

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		Drive.autonDrive(0, 0, 0, 0);
		Actuators.setCarriageLiftMotorSpeed(0);

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
