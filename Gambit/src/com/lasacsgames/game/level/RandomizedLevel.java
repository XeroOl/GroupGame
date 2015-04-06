package com.lasacsgames.game.level;

import java.util.Random;

import com.lasacsgames.game.level.tile.Tile;

public class RandomizedLevel extends Level {
	Random r;

	public RandomizedLevel(int width, int height) {
		setDimension(width, height);
		r = new Random();
		generateLevel();

	}

	public RandomizedLevel(int width, int height, int seed) {
		setDimension(width, height);
		r = new Random(seed);
		generateLevel();

	}

	protected void generateLevel() {
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				setTile(x, y, FLOWER_ID);
			}

		int x = width / 2;
		int y = height / 2;
		branch(x, y, width * height / 4);
		branch(x, y, width * height / 4);
		branch(x, y, width * height / 4);
		branch(x, y, width * height / 4);
		removeWalls(FLOWER_ID, GRASS_ID, 3.0, 2);
		removeWalls(FLOWER_ID, GRASS_ID, 1.0, 1);
	}

	public void removeWalls(int wallId, int notwallId, double ratiotochange,
			int dist) {
		int[][] newtiles = new int[width][height];
		if (dist == 0)
			for (int x = 1; x < width - 1; x++)
				for (int y = 1; y < height - 1; y++) {
					if (tiles[x][y] == wallId) {
						int notcount = 0;
						int count = 0;
						if (tiles[x - 1][y] == wallId)
							count++;
						if (tiles[x + 1][y] == wallId)
							count++;
						if (tiles[x][y - 1] == wallId)
							count++;
						if (tiles[x][y + 1] == wallId)
							count++;
						if (tiles[x - 1][y] == notwallId)
							notcount++;
						if (tiles[x + 1][y] == notwallId)
							notcount++;
						if (tiles[x][y - 1] == notwallId)
							notcount++;
						if (tiles[x][y + 1] == notwallId)
							notcount++;
						if (count != 0
								&& notcount / (double) count > ratiotochange) {
							newtiles[x][y] = notwallId;
						}
					}
				}
		else {

			for (int x = dist; x < width - dist; x++) {
				for (int y = dist; y < height - dist; y++) {
					newtiles[x][y] = tiles[x][y];
					if (tiles[x][y] == wallId) {
						int count = 0;
						int notcount = 0;
						for (int x2 = x - dist; x2 < x + dist + 1; x2++) {
							for (int y2 = y - dist; y2 < y + dist + 1; y2++) {
								if (tiles[x2][y2] == notwallId) {
									notcount++;
								}
								if (tiles[x2][y2] == wallId) {
									count++;
								}
							}
						}
						if (count == 0
								|| notcount / (double) count > ratiotochange) {
							newtiles[x][y] = notwallId;
						}
					}
				}
			}

		}
		tiles = newtiles;
	}

	int total = 0;

	protected void branch(int x, int y, int dist) {
		int dir = r.nextInt(4);
		while (total < width * height / 2 && dist > 0) {
			dist--;
			total++;
			setTile(x, y, GRASS_ID);
			int dirtemp = (r.nextInt(3) + dir + 3) % 4;
			switch (dirtemp) {
			case 0:
				if (x > 0) {
					x--;
				}
				break;
			case 1:
				if (x < width - 1) {
					x++;
				}
				break;
			case 2:
				if (y > 0) {
					y--;
				}
				break;
			case 3:
				if (y < height - 1) {
					y++;
				}
			}
			if (r.nextInt(8) == 0) {
				branch(x, y, r.nextInt(width * height / 20));
			}
		}
	}
}
