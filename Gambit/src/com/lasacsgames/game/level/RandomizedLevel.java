package com.lasacsgames.game.level;

import java.util.Random;

public class RandomizedLevel extends Level {
	Random r;

	public RandomizedLevel(int width, int height) {
		setDimension(width, height);
		generateLevel();
		r = new Random();
	}

	public RandomizedLevel(int width, int height, int seed) {
		setDimension(width, height);
		generateLevel();
		r = new Random(seed);
	}

	protected void generateLevel() {
		// PLACEHOLDER GENERATOR, DO NOT ATTEMPT TO UNDERSTAND
		int tilesleft = width * height / 2;
	}

}
