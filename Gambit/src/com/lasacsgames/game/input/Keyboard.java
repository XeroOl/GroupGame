package com.lasacsgames.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[200];
	public boolean UP, LEFT, DOWN, RIGHT, ENTER, SPACE;

	public void update() {
		UP = keys[KeyEvent.VK_UP];
		LEFT = keys[KeyEvent.VK_LEFT];
		RIGHT = keys[KeyEvent.VK_RIGHT];
		DOWN = keys[KeyEvent.VK_DOWN];
		ENTER = keys[KeyEvent.VK_ENTER];
		SPACE = keys[KeyEvent.VK_SPACE];
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
