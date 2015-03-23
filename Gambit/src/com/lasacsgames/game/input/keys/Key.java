package com.lasacsgames.game.input.keys;

public class Key {

	private int keyCode;
	public boolean pressed;

	public Key(int code) {
		keyCode = code;
	}

	public void update(boolean[] keys) {
		pressed = keys[keyCode];
	}

	public boolean isPressed() {
		return pressed;
	}
}
