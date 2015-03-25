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
		for(int x = 0; x<width;x++){
			for(int y = 0; y<width; y++){
				tiles[x][y]=0x00000000;
			}
		}
		// PLACEHOLDER GENERATOR, DO NOT ATTEMPT TO UNDERSTAND
		int tilesleft = width * height / 2;
		int x = r.nextInt(width);
		int y = r.nextInt(height);
		for (int i = 0; i < tilesleft; i++) {
			tiles[x][y] = 0xffffffff;
			int dir = r.nextInt(4);
			if (dir == 0 && x != 0) {
				x--;
			}
			if (dir == 1 && y != 0) {
				y--;
			}
			if (dir == 2 && x < width - 1) {
				x++;
			}
			if (dir == 3 && y < height - 1) {
				y++;
			}
		}
	}

}
