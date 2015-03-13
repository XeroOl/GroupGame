package com.lasacsgames.game.graphics;

public class Screen {

	public int[] pixels;
	public int width, height;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
}
