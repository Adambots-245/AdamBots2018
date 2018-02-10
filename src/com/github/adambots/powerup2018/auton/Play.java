package com.github.adambots.powerup2018.auton;

import java.io.BufferedReader;
import java.io.FileReader;

public class Play {
	static double time;
	static String[][] recording = new String [1000][7];
	static int snapshotnum = 0;
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
			int snapshotBoundNum = Math.max
			
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String Args[]){
	}
}
