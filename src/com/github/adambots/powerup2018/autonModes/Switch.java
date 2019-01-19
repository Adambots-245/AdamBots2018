package com.github.adambots.powerup2018.autonModes;

import com.github.adambots.powerup2018.auton.Play;
import com.github.adambots.powerup2018.field.Field;

public class Switch {
	private boolean rightSwitchValue;
	private static char position = Field.getScale(); 
	
		public Switch(){
			
		}
	
		protected void init(){
			if(position == 'L'){
				rightSwitchValue = true;
			}else{
				rightSwitchValue = false;	
			}
			if(rightSwitchValue){
			Play.readRecording("RIGHTCODE"); ///TODO: call actual pathway on roborio
			}
			else{
				Play.readRecording("LEFTCODE");
			}
		}
		
		protected void execute(){
			crossBaseline.execute();
			if(rightSwitchValue){
				Play.playRecording();			
			}
		}
}
