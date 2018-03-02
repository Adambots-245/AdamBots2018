package com.github.adambots.powerup2018.auton;

import java.io.BufferedReader;
import java.io.FileReader;

import org.usfirst.frc.team245.robot.Constants;

import com.github.adambots.powerup2018.drive.Drive;

public class Play {
	static double time;
	static String[][] recording = new String [1000][7];
	static int snapshotNum = 0;
	static double startTime;
	static int index = 0;
	
	public static void readRecording(String autonmode){
		BufferedReader buffer;
		String line;
		
		try{
			buffer = new BufferedReader(new FileReader(autonmode));
			while ((line = buffer.readLine()) != null){
				String[] snapshot = line.split(" ");
				recording[index] = snapshot;
				System.out.println(snapshot.length);
				index++;
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void init(){
		startTime = System.nanoTime();
	}
	
	public static void playRecording(){
		try{
			int snapshotBoundNum = Math.max(1, (Math.min(snapshotNum, index-1)));
			time = System.nanoTime()- startTime;
			double rightSpeed = 0;
			double forwardSpeed = 0;
			double zRotation = 0;
			double elevatorValue = 0;
			double AValue;
			double BValue;
			System.out.println(recording.length);
			System.out.println(recording[snapshotNum - 1][Constants.TIME_INDEX]);
			
			// Begin reading the values from the string
			forwardSpeed = Double.parseDouble(recording[snapshotBoundNum][Constants.FORWARD]);
			zRotation = Double.parseDouble(recording[snapshotBoundNum][Constants.Z_ROTATION]);
			elevatorValue = Double.parseDouble(recording[snapshotBoundNum][Constants.ELEVATOR_VALUE]);
			AValue = Double.parseDouble(recording[snapshotBoundNum][Constants.A_VALUE]);
			BValue = Double.parseDouble(recording[snapshotBoundNum][Constants.B_VALUE]);
			rightSpeed = Double.parseDouble(recording[snapshotBoundNum][Constants.RIGHT_SPEED]);
		
			Drive.autonDrive(rightSpeed, forwardSpeed, zRotation, AValue, BValue, elevatorValue);
		
			snapshotNum ++;
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String Args[]){
	///TODO: Make sure that this is the right filename for the robot when the time comes
	readRecording("/Documents/ghostMode.txt");
		while(true){
			playRecording();
		}
	}
}