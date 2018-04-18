package com.github.adambots.powerup2018.autonModes;

import java.io.IOException;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;
import org.usfirst.frc.team245.robot.Sensors;

import com.github.adambots.powerup2018.auton.AutonConstants;
import com.github.adambots.powerup2018.auton.AutonRoutine;
import com.github.adambots.powerup2018.auton.Time;
import com.github.adambots.powerup2018.dash.Dash;
import com.github.adambots.powerup2018.drive.Drive;
import com.github.adambots.powerup2018.field.Field;
import com.github.adambots.powerup2018.intake.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class Switch extends AutonRoutine {

	private String position;
	private char switchPosition;
	private char turn = Character.MIN_VALUE;

	public Switch() {
		// FINISHED!
	}

	@Override
	public void initialize() {
		Intake.setArmsPosition(Constants.ARMS_IN);
		position = Dash.getPositionSelected();
		try {
			Field.getPosition();
			switchPosition = Field.getOwnSwitch();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (position.equalsIgnoreCase(String.valueOf(switchPosition))) {
			turn = switchPosition == 'L' ? 'L' : 'R';
		} else {
			turn = Character.MIN_VALUE;
		}
	}

	@Override
	public void execute() {
		System.out.println(Sensors.getGyroAngle());
		double time = Time.getTime();
		System.out.println("SWITCH IS RUNNING");
		System.out.println(time);
		if (position.equalsIgnoreCase("M")) {
			if (switchPosition == 'L') {
				if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double diagStraightSpeed = AutonConstants.DIAGONAL_STRAIGHT_SPEED;
					double diagStrafeSpeed = AutonConstants.DIAGONAL_SIDE_SPEED;
					Drive.autonDrive(-diagStrafeSpeed, diagStraightSpeed, stop);
					System.out.println("Middle switch diagonal left");
				} else if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = AutonConstants.MIDDLE_STRAIGHT_SPEED;
					Drive.autonDrive(stop, straightSpeed, stop);
					System.out.println("Middle switch forward");
				} else if (time > AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME) {
					double carriageSpeed = AutonConstants.SWITCH_CARRIAGE_WHEEL_SPEED;
					Actuators.setLeftCarriageMotor(carriageSpeed);
					Actuators.setRightCarriageMotor(-carriageSpeed);
					// Start cube 2
				} else if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = AutonConstants.MIDDLE_BACK_SPEED;
					double liftSpeed = AutonConstants.SWITCH_ELEVATOR_LOWER_SPEED;
					Intake.setCarriageLiftSpeed(liftSpeed, false);
					Drive.autonDrive(stop, straightSpeed, stop);
					System.out.println("Middle switch backward");
				} else if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
						+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double diagStraightSpeed = AutonConstants.DIAGONAL_STRAIGHT_BACK_SPEED;
					double diagStrafeSpeed = AutonConstants.DIAGONAL_SIDE_BACK_SPEED;
					double liftSpeed = AutonConstants.SWITCH_ELEVATOR_LOWER_SPEED;
					Drive.autonDrive(-diagStrafeSpeed, diagStraightSpeed, stop);
					Intake.setCarriageLiftSpeed(liftSpeed, false);
					System.out.println("Middle switch diagonal left side back");
				} else if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
						+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME
						+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = AutonConstants.MIDDLE_STRAIGHT_SPEED;
					double liftSpeed = AutonConstants.SWITCH_ELEVATOR_LOWER_SPEED;
					Drive.autonDrive(stop, straightSpeed, stop);
					Intake.setCarriageLiftSpeed(liftSpeed, false);
					double intakeSpeed = AutonConstants.SWITCH_INTAKE_SPEED;
					Intake.setIntakeWheelsSpeed(intakeSpeed);
					System.out.println("Middle switch forward for cube");
				} // else if (time < AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME +
					// AutonConstants.MIDDLE_STRAIGHT_TIME +
					// AutonConstants.MIDDLE_BACK_TIME +
					// AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME +
					// AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME) {
					// double intakeSpeed = AutonConstants.SWITCH_INTAKE_SPEED;
					// Intake.setIntakeWheelsSpeed(intakeSpeed);
					// }
				else if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
						+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME + AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME
						+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = AutonConstants.MIDDLE_BACK_SPEED;
					Drive.autonDrive(stop, straightSpeed, stop);
				} else if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
						+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME
						+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME + AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME
						+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = -AutonConstants.DIAGONAL_STRAIGHT_BACK_SPEED;
					double diagSpeed = -AutonConstants.DIAGONAL_SIDE_BACK_SPEED;
					Drive.autonDrive(diagSpeed, straightSpeed, stop);
					if (Math.abs(Actuators.getCarriageLiftMotorPosition()) < 20000) {
						double liftSpeed = AutonConstants.SCALE_ELEVATOR_RAISE_SPEED;
						Intake.setCarriageLiftSpeed(liftSpeed, false);
						// Actuators.setCarriageLiftMotorSpeed(liftSpeed);
					} else {
						double liftSpeed = Constants.STOP_MOTOR_SPEED;
						Intake.setCarriageLiftSpeed(liftSpeed, false);
					}
					System.out.println("raising elevator");
				}
			} else if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
					+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
					+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME
					+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME + AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME
					+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME + AutonConstants.MIDDLE_BACK_TIME) {
				if (Math.abs(Actuators.getCarriageLiftMotorPosition()) < 20000) {
					double liftSpeed = AutonConstants.SCALE_ELEVATOR_RAISE_SPEED;
					Intake.setCarriageLiftSpeed(liftSpeed, false);
					// Actuators.setCarriageLiftMotorSpeed(liftSpeed);
				} else {
					double liftSpeed = Constants.STOP_MOTOR_SPEED;
					Intake.setCarriageLiftSpeed(liftSpeed, false);
				}
				System.out.println("raising elevator");
				double stop = Constants.STOP_MOTOR_SPEED;
				double straightSpeed = -AutonConstants.MIDDLE_BACK_SPEED;
				Drive.autonDrive(stop, straightSpeed, stop);
			} else if (time <= AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
					+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
					+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME
					+ AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME + AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME
					+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME + AutonConstants.MIDDLE_BACK_TIME
					+ AutonConstants.MIDDLE_CUBE_OUTTAKE_TIME) {
				if (Math.abs(Actuators.getCarriageLiftMotorPosition()) < 20000) {
					double liftSpeed = AutonConstants.SCALE_ELEVATOR_RAISE_SPEED;
					Intake.setCarriageLiftSpeed(liftSpeed, false);
					// Actuators.setCarriageLiftMotorSpeed(liftSpeed);
				} else {
					double liftSpeed = Constants.STOP_MOTOR_SPEED;
					Intake.setCarriageLiftSpeed(liftSpeed, false);
				}
				System.out.println("raising elevator");
				Intake.setIntakeWheelsSpeed(-AutonConstants.SWITCH_INTAKE_SPEED);

				// Start Right switch
			} else if (switchPosition == 'R') {
				if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double diagStraightSpeed = AutonConstants.DIAGONAL_STRAIGHT_SPEED;
					double diagStrafeSpeed = AutonConstants.DIAGONAL_SIDE_SPEED;
					Drive.autonDrive(diagStrafeSpeed, diagStraightSpeed, stop);
					System.out.println("Middle switch diagonal right");
				} else if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = AutonConstants.MIDDLE_STRAIGHT_SPEED;
					Drive.autonDrive(stop, straightSpeed, stop);
					System.out.println("Middle switch forward");
				} else if (time > AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME) {
					double carriageSpeed = AutonConstants.SWITCH_CARRIAGE_WHEEL_SPEED;
					Actuators.setLeftCarriageMotor(carriageSpeed);
					Actuators.setRightCarriageMotor(-carriageSpeed);
					// Start cube 2
				} else if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = AutonConstants.MIDDLE_BACK_SPEED;
					double liftSpeed = AutonConstants.SWITCH_ELEVATOR_LOWER_SPEED;
					Intake.setCarriageLiftSpeed(liftSpeed, false);
					Drive.autonDrive(stop, straightSpeed, stop);
					System.out.println("Middle switch backward");
				} else if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
						+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double diagStraightSpeed = AutonConstants.DIAGONAL_STRAIGHT_BACK_SPEED;
					double diagStrafeSpeed = AutonConstants.DIAGONAL_SIDE_BACK_SPEED;
					double liftSpeed = AutonConstants.SWITCH_ELEVATOR_LOWER_SPEED;
					Drive.autonDrive(diagStrafeSpeed, diagStraightSpeed, stop);
					Intake.setCarriageLiftSpeed(liftSpeed, false);
					System.out.println("Middle switch diagonal right side back");
				} else if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
						+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME
						+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = AutonConstants.MIDDLE_STRAIGHT_SPEED;
					double liftSpeed = AutonConstants.SWITCH_ELEVATOR_LOWER_SPEED;
					Drive.autonDrive(stop, straightSpeed, stop);
					Intake.setCarriageLiftSpeed(liftSpeed, false);
					double intakeSpeed = AutonConstants.SWITCH_INTAKE_SPEED;
					Intake.setIntakeWheelsSpeed(intakeSpeed);/// TODO: Make
																/// certain
																/// these wheels
																/// stop either
																/// by photo eye
																/// or by
																/// another line
																/// in the next
																/// elif
					System.out.println("Middle switch forward for cube");
				} // else if (time < AutonConstants.MIDDLE_LEFT_DIAGONAL_TIME +
					// AutonConstants.MIDDLE_STRAIGHT_TIME +
					// AutonConstants.MIDDLE_BACK_TIME +
					// AutonConstants.MIDDLE_LEFT_SIDE_DIAGONAL_BACK_TIME +
					// AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME) {
					// double intakeSpeed = AutonConstants.SWITCH_INTAKE_SPEED;
					// Intake.setIntakeWheelsSpeed(intakeSpeed);
					// }
				else if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
						+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME + AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME
						+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = AutonConstants.MIDDLE_BACK_SPEED;
					Drive.autonDrive(stop, straightSpeed, stop);
				} else if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
						+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
						+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME
						+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME + AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME
						+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME) {
					double stop = Constants.STOP_MOTOR_SPEED;
					double straightSpeed = -AutonConstants.DIAGONAL_STRAIGHT_BACK_SPEED;
					double diagSpeed = AutonConstants.DIAGONAL_SIDE_BACK_SPEED;
					Drive.autonDrive(diagSpeed, straightSpeed, stop);
					if (Math.abs(Actuators.getCarriageLiftMotorPosition()) < 20000) {
						double liftSpeed = AutonConstants.SCALE_ELEVATOR_RAISE_SPEED;
						Intake.setCarriageLiftSpeed(liftSpeed, false);
						// Actuators.setCarriageLiftMotorSpeed(liftSpeed);
					} else {
						double liftSpeed = Constants.STOP_MOTOR_SPEED;
						Intake.setCarriageLiftSpeed(liftSpeed, false);
					}
					System.out.println("raising elevator");
				}
			} else if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
					+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
					+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME
					+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME + AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME
					+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME + AutonConstants.MIDDLE_BACK_TIME) {
				double stop = Constants.STOP_MOTOR_SPEED;
				double straightSpeed = -AutonConstants.MIDDLE_BACK_SPEED;
				Drive.autonDrive(stop, straightSpeed, stop);
			} else if (time <= AutonConstants.MIDDLE_RIGHT_DIAGONAL_TIME + AutonConstants.MIDDLE_STRAIGHT_TIME
					+ AutonConstants.MIDDLE_SWITCH_OUTTAKE_TIME + AutonConstants.MIDDLE_BACK_TIME
					+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME
					+ AutonConstants.MIDDLE_RIGHT_SIDE_DIAGONAL_BACK_TIME + AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME
					+ AutonConstants.MIDDLE_STRAIGHT_CUBE_TIME + AutonConstants.MIDDLE_BACK_TIME
					+ AutonConstants.MIDDLE_CUBE_OUTTAKE_TIME) {
				Intake.setIntakeWheelsSpeed(-AutonConstants.SWITCH_INTAKE_SPEED);

			}
			// end cube 2
		} else if (time <= AutonConstants.SWITCH_STRAIGHT_END_TIME) {
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
			if (Math.abs(Sensors.getGyroAngle()) < AutonConstants.SWITCH_GYRO_POSITION
					&& position.equalsIgnoreCase("L")) {
				Drive.autonDrive(leftSpeed, rightSpeed, leftSpeed, rightSpeed);
			} else if (Math.abs(Sensors.getGyroAngle()) < AutonConstants.SWITCH_GYRO_POSITION) {
				System.out.println("Line 66 running");
				Drive.autonDrive(-leftSpeed, -rightSpeed, -leftSpeed, -rightSpeed);
			} else {
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
			// if(time < (AutonConstants.SWITCH_OUTTAKE_TIME +
			// AutonConstants.SWITCH_STRAIGHT_END_TIME +
			// AutonConstants.SWITCH_TURN_TIME)) {
			Actuators.setLeftCarriageMotor(AutonConstants.SWITCH_CARRIAGE_WHEEL_SPEED);
			Actuators.setRightCarriageMotor(-AutonConstants.SWITCH_CARRIAGE_WHEEL_SPEED);
			// }
		} else {
			System.out.println("Turn is " + turn);
		}

	}

	// @Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	// @Override
	protected void end() {
		// System.out.println("end, (0,0,0,0)");
		// Drive.autonDrive(0, 0, 0, 0);
		// Actuators.setCarriageLiftMotorSpeed(0);

	}

	// @Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}
}
