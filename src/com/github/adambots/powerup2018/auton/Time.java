package com.github.adambots.powerup2018.auton;

import edu.wpi.first.wpilibj.Timer;

public class Time {

	private static Timer time;

	public static void init() {
		time = new Timer();
		time.start();
	}
	
	public static double getTime() {
		return time.get();
	}

}
