package com.lasacsgames.game.level;

import java.util.Random;

public abstract class RandomizedLevel extends Level {
	Random r;
	public RandomizedLevel(int width, int height) {
		setDimension(width, height);
		r = new Random();

	}
	public RandomizedLevel(int width, int height, int seed) {
		setDimension(width, height);
		r = new Random(seed);

	}
	protected abstract void generateLevel();
}
