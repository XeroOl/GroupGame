package com.lasacsgames.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.lasacsgames.game.input.keys.Key;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[200];

	public static Key UP = new Key(KeyEvent.VK_W);
	public static Key LEFT = new Key(KeyEvent.VK_A);
	public static Key DOWN = new Key(KeyEvent.VK_S);
	public static Key RIGHT = new Key(KeyEvent.VK_D);
	public static Key ENTER = new Key(KeyEvent.VK_ENTER);

	public void update() {
		UP.update(keys);
		LEFT.update(keys);
		DOWN.update(keys);
		RIGHT.update(keys);
		ENTER.update(keys);
	}


	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;

	}

	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;

	}
	
	public void keyTyped(KeyEvent arg0) {
		// ODO Auto-generated method stub

	}

}
