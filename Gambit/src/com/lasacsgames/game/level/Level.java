package com.lasacsgames.game.level;

public abstract class Level {

	protected int width, height;
	protected int[][] tiles;

	public Level() {
	}

	public void setWidth(int width) {
		this.width = width;
		tiles = new int[width][height];
	}

	public void setHeight(int height) {
		this.height=height;
		tiles = new int[width][height];
	}
	public void setDimension(int width, int height){
		this.width = width;
		this.height=height;
		tiles = new int[width][height];
	}
}
