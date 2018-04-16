package com.github.adambots.powerup2018.auton;

public class AutonConstants {
	//wait variable
	public static final double PNEUMATIC_WAIT_TIME = 0.0;
	// Cross Baseline
	public static final double CROSS_BASELINE_SPEED = 0.4;
	public static final double CROSS_BASELINE_TIME = 3.5;
	
	// Switch
	public static final double SWITCH_SPEED = 0.5;
	public static final double SWITCH_STRAIGHT_END_TIME = 2.0;//2.2
	public static final double SWITCH_TURN_TIME = 2.0;
	public static final double SWITCH_TURN_SPEED = 0.5;
	public static final double SWITCH_CARRIAGE_WHEEL_SECOND_TIME = 6;
	public static final double SWITCH_CARRIAGE_WHEEL_SPEED = 0.65;
	public static final double SWITCH_GYRO_POSITION = 82;
	public static final double SWITCH_STRAIGHT_SPEED = 1.5;
	public static final double SWITCH_STRAIGHT_TIME = 2;
	public static final double SWITCH_OUTTAKE_TIME = 2.5;
	public static final double SWITCH_GYRO_RIGHT_POSITION = -82;
	//public static final double SWITCH_MIDDLE_STRAIGHT_TIME = 2;
	
	// Middle Switch
	//public static final double DIAGONAL_SPEED = 0.25;
	public static final double DIAGONAL_STRAIGHT_SPEED = 0.25;
	public static final double DIAGONAL_SIDE_SPEED = 07.5; 
	public static final double MIDDLE_STRAIGHT_SPEED = 0.3;
	public static final double MIDDLE_LEFT_DIAGONAL_TIME = 1.7; //was 1.65
	public static final double MIDDLE_RIGHT_DIAGONAL_TIME = 1.14; //was 1.2 before
	public static final double MIDDLE_STRAIGHT_TIME = 2.4; // 2.35 was 2.2
	
	
	//Scale
	public static final double SCALE_ELEVATOR_LOWER_SPEED = -1;
	public static final double SCALE_STRAIGHT_END_TIME = 4.2;//was 3.0, not proven 4/10 // changed to 1.9 at states and the scale code was using switch constants. 
	public static final double SCALE_TURN_TIME = 2.0;
	public static final double SCALE_TURN_SPEED = 0.5;
	public static final double SCALE_GYRO_POSITION = 82;
	public static final double SCALE_BACK_TIME = 1.5;
	public static final double SCALE_BACK_SPEED = -0.3;
	public static final double SCALE_ELEVATOR_RAISE_SPEED = 1;
	public static final double SCALE_FORWARD_SPEED = 0.5;
	public static final double SCALE_ELEVATOR_LOWER_TIME = 1.4;
	public static final double SCALE_ELEVATOR_RAISE_TIME = 3;
	public static final double SCALE_FORWARD_TIME = .7;
	public static final double SCALE_CARRIAGE_WHEEL_SPEED = 0.6;
	public static final double SCALE_OUTTAKE_TIME = 1.0;
	public static final double SCALE_END_BACK_TIME = 1.0;
	public static final double SCALE_END_TURN_TIME = 0.5;
	public static final double SCALE_END_GYRO_POSITION= 45;
	
}
