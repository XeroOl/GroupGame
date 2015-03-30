package com.lasacsgames.game.level;

import java.util.Random;

public class RandomizedLevel extends Level {
	Random r;

	public RandomizedLevel(int width, int height) {
		setDimension(width, height);
		r = new Random();
		generateLevel();

	}

	public RandomizedLevel(int width, int height, int seed) {
		setDimension(width, height);
		generateLevel();
		r = new Random(seed);
	}

	protected void generateLevel() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < width; y++) {
				tiles[x][y] = r.nextBoolean() ? 0x00000000 : 0xffffffff;
			}
		}

		tiles = gol(9, 7);
		tiles = gol(7, 5);
		tiles = gol(9, 5);
	}

	protected int[][] gol(int numtosolid, int numtoair) {
		int[][] newTiles = new int[width][height];
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				newTiles[x][y] = tiles[x][y];
				if (getTile(x, y).solid()) {
					if (getNeighbors(x, y, 1, 0xffffffff) >= numtoair)
						newTiles[x][y] = 0xffffffff;
				} else {
					if (getNeighbors(x, y, 1, 0x00000000) >= numtosolid)
						newTiles[x][y] = 0x00000000;
				}
			}
		return newTiles;
	}

	protected int getNeighbors(int x, int y, int dist, int countme) {
		int count = 0;
		for (int x1 = x - dist; x1 <= x + dist; x1++) {
			for (int y1 = y - dist; y1 <= y + dist; y1++) {
				if (x1 != x || y1 != y) {
					if (getTileId(x1, y1) == countme) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public void connect(int x1, int y1, int x2, int y2) {
		int[][] weight = new int[width][height];
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				weight[x][y]=100000;
			}
		}
		weight[x1][y1]=0;
		process(x1, y1, weight);
		followWeight(x2,y2);

	}
	protected void followWeight(int x, int y){
		
	}
	protected void process(int x, int y, int[][] weight) {
		if (x > 0) {
			if (weight[x - 1][y] > weight[x][y]
					+ (getTileId(x, y) == 0 ? 4 : 1)) {
				weight[x - 1][y] = weight[x][y]
						+ (getTileId(x, y) == 0 ? 4 : 1);
				process(x - 1, y, weight);
			}
		}
		if (y > 0) {
			if (weight[x][y - 1] > weight[x][y]
					+ (getTileId(x, y) == 0 ? 4 : 1)) {
				weight[x][y - 1] = weight[x][y]
						+ (getTileId(x, y) == 0 ? 4 : 1);
				process(x, y - 1, weight);
			}
		}
		if (x <width-1) {
			if (weight[x +1][y] > weight[x][y]
					+ (getTileId(x, y) == 0 ? 4 : 1)) {
				weight[x + 1][y] = weight[x][y]
						+ (getTileId(x, y) == 0 ? 4 : 1);
				process(x + 1, y, weight);
			}
		}
		if (y <height-1) {
			if (weight[x ][y+1] > weight[x][y]
					+ (getTileId(x, y) == 0 ? 4 : 1)) {
				weight[x ][y+1] = weight[x][y]
						+ (getTileId(x, y) == 0 ? 4 : 1);
				process(x , y+1, weight);
			}
		}
	}
}
