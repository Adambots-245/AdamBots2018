package com.github.adambots.powerup2018.field;

import edu.wpi.first.wpilibj.DriverStation;

public class Field {
	
	 private String fieldPositions = DriverStation.getInstance().getGameSpecificMessage();
	
	 public char getOwnSwitch(){
		 return fieldPositions.charAt(0);
	 }
	 
	 public char getScale(){
		 return fieldPositions.charAt(1);
	 }
	 
	 public char getOppSwitch(){
		 return fieldPositions.charAt(2);
	 }
}
