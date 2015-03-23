package com.lasacsgames.game.level;

public abstract class Level {

	protected int width, height;
	protected int[] tiles;

	public Level(String path) {
		load(path);
		generateLevel();
	}

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		generateLevel();
	}

	protected void load(String path) {

	}

	protected void generateLevel() {

	}
}
