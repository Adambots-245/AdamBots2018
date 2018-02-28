package com.github.adambots.powerup2018.auton;

import org.usfirst.frc.team245.robot.*;

import com.github.adambots.powerup2018.controller.Gamepad;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Arrays;

import com.github.adambots.powerup2018.controller.Gamepad;

public class Record {
	private static long startTime = System.nanoTime();
	private static double indexArray [][] = new double[750][7];
	private static int index;
	private static boolean writing = false;
	private static boolean ghostRecording = true;
	
	
	private static double boolToDouble(boolean condition){
		double value;
		if(condition){
			value = 1;
		}
		else{
			value = 0;
		}
		return value;
	}
	
	public static void ghostRecording(){
		if(index <= 0){
			index = 0;
			startTime = System.nanoTime();
		}
		if (index >= 750){
			writing = true;
			ghostRecording = false;
		}
		if (ghostRecording == true){
		double leftPrimaryY = Gamepad.primary.getLeftY(); 	
		double leftPrimaryX = Gamepad.primary.getLeftX();	
		double rightPrimaryX = Gamepad.primary.getRightX();
		double leftSecondaryY = Gamepad.secondary.getLeftY();
		boolean secondaryA = Gamepad.secondary.getA();
		boolean secondaryB = Gamepad.secondary.getB();
		
		
		long timeStamp = System.nanoTime() - startTime;
		double [] myDoubleArray = {leftPrimaryY,leftPrimaryX,rightPrimaryX,leftSecondaryY, boolToDouble(secondaryA), boolToDouble(secondaryB), (double)timeStamp};
		indexArray[index] = myDoubleArray;
		index++;
		}
	}
	
	public static void writing(){
		if(writing){
			return;
		}
		System.out.println("Starting to write");
			try{
			PrintWriter writer = new PrintWriter("/Documents/ghostModetxt", "UTF-8");
				if (ghostRecording == true && indexArray.length >= 749){
					for(index = 0; index <= 749; index++){
					writer.print(index);
						for(int i = 0; i <7; i++){
							writer.print(" ");
							writer.print(indexArray[index][i]);
						}
					}
				Arrays.toString(indexArray);
				writer.close();
				writing = true;
				}
				
				// old code has an else statement here, should it be added?
			}catch (IOException e){
				System.out.println(e.getMessage());
			}
			
			}
	
	public static void ghostModeInit(){
		startTime = System.nanoTime();
		index = 0;
		indexArray = new double[750][7];
	}

	public static void main(String Args[]) throws InterruptedException{
		ghostModeInit();
		while(writing == false){
			ghostRecording();
			Thread.sleep(20);
		}
	
	}
}