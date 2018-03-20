package com.github.adambots.powerup2018.field;

import edu.wpi.first.wpilibj.DriverStation;

public class Field {
	
	private static double matchTime;
	private static String fieldPositions;
	
	public static void getPosition() {
		 fieldPositions = DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public static double getMatchTime() {
		matchTime = DriverStation.getInstance().getMatchTime();
		return matchTime;
	}
	
	 public static char getOwnSwitch(){
		 return fieldPositions.charAt(0);
	 }
	 
	 public static char getScale(){
		 return fieldPositions.charAt(1);
	 }
	 
	 public static char getOppSwitch(){
		 return fieldPositions.charAt(2);
	 }
}
