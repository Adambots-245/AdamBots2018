package autonModes;

import com.github.adambots.powerup2018.auton.Play;
import com.github.adambots.powerup2018.field.Field;

public class rightScale {
	private boolean rightScaleValue;
	private static char position = Field.getScale(); 
	
		public rightScale(){
			
		}
	
		protected void init(){
			if(position == 'L'){
				rightScaleValue = true;
			}else{
				rightScaleValue = false;	
			}
			if(rightScaleValue){
			Play.readRecording("RIGHTCODE"); ///TODO: call actual pathway on roborio
			}
		}
		
		protected void execute(){
			if(rightScaleValue){
				Play.playRecording();			
			}
		}
	
	
}
