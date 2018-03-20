package com.github.adambots.powerup2018.autonModes;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.powerup2018.auton.AutonConstants;
import com.github.adambots.powerup2018.auton.Time;
import com.github.adambots.powerup2018.dash.Dash;
import com.github.adambots.powerup2018.drive.Drive;
import com.github.adambots.powerup2018.field.Field;

import edu.wpi.first.wpilibj.command.Command;

public class Switch_Scale extends Command {

	private String position;
	private char switchPosition;
	private char scalePosition;
	private char turn = Character.MIN_VALUE;
	
	public Switch_Scale() {
		// FINISHED!
	}

	@Override
	protected void initialize() {
		position = Dash.getPositionSelected();
		switchPosition = Field.getOwnSwitch();
		scalePosition = Field.getScale();
		if (position.equalsIgnoreCase(String.valueOf(switchPosition))) {
			turn = switchPosition == 'L' ? 'L' : 'R';
		} else {
			turn = Character.MIN_VALUE;
		}
	}

	@Override
	protected void execute() {
		System.out.println(Sensors.getGyroAngle());
		double time = Time.getTime();
		System.out.println("SWITCH_SCALE IS RUNNING");
		System.out.println(time);
		/*if(turn == Character.MIN_VALUE && time <= AutonConstants.SWITCH_MIDDLE_STRAIGHT_TIME) {
			double speed = AutonConstants.SWITCH_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
		} else*/ if (time <= AutonConstants.SWITCH_STRAIGHT_END_TIME) {
			double speed = AutonConstants.SWITCH_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
			System.out.println("Running straight");
		} else if (time < (AutonConstants.SWITCH_STRAIGHT_END_TIME + AutonConstants.SWITCH_TURN_TIME)
				&& turn != Character.MIN_VALUE) {
			double leftSpeed, rightSpeed;
			if (position.equalsIgnoreCase("L")) {
				System.out.println("ignorecase L");
				leftSpeed = AutonConstants.SWITCH_TURN_SPEED;
				rightSpeed = AutonConstants.SWITCH_TURN_SPEED;
			} else if (position.equalsIgnoreCase("R")) {
				System.out.println("ignorecase R");
				leftSpeed = AutonConstants.SWITCH_TURN_SPEED;
				rightSpeed = AutonConstants.SWITCH_TURN_SPEED;
			} else {
				System.out.println("else L or R");
				leftSpeed = Constants.STOP_MOTOR_SPEED;
				rightSpeed = Constants.STOP_MOTOR_SPEED;
			}
			if (Math.abs(Sensors.getGyroAngle()) < AutonConstants.SWITCH_GYRO_POSITION && position.equalsIgnoreCase("L")) {
				Drive.autonDrive(leftSpeed, rightSpeed, leftSpeed, rightSpeed);
			}else if (Math.abs(Sensors.getGyroAngle()) < AutonConstants.SWITCH_GYRO_POSITION) { 
				System.out.println("Line 66 running");
				Drive.autonDrive(-leftSpeed, -rightSpeed, -leftSpeed, -rightSpeed);
			}else {
				Drive.autonDrive(Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED);
			}
		} else if (time < (AutonConstants.SWITCH_STRAIGHT_END_TIME + AutonConstants.SWITCH_TURN_TIME
				+ AutonConstants.SWITCH_STRAIGHT_SPEED) && turn != Character.MIN_VALUE) {
			double speed = AutonConstants.SWITCH_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
			System.out.println("Running straight 2.0");
		} else if (turn != Character.MIN_VALUE) {
			Drive.autonDrive(Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED);
			if(time < (AutonConstants.SWITCH_OUTTAKE_TIME + AutonConstants.SWITCH_STRAIGHT_END_TIME + AutonConstants.SWITCH_TURN_TIME)) {
				Actuators.setLeftCarriageMotor(AutonConstants.SWITCH_CARRIAGE_WHEEL_SPEED);
				Actuators.setRightCarriageMotor(-AutonConstants.SWITCH_CARRIAGE_WHEEL_SPEED);
			}
		 /*else if (turn == Character.MIN_VALUE) {
			if (position.equalsIgnoreCase(String.valueOf(scalePosition))) {
				turn = scalePosition == 'L' ? 'L' : 'R';
			} 
			System.out.println("SWITCH_SCALE IS RUNNING");
			System.out.println(time);
			if (time <= AutonConstants.SWITCH_STRAIGHT_END_TIME) {
				double speed = AutonConstants.SWITCH_SPEED;
				double stop = Constants.STOP_MOTOR_SPEED;
				Drive.autonDrive(stop, speed, stop);
			System.out.println("Running straight");
			Actuators.setCarriageLiftMotorSpeed(AutonConstants.SCALE_ELEVATOR_SPEED);
		*/} else {
			System.out.println("Turn is " + turn);
		}
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// System.out.println("end, (0,0,0,0)");
		// Drive.autonDrive(0, 0, 0, 0);
		// Actuators.setCarriageLiftMotorSpeed(0);

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
