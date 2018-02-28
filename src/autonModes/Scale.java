package autonModes;

import com.github.adambots.powerup2018.auton.Play;
import com.github.adambots.powerup2018.field.Field;

public class Scale {
	private boolean leftScaleValue;
	private static char position = Field.getScale(); 
	
		public Scale(){
			
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
			else{
				Play.readRecording("RIGHTCODE");
			}
			
		}
		
		protected void execute(){
			crossBaseline.execute();
			if(leftScaleValue){
				Play.playRecording();			
			}
		}
	}


