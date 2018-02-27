package autonModes;

import com.github.adambots.powerup2018.auton.Play;
import com.github.adambots.powerup2018.field.Field;

public class rightSwitch {
	private boolean rightSwitchValue;
	private static char position = Field.getScale(); 
	
		public rightSwitch(){
			
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
		}
		
		protected void execute(){
			crossBaseline.execute();
			if(rightSwitchValue){
				Play.playRecording();			
			}
		}
}
