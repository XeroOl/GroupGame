package com.lasacsgames.game.level;

public class OrganicRandomizedLevel extends RandomizedLevel {

	public OrganicRandomizedLevel(int width, int height) {
		super(width, height);

	}

	public OrganicRandomizedLevel(int width, int height, int seed) {
		super(width, height, seed);

	}

	protected void generateLevel() {
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++) {
				setTile(x, y, ROCK_ID);
			}

		int x = width / 2;
		int y = height / 2;

		branch(x, y, width * height / 4, 0);
		branch(x, y, width * height / 4, 1);
		branch(x, y, width * height / 4, 2);
		branch(x, y, width * height / 4, 3);
		removeWalls(ROCK_ID, GRASS_ID, 3.0, 2);
		removeWalls(ROCK_ID, GRASS_ID, 1.0, 1);
		fixTextures();
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
		branch(x, y, dist, r.nextInt(4));
	}

	protected void branch(int x, int y, int dist, int dir) {

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
			setTile(x, y, GRASS_ID);
			if (r.nextInt(40) == 0) {
				branch(x, y, r.nextInt(width * height / 20),
						r.nextBoolean() ? dir + 1 : dir - 1);
			}
		}
	}

	public void fixTextures() {
		for (int x = 1; x < width - 1; x++)
			for (int y = 1; y < height - 1; y++) {
				if (tiles[x][y] == ROCK_ID) {
					int surround = 0;
					if (tiles[x][y - 1] == GRASS_ID)
						surround += 1;//up
					if (tiles[x][y + 1] == GRASS_ID)
						surround += 2;//down
					if (tiles[x - 1][y] == GRASS_ID)
						surround += 4;//left
					if (tiles[x + 1][y] == GRASS_ID)
						surround += 8;//right
					switch (surround) {
					case 0:
						variation[x][y] = 0;
						if (tiles[x + 1][y - 1] == GRASS_ID)
							variation[x][y] = 9;
						if (tiles[x - 1][y - 1] == GRASS_ID)
							variation[x][y] = 10;
						if (tiles[x + 1][y + 1] == GRASS_ID)
							variation[x][y] = 11;
						if (tiles[x - 1][y + 1] == GRASS_ID)
							variation[x][y] = 12;
						break;
					case 1:
						variation[x][y] = 1;break;
					case 2:
						variation[x][y] = 5;break;
					case 3:
					case 7:
					case 11:
					case 12:
					case 13:
					case 14:
					case 15:
						variation[x][y] = 13;break;
					case 4:
						variation[x][y] = 7;break;
					case 5:
						variation[x][y]=8;break;
					case 6:variation[x][y]=6;break;
					case 8:variation[x][y]=3;break;
					case 9:variation[x][y]=2;break;
					case 10:variation[x][y]=4;break;
					
					}
				}
			}
	}
}
