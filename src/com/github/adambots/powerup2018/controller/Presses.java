package com.github.adambots.powerup2018.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Presses {
	private Map<String, Button> presses;
	private Gamepad myController;

	// constructor
	protected Presses(Gamepad controller) {
		myController = controller;
	}

	// initialization code for counting presses
	protected void init() throws ClassNotFoundException {
		presses = new HashMap<String, Button>();
		Class<?> c = myController.getClass();
		for (Method m : c.getMethods()) {
			if (m.getName().startsWith("get") && m.getParameterTypes().length == 0
					&& m.getReturnType().getName().equals("boolean")) {
				String name = m.getName().substring(3);
				presses.put(name, new Button(false, false, 0));
			}
		}
	}

	// updates the press count
	protected void updatePresses() throws Exception {
		Class<?> c = myController.getClass();
		for (Map.Entry<String, Button> entry : presses.entrySet()) {
			Method method = c.getDeclaredMethod("get" + entry.getKey());
			entry.getValue().update((boolean) method.invoke(myController));
		}
	}

	protected int getPresses(String key) {
		if (presses.containsKey(key)) {
			return presses.get(key).getPressCount();
		} else {
			System.out.println("Key not found" + key);
			return -1;
		}
	}

}
