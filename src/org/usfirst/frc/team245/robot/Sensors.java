package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Sensors {

	// gyro
	private static ADXRS450_Gyro gyro;

	// initializes all sensors
	public static void init() {
		
		// initialize gyro
		gyro = new ADXRS450_Gyro();
		// calibrate gyro
		gyro.calibrate();
		
	}

	public static ADXRS450_Gyro getGyro() {
		return gyro;
	}
}
