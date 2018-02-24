package com.github.adambots.powerup2018.intake;

import org.usfirst.frc.team245.robot.Actuators;
import org.usfirst.frc.team245.robot.Constants;
import org.usfirst.frc.team245.robot.Sensors;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Intake {
	public static int intendedPosition;
	// initial conditions
	public static void init() {
		//carriageLiftPositionGoal = Actuators.getCarriageLiftMotorPosition();
		//Intake.setCarriageLiftPID(Constants.CARRIAGE_LIFT_P, Constants.CARRIAGE_LIFT_I, Constants.CARRIAGE_LIFT_D,
				//Constants.CARRIAGE_LIFT_TIMEOUT);
	}
	//resets encoder if limit switch is pressed
	public static void resetEncoderOnLimitSwitch() {
		if (Sensors.getLimitSwitchValue()) {
			Sensors.resetCarriageEncoder();
		}
	}
	// set the speed of the intake wheels
	public static void setIntakeWheelsSpeed(double speed) {
		//speed > 0 is left trigger
		//speed > 0 is left trigger
		Actuators.setLeftIntakeMotor(-speed);
		Actuators.setRightIntakeMotor(speed);
	}

	// set both first arm pneumatics
	private static void setArmsOpenPneumatic(DoubleSolenoid.Value value) {
		Actuators.setLeftArmOpenPneumatic(value);
		Actuators.setRightArmOpenPneumatic(value);
	}

	// set both second arm pneumatics
	private static void setArmsMidPneumatic(DoubleSolenoid.Value value) {
		Actuators.setLeftArmMidPneumatic(value);
		Actuators.setRightArmMidPneumatic(value);
	}

	// set arm pneumatic position to position from Constants class
	public static void setArmsPosition(int constantPosition) {
		switch (constantPosition) {
		case 1:
			Intake.setArmsOpenPneumatic(Constants.PNEUMATIC_REVERSE);
			Intake.setArmsMidPneumatic(Constants.PNEUMATIC_REVERSE);
			break;
		case 2:
			Intake.setArmsOpenPneumatic(Constants.PNEUMATIC_REVERSE);
			Intake.setArmsMidPneumatic(Constants.PNEUMATIC_FORWARD);
			break;
		case 3:
			Intake.setArmsOpenPneumatic(Constants.PNEUMATIC_FORWARD);
			Intake.setArmsMidPneumatic(Constants.PNEUMATIC_FORWARD);
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
	//TODO: add override button
	public static void toggleCarriageWheels(double carriageWheelsSpeed) {
		boolean isPhotoEyeOpen = Sensors.getPhotoEyeValue();
		double speed;
		if (carriageWheelsSpeed < 0 && isPhotoEyeOpen) {
			speed = carriageWheelsSpeed;
		} else if (carriageWheelsSpeed < 0 && !isPhotoEyeOpen) {
			speed = Constants.STOP_MOTOR_SPEED;
		} else if (carriageWheelsSpeed > 0) {
			speed = carriageWheelsSpeed;
		} else {
			speed = Constants.STOP_MOTOR_SPEED;
		}
		
		Actuators.setLeftCarriageMotor(speed);
		Actuators.setRightCarriageMotor(-speed);
		System.out.println("carriage wheel speed = [" + speed + "]");
		System.out.println("photoeye open? = [" + isPhotoEyeOpen + "]");
	}
	// set carriage lift PID
	public static void setCarriageLiftPID(double p, double i, double d, int timeout) {
		Actuators.getCarriageLiftMotor().config_kP(0, p, timeout);
		Actuators.getCarriageLiftMotor().config_kI(0, i, timeout);
		Actuators.getCarriageLiftMotor().config_kD(0, d, timeout);
	}
	// control the carriage lift
	public static void setCarriageLiftSpeed(double speed) {
		int carriageLiftPosition = Sensors.getCarriageLiftPosition();
	//bottom is 0, top is ~67,000
		boolean isLimitSwitchPressed = Sensors.getLimitSwitchValue();
		int intendedPosition;
		
		if (isLimitSwitchPressed && speed <= 0) {
			Actuators.setCarriageLiftMotorSpeed(Constants.STOP_MOTOR_SPEED);
		}
		//TODO: Calibrate top encoder value
		else if (carriageLiftPosition >= 64000 && speed >= 0) {
			Actuators.setCarriageLiftMotorSpeed(Constants.STOP_MOTOR_SPEED);
		}
		else {
			Actuators.setCarriageLiftMotorSpeed(speed);
		}
		
		//TODO: Calibrate encoder value
		if (speed < -0.05 && carriageLiftPosition < 15000) {
			Intake.setArmsPosition(Constants.ARMS_OUT);
		} else if (speed > 0.05 && carriageLiftPosition > 14000) {
			Intake.setArmsPosition(Constants.ARMS_IN);
		}

		double lastSpeed;
		lastSpeed = speed;
		if (speed == 0 && lastSpeed != 0) {
			intendedPosition = carriageLiftPosition;
			
			System.out.println("lastSpeed = [" + lastSpeed + "]");
			System.out.println("speed = [" + speed + "]");
			System.out.println("intendedPosition = [" + intendedPosition + "]");
			
		}
		
		//TODO: FIX!! and calibrate
		//if (carriageLiftPosition + 200 < intendedPosition) {
		//	Actuators.setCarriageLiftMotorPosition(intendedPosition);
		//}
	}	
	
}
