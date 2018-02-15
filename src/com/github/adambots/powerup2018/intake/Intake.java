package com.github.adambots.powerup2018.intake;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;
import org.usfirst.frc.team245.robot.Sensors;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Intake {
	
	private static int carriageLiftPositionGoal;
	
	// initial conditions
	public static void init() {
		carriageLiftPositionGoal = Constants.CARRIAGE_LIFT_START_POSITION;
		Actuators.getCarriageLiftMotor().setSelectedSensorPosition(0, 0, 0);
		Intake.setCarriageLiftPID(Constants.CARRIAGE_LIFT_P, Constants.CARRIAGE_LIFT_I, Constants.CARRIAGE_LIFT_D, Constants.CARRIAGE_LIFT_TIMEOUT);
	}

	// set the speed of the intake wheels
	public static void setIntakeWheelsSpeed(double speed) {
		boolean isPhotoEyeBlocked = Sensors.getPhotoEyeValue();
		//speed > 0 is left trigger
		if (speed < 0 && !isPhotoEyeBlocked) {
			Actuators.setLeftIntakeMotor(speed);
			Actuators.setRightIntakeMotor(speed);
		}
		else if (speed > 0 && isPhotoEyeBlocked) {
			Actuators.setLeftIntakeMotor(speed);
			Actuators.setRightIntakeMotor(speed);
		}
		else {
			Actuators.setLeftIntakeMotor(0);
			Actuators.setRightIntakeMotor(0);
		}
		
	}

//	// set both first arm pneumatics
	private static void setArmsFirstPneumatic(DoubleSolenoid.Value value) {
		Actuators.setLeftArmFirstPneumatic(value);
		Actuators.setRightArmFirstPneumatic(value);
	}

	// set both second arm pneumatics
	private static void setArmsSecondPneumatic(DoubleSolenoid.Value value) {
		Actuators.setLeftArmSecondPneumatic(value);
		Actuators.setRightArmSecondPneumatic(value);
	}

	// set arm pneumatic position to position from Constants class
	public static void setArmsPosition(int constantPosition) {
		switch (constantPosition) {
		case 1:
			Intake.setArmsFirstPneumatic(Constants.PNEUMATIC_REVERSE);
			Intake.setArmsSecondPneumatic(Constants.PNEUMATIC_REVERSE);
			break;
		case 2:
			Intake.setArmsFirstPneumatic(Constants.PNEUMATIC_FORWARD);
			Intake.setArmsSecondPneumatic(Constants.PNEUMATIC_REVERSE);
			break;
		case 3:
			Intake.setArmsFirstPneumatic(Constants.PNEUMATIC_FORWARD);
			Intake.setArmsSecondPneumatic(Constants.PNEUMATIC_FORWARD);
			break;
		}
	}

	// toggle left pneumatic arm between 3 states
	// TODO: Check behavior of pressing button before teleop
	public static void armsPosition(boolean inButton, boolean midButton, boolean outButton) {
		if (inButton) {
			Intake.setArmsPosition(Constants.ARMS_IN);
		} else if (midButton) {
			Intake.setArmsPosition(Constants.ARMS_MID);
		} else if (outButton) {
			Intake.setArmsPosition(Constants.ARMS_OUT);
		}
	}

	// toggle the carriage wheels
	public static void toggleCarriageWheels(boolean intakeButton, boolean outtakeButton) {
		double speed;
		if (intakeButton) {
			speed = Constants.CARRIAGE_MOTOR_INTAKE_SPEED;
		} else if (outtakeButton) {
			speed = Constants.CARRIAGE_MOTOR_OUTTAKE_SPEED;
		} else {
			speed = Constants.STOP_MOTOR_SPEED;
		}
		Actuators.setLeftCarriageMotor(speed);
		Actuators.setRightCarriageMotor(speed);
	}

	// set carriage lift PID
	public static void setCarriageLiftPID(double p, double i, double d, int timeout) {
		Actuators.getCarriageLiftMotor().config_kP(0, p, timeout);
		Actuators.getCarriageLiftMotor().config_kI(0, i, timeout);
		Actuators.getCarriageLiftMotor().config_kD(0, d, timeout);
	}
	
	// control the carriage lift
	public static void setCarriageLiftPosition(double controlSpeed) {
		if(Math.abs(controlSpeed) > Constants.CARRIAGE_LIFT_DEADZONE) {
			carriageLiftPositionGoal += Actuators.sgnPow(controlSpeed, 2) * Constants.CARRIAGE_LIFT_POSITION_INCREMENT;
		}
		Actuators.setCarriageLiftMotorPosition(carriageLiftPositionGoal);
	}
	

}
