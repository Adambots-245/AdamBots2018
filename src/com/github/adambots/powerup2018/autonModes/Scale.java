package com.github.adambots.powerup2018.autonModes;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.powerup2018.auton.AutonConstants;
import com.github.adambots.powerup2018.auton.AutonRoutine;
//import com.github.adambots.powerup2018.auton.Play;
import com.github.adambots.powerup2018.auton.Time;
import com.github.adambots.powerup2018.dash.Dash;
import com.github.adambots.powerup2018.drive.Drive;
import com.github.adambots.powerup2018.field.Field;
import com.github.adambots.powerup2018.intake.Intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Scale extends AutonRoutine {

	double time;
	private String position;
	private char switchPosition;
	private char scalePosition;
	private char switchTurn = Character.MIN_VALUE;
	private char scaleTurn = Character.MIN_VALUE;

	public Scale() {

	}

	public void initialize() {
		Intake.setArmsPosition(Constants.ARMS_IN);
		position = Dash.getPositionSelected();
		Field.getPosition();
		switchPosition = Field.getOwnSwitch();
		scalePosition = Field.getScale();
		if (position.equalsIgnoreCase(String.valueOf(switchPosition))) {
			switchTurn = switchPosition == 'L' ? 'L' : 'R';
		} else {
			switchTurn = Character.MIN_VALUE;
		}
		if (position.equalsIgnoreCase(String.valueOf(scalePosition))) {
			scaleTurn = scalePosition == 'L' ? 'L' : 'R';
		} else {
			scaleTurn = Character.MIN_VALUE;
		}
		System.out.println("Field is" + scalePosition);
	
		//scaleTurn = position.charAt(0);
				
		}
	

	public void execute() {
		System.out.println(Sensors.getGyroAngle());
		double time = Time.getTime();
		System.out.println("SWITCH_SCALE IS RUNNING");
		System.out.println(time);
		/*
		 * if(turn == Character.MIN_VALUE && time <=
		 * AutonConstants.SWITCH_MIDDLE_STRAIGHT_TIME) { double speed =
		 * AutonConstants.SWITCH_SPEED; double stop = Constants.STOP_MOTOR_SPEED;
		 * Drive.autonDrive(stop, speed, stop); } else
		 */
		// switch start
		// cross baseline start
	//	if (time <= AutonConstants.PNEUMATIC_WAIT_TIME) {
		//	double stop = Constants.STOP_MOTOR_SPEED;
			//Drive.autonDrive(stop, stop, stop);
			//System.out.println("Waiting");
			
		//}
		if (time <= AutonConstants.PNEUMATIC_WAIT_TIME + AutonConstants.SWITCH_STRAIGHT_END_TIME) {
			double speed = AutonConstants.SWITCH_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
			System.out.println("Running straight");
			// cross baseline end
		}
		// start scale
		// start scale further straight
		else if (time <= AutonConstants.PNEUMATIC_WAIT_TIME + AutonConstants.SCALE_STRAIGHT_END_TIME && scaleTurn != Character.MIN_VALUE) {
			double speed = AutonConstants.SWITCH_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
			double liftSpeed = AutonConstants.SCALE_ELEVATOR_LOWER_SPEED;
			Intake.setArmsPosition(Constants.ARMS_OUT);
			Intake.setCarriageLiftSpeed(liftSpeed, false);
			System.out.println("Lowering elevator");
			System.out.println("Extra scale straight");
		}
		// start scale turn
		else if (time < (AutonConstants.PNEUMATIC_WAIT_TIME  + AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME)
				&& scaleTurn != Character.MIN_VALUE) {
			double leftSpeed, rightSpeed;
			if (position.equalsIgnoreCase("L")) {
				System.out.println("ignorecase L");
				leftSpeed = AutonConstants.SCALE_TURN_SPEED;
				rightSpeed = AutonConstants.SCALE_TURN_SPEED;
			} else if (position.equalsIgnoreCase("R")) {
				System.out.println("ignorecase R");
				leftSpeed = AutonConstants.SCALE_TURN_SPEED;
				rightSpeed = AutonConstants.SCALE_TURN_SPEED;
			} else {
				System.out.println("else L or R");
				leftSpeed = Constants.STOP_MOTOR_SPEED;
				rightSpeed = Constants.STOP_MOTOR_SPEED;
			}
			if (Math.abs(Sensors.getGyroAngle()) < AutonConstants.SCALE_GYRO_POSITION
					&& position.equalsIgnoreCase("L")) {
				Drive.autonDrive(leftSpeed, rightSpeed, leftSpeed, rightSpeed);
			} else if (Math.abs(Sensors.getGyroAngle()) < AutonConstants.SCALE_GYRO_POSITION) {
				System.out.println("Turning");
				Drive.autonDrive(-leftSpeed, -rightSpeed, -leftSpeed, -rightSpeed);
			} else {
				Drive.autonDrive(Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED);
			}

			if (Math.abs(Actuators.getCarriageLiftMotorPosition()) < 61000) {
				double liftSpeed = AutonConstants.SCALE_ELEVATOR_RAISE_SPEED;
				Intake.setCarriageLiftSpeed(liftSpeed, false);
				// Actuators.setCarriageLiftMotorSpeed(liftSpeed);
			} else {
				double liftSpeed = Constants.STOP_MOTOR_SPEED;
				Intake.setCarriageLiftSpeed(liftSpeed, false);

			}
			System.out.println("raising elevator");
			// start scale reverse (drive back toward field edge)
		} else if (time < (AutonConstants.PNEUMATIC_WAIT_TIME + AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME
				+ AutonConstants.SCALE_BACK_TIME) && scaleTurn != Character.MIN_VALUE) {
			double speed = AutonConstants.SCALE_BACK_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
			System.out.println("Running straight back");

			if (Math.abs(Actuators.getCarriageLiftMotorPosition()) < 61000) {
				double liftSpeed = AutonConstants.SCALE_ELEVATOR_RAISE_SPEED;
				Intake.setCarriageLiftSpeed(liftSpeed, false);
				// Actuators.setCarriageLiftMotorSpeed(liftSpeed);
			} else {
				double liftSpeed = Constants.STOP_MOTOR_SPEED;
				Intake.setCarriageLiftSpeed(liftSpeed, false);

			}
			System.out.println("raising elevator");
		}
		// end scale reverse

		/*
		 * //start lower elevator else if (time <
		 * (AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME +
		 * AutonConstants.SCALE_BACK_TIME + AutonConstants.SCALE_ELEVATOR_LOWER_TIME) &&
		 * scaleTurn != Character.MIN_VALUE) { double liftSpeed =
		 * AutonConstants.SCALE_ELEVATOR_LOWER_SPEED;
		 * Intake.setArmsPosition(Constants.ARMS_OUT);
		 * Intake.setCarriageLiftSpeed(liftSpeed, false);
		 * //Actuators.setLeftArmMidPneumatic(DoubleSolenoid.Value.kForward);
		 * //Actuators.setRightArmMidPneumatic(DoubleSolenoid.Value.kForward);
		 * //Actuators.setCarriageLiftMotorSpeed(-liftSpeed); } //end lower elevator
		 */

		/*
		 * //start raise elevator else if (time <
		 * (AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME +
		 * AutonConstants.SCALE_BACK_TIME + AutonConstants.SCALE_ELEVATOR_RAISE_TIME) &&
		 * scaleTurn != Character.MIN_VALUE) { if
		 * (Math.abs(Actuators.getCarriageLiftMotorPosition()) < 64000) { double
		 * liftSpeed = AutonConstants.SCALE_ELEVATOR_RAISE_SPEED;
		 * Intake.setCarriageLiftSpeed(liftSpeed, false);
		 * //Actuators.setCarriageLiftMotorSpeed(liftSpeed); } else { double liftSpeed =
		 * Constants.STOP_MOTOR_SPEED; Intake.setCarriageLiftSpeed(liftSpeed, false);
		 * 
		 * } System.out.println("raising elevator"); } //end raise elevator
		 */

		// start drive to scale after reversing
		else if (time < (AutonConstants.PNEUMATIC_WAIT_TIME + AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME
				+ AutonConstants.SCALE_BACK_TIME + AutonConstants.SCALE_FORWARD_TIME)
				&& scaleTurn != Character.MIN_VALUE) {
			double speed = AutonConstants.SCALE_FORWARD_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
			System.out.println("driving to scale after reversing");

			if (Math.abs(Actuators.getCarriageLiftMotorPosition()) < 64000) {
				double liftSpeed = AutonConstants.SCALE_ELEVATOR_RAISE_SPEED;
				Intake.setCarriageLiftSpeed(liftSpeed, false);
				// Actuators.setCarriageLiftMotorSpeed(liftSpeed);
			} else {
				double liftSpeed = Constants.STOP_MOTOR_SPEED;
				Intake.setCarriageLiftSpeed(liftSpeed, false);

			}
			System.out.println("raising elevator");
		}
		// end drive to scale after reversing
		// outtake cube
		else if (time < (AutonConstants.PNEUMATIC_WAIT_TIME + AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME
				+ AutonConstants.SCALE_BACK_TIME + AutonConstants.SCALE_FORWARD_TIME
				+ AutonConstants.SCALE_OUTTAKE_TIME) && scaleTurn != Character.MIN_VALUE) {
			Drive.autonDrive(Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED);
			if (time > (AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME
					+ AutonConstants.SCALE_BACK_TIME + AutonConstants.SCALE_FORWARD_TIME)) {
				Actuators.setLeftCarriageMotor(AutonConstants.SCALE_CARRIAGE_WHEEL_SPEED);
				Actuators.setRightCarriageMotor(-AutonConstants.SCALE_CARRIAGE_WHEEL_SPEED);
			}
		} else if (time < (AutonConstants.PNEUMATIC_WAIT_TIME + AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME
				+ AutonConstants.SCALE_BACK_TIME + AutonConstants.SCALE_FORWARD_TIME + AutonConstants.SCALE_OUTTAKE_TIME
				+ AutonConstants.SCALE_END_BACK_TIME) && scaleTurn != Character.MIN_VALUE) {
			double speed = AutonConstants.SCALE_BACK_SPEED;
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, speed, stop);
			System.out.println("Running straight back");
		} else if (time < (AutonConstants.PNEUMATIC_WAIT_TIME + AutonConstants.SCALE_STRAIGHT_END_TIME + AutonConstants.SCALE_TURN_TIME + AutonConstants.SCALE_BACK_TIME + AutonConstants.SCALE_FORWARD_TIME + AutonConstants.SCALE_OUTTAKE_TIME
				+ AutonConstants.SCALE_END_BACK_TIME + AutonConstants.SCALE_END_TURN_TIME)
				&& scaleTurn != Character.MIN_VALUE) {
			Sensors.zeroGyro();
			System.out.println("the gyro is zeroed");
			double leftSpeed, rightSpeed;
			if (position.equalsIgnoreCase("L")) {
				System.out.println("ignorecase L");
				leftSpeed = AutonConstants.SCALE_TURN_SPEED;
				rightSpeed = AutonConstants.SCALE_TURN_SPEED;
			} else if (position.equalsIgnoreCase("R")) {
				System.out.println("ignorecase R");
				leftSpeed = AutonConstants.SCALE_TURN_SPEED;
				rightSpeed = AutonConstants.SCALE_TURN_SPEED;
			} else {
				System.out.println("else L or R");
				leftSpeed = Constants.STOP_MOTOR_SPEED;
				rightSpeed = Constants.STOP_MOTOR_SPEED;
			}
			if (Math.abs(Sensors.getGyroAngle()) < AutonConstants.SCALE_END_GYRO_POSITION
					&& position.equalsIgnoreCase("L")) {
				Drive.autonDrive(leftSpeed, rightSpeed, leftSpeed, rightSpeed);
			} else if (Math.abs(Sensors.getGyroAngle()) < AutonConstants.SCALE_END_GYRO_POSITION) {
				System.out.println("Turning");
				Drive.autonDrive(-leftSpeed, -rightSpeed, -leftSpeed, -rightSpeed);
			} else {
				Drive.autonDrive(Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED, Constants.STOP_MOTOR_SPEED);
			}

		} else if (scaleTurn != Character.MIN_VALUE) {
			double stop = Constants.STOP_MOTOR_SPEED;
			Drive.autonDrive(stop, stop, stop);
		}

		else {
			System.out.println("Switch turn is " + switchTurn);
			System.out.println("Scale turn is " + scaleTurn);
		}

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		Drive.autonDrive(0, 0, 0, 0);
		Actuators.setCarriageLiftMotorSpeed(0);

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
