package com.lasacsgames.game.level;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.level.tile.Tile;

public abstract class Level {

	public int width;
	public int height;
	protected int[][] tiles;
	public static final int VOID_ID = 0;
	public static final int GRASS_ID = 0xffffffff;
	public static final int ROCK_ID = 0xff000000;
	public Level() {
	}

	public void setWidth(int width) {
		this.width = width;
		tiles = new int[width][height];
	}

	public void setHeight(int height) {
		this.height = height;
		tiles = new int[width][height];
	}

	public void setDimension(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width][height];
	}

	public void update() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffSet(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}

	}

	public int getTileId(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return VOID_ID;
		return tiles[x][y];
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.VOID_TILE;
		switch(tiles[x][y]){
		case VOID_ID:
			return Tile.VOID_TILE;
		case GRASS_ID:
			return Tile.GRASS_TILE;
		case ROCK_ID:
			return Tile.ROCK_TILE;
		default:
			return Tile.VOID_TILE;
		}
	}

	public void setTile(int x, int y, int id) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return;
		tiles[x][y]=id;
	}

}
