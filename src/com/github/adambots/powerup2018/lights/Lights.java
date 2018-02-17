package com.github.adambots.powerup2018.lights;

import java.sql.Time;

public class Lights {
// TODO: Still need to add what lightStrip is connected to. 	
	public static void init() {
		boolean lightStrip;
	}
 //To turn the lights on and off 	
	public static void setLightStrip(boolean lightsOn) {
		lightStrip.set(lightsOn);
	}
// To make the lights flash. 
	public static void setLightsFlashing(boolean lightsFlash) {
		for (int i = 0; i <= 3; i++) {
			lightStrip.set(true);
			Time.delay(1.5);
			lightStrip.setLights(false);
		}
	}

}
