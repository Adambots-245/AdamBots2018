package autonModes;

import com.github.adambots.powerup2018.auton.Play;
import com.github.adambots.powerup2018.field.Field;

public class leftScale {
	private boolean leftScaleValue;
	private static char position = Field.getScale(); 
	
		public leftScale(){
			
		}
	
		protected void init(){
			if(position == 'L'){
				leftScaleValue = true;
			}else{
				leftScaleValue = false;	
			}
			if(leftScaleValue){
			Play.readRecording("LEFTCODE"); ///TODO: call actual pathway on roborio
			}
		}
		
		protected void execute(){
			if(leftScaleValue){
				Play.playRecording();			
			}
		}
	}


