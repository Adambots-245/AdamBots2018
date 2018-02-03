package com.github.adambots.powerup2018.controller;

import edu.wpi.first.wpilibj.Joystick;

public class Gamepad {
	private Joystick joy;
	private Presses press;
	//// CONSTANTS -------------------------------------------------------------
	/**
	 * Primary Driver Controller Port Number.
	 */
	private static final int PRIMARY_DRIVER = 1;
	/**
	 * Secondary Driver Controller Port Number.
	 */
	private static final int SECONDARY_DRIVER = 2;
	/**
	 * XBOX 360 South Face Button
	 */
	private static final int BUTTON_A = 1;
	/**
	 * XBOX 360 East Face Button
	 */
	private static final int BUTTON_B = 2;
	/**
	 * XBOX 360 West Face Button
	 */
	private static final int BUTTON_X = 3;
	/**
	 * XBOX 360 North Face Button
	 */
	private static final int BUTTON_Y = 4;
	/**
	 * XBOX 360 Left Bumper (Top)
	 */
	private static final int BUTTON_LB = 5;
	/**
	 * XBOX 360 Right Bumper (Top)
	 */
	private static final int BUTTON_RB = 6;
	/**
	 * XBOX 360 Back Button
	 */
	private static final int BUTTON_BACK = 7;
	/**
	 * XBOX 360 Start Button
	 */
	private static final int BUTTON_START = 8;
	/**
	 * XBOX 360 Left Horizontal Axis (Left=-1, Right=1)
	 */
	private static final int AXIS_LEFT_X = 0;
	/**
	 * XBOX 360 Left Vertical Axis (Up=1, Down=-1)
	 */
	private static final int AXIS_LEFT_Y = 1;
	/**
	 * XBOX 360 Trigger Axis (LEFT)
	 */
	public static final int LEFT_AXIS_TRIGGERS = 2;
	/**
	 * XBOX 360 Trigger Axis (RIGHT)
	 */
	public static final int RIGHT_AXIS_TRIGGERS = 3;
	/**
	 * XBOX 360 Right Horizontal Axis (Left=-1, Right=1)
	 */
	private static final int AXIS_RIGHT_X = 4;
	/**
	 * XBOX 360 Right Vertical Axis (Up=1, Down=-1)
	 */
	private static final int AXIS_RIGHT_Y = 5;
	private static final int AXIS_DPAD_HORIZONTAL = 6;
	//// Control Instances
	public static Gamepad primary;
	public static Gamepad secondary;
	//// CONSTRUCTOR -----------------------------------------------------------

	/**
	 * Creates new Joystick instance and Presses instance on the correct driver
	 * port.
	 *
	 * @param port
	 *            The joystick port number.
	 */
	private Gamepad(int port) {
		joy = new Joystick(port);
		press = new Presses(this);
		try {
			press.init();
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to initialize presses.");
		}
	}

	private void updatePress() {
		try {
			press.updatePresses();
		} catch (Exception e) {
			System.out.println("Failed to update presses");
			e.printStackTrace();
		}
	}

	public static void init() {
		primary = new Gamepad(PRIMARY_DRIVER);
		secondary = new Gamepad(SECONDARY_DRIVER);
	}

	public static void update() {
		Gamepad.primary.updatePress();
		Gamepad.secondary.updatePress();
	}

	private double deaden(double u) {
		return Math.abs(u) < .15 ? 0 : u;
	}

	public double getTriggers() {
		return deaden(joy.getRawAxis(LEFT_AXIS_TRIGGERS) - joy.getRawAxis(RIGHT_AXIS_TRIGGERS));
	}

	public boolean getDPadLeft() {
		return joy.getRawAxis(AXIS_DPAD_HORIZONTAL) < -0.5;
	}

	public boolean getDPadRight() {
		return joy.getRawAxis(AXIS_DPAD_HORIZONTAL) > 0.5;
	}

	/**
	 * Corresponds to HORIZONTAL input on the LEFT joystick.
	 *
	 * @return The X coordinate of the left joystick (-1 is LEFT, 1 is RIGHT)
	 */
	public double getLeftX() {
		return deaden(joy.getRawAxis(AXIS_LEFT_X));
	}

	/**
	 * Corresponds to VERTICAL input on the LEFT joystick.
	 *
	 * @return The Y coordinate of the LEFT joystick (1 is UP, -1 is DOWN)
	 */
	public double getLeftY() {
		return deaden(-joy.getRawAxis(AXIS_LEFT_Y));
	}

	/**
	 * Corresponds to HORIZONTAL input on the RIGHT joystick
	 *
	 * @return The X coordinate of the RIGHT joystick (-1 is LEFT, 1 is RIGHT)
	 */
	public double getRightX() {
		return deaden(joy.getRawAxis(AXIS_RIGHT_X));
	}

	/**
	 * Corresponds to VERTICAL input on the RIGHT joystick
	 *
	 * @return The Y coordinate of the RIGHT joystick (1 is UP, -1 is DOWN)
	 */
	public double getRightY() {
		return deaden(-joy.getRawAxis(AXIS_RIGHT_Y));
	}

	/**
	 *
	 * @return Is the left bumper pressed? [top one]
	 */
	public boolean getLB() {
		return joy.getRawButton(BUTTON_LB);
	}

	/**
	 *
	 * @return Is the right bumper pressed? [top one]
	 */
	public boolean getRB() {
		return joy.getRawButton(BUTTON_RB);
	}

	public boolean getA() {
		return joy.getRawButton(BUTTON_A);
	}

	public boolean getB() {
		return joy.getRawButton(BUTTON_B);
	}

	public boolean getX() {
		return joy.getRawButton(BUTTON_X);
	}

	public boolean getY() {
		return joy.getRawButton(BUTTON_Y);
	}

	public boolean getStart() {
		return joy.getRawButton(BUTTON_START);
	}

	public boolean getBack() {
		return joy.getRawButton(BUTTON_BACK);
	}

	public int getDPadLeftPresses() {
		return press.getPresses("DPadLeft");
	}

	public int getDPadRightPresses() {
		return press.getPresses("DPadRight");
	}

	public int getLBPresses() {
		return press.getPresses("LB");
	}

	public int getRBPresses() {
		return press.getPresses("RB");
	}

	public int getAPresses() {
		return press.getPresses("A");
	}

	public int getBPresses() {
		return press.getPresses("B");
	}

	public int getXPresses() {
		return press.getPresses("X");
	}

	public int getYPresses() {
		return press.getPresses("Y");
	}

	public int getStartPresses() {
		return press.getPresses("Start");
	}

	public int getBackPresses() {
		return press.getPresses("Back");
	}

}