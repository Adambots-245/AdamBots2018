package com.github.adambots.powerup2018.controller;

public class Button {

	private boolean pastState, currentState;
	private int pressCount;

	public Button(boolean past, boolean current, int presses) {
		pastState = past;
		currentState = current;
		pressCount = presses;
	}

	public boolean getPastState() {
		return pastState;
	}

	public boolean getCurrentState() {
		return currentState;
	}

	public int getPressCount() {
		return pressCount;
	}

	public void update(boolean button) {
		pastState = currentState;
		currentState = button;
		if (!currentState && pastState) {
			pressCount++;
		}
	}
}
