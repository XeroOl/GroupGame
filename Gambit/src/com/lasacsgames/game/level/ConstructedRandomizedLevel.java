package com.lasacsgames.game.level;

public class ConstructedRandomizedLevel extends RandomizedLevel {
	public ConstructedRandomizedLevel(int width, int height) {
		super(width, height);
	}
	public ConstructedRandomizedLevel(int width, int height,int seed) {
		super(width, height,seed);
	}

	@Override
	protected void generateLevel() {

	}
}
