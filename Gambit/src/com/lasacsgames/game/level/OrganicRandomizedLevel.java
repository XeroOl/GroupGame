package com.lasacsgames.game.level;

import com.lasacsgames.game.entity.mob.GhostEnemy;
import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.graphics.Screen;

public class OrganicRandomizedLevel extends RandomizedLevel
{
	int borderwidth = 2;
	public Mob[] mobs;

	public OrganicRandomizedLevel(int width, int height)
	{
		super(width, height);
		borderwidth = 2;
		generateLevel();
		mobs = new Mob[20];
		for (int i = 0; i < mobs.length; i++)
		{
			mobs[i] = new GhostEnemy(0, 0, this);
			mobs[i].spawnRandomly();
		}
	}

	public OrganicRandomizedLevel(int width, int height, int seed)
	{
		super(width, height, seed);
		borderwidth = 2;
		generateLevel();
		mobs = new Mob[20];
		for (int i = 0; i < mobs.length; i++)
		{
			mobs[i] = new GhostEnemy(0, 0, this);
			mobs[i].spawnRandomly();
		}
	}

	public void update()
	{
		for (int i = 0; i < mobs.length; i++)
		{
			mobs[i].update();
		}
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		super.render(xScroll, yScroll, screen);
		for(int i=0;i<mobs.length;i++) {
			mobs[i].render(screen);
		}
	}
	protected void generateLevel()
	{
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
			{
				setTile(x, y, ROCK_ID);
			}

		int x = width / 2;
		int y = height / 2;

		branch(x, y, width, 0);
		branch(x, y, width, 1);
		branch(x, y, width, 2);
		branch(x, y, width, 3);
		removeWalls(ROCK_ID, GRASS_ID, 3.0, 2);
		removeWalls(ROCK_ID, GRASS_ID, 1.0, 1);
		removeWalls(GRASS_ID, ROCK_ID, 7.0, 0);
		addBorder();
		fixTextures();
	}

	public void addBorder()
	{
		int[][] newtiles = new int[width][height];
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
			{
				newtiles[x][y] = ROCK_ID;
			}
		for (int x = borderwidth; x < width - borderwidth; x++)
			for (int y = borderwidth; y < height - borderwidth; y++)
			{
				newtiles[x][y] = tiles[x][y];
				if (x == 0 && y == 0) System.out.println("HALP");
			}
		tiles = newtiles;
	}

	public void removeWalls(int wallId, int notwallId, double ratiotochange, int dist)
	{
		int[][] newtiles = new int[width][height];
		for (int x = 0; x < width; x++)
			for (int y = 0; y < height; y++)
			{
				newtiles[x][y] = ROCK_ID;
			}
		for (int x = borderwidth; x < width - borderwidth; x++)
			for (int y = borderwidth; y < height - borderwidth; y++)
			{
				newtiles[x][y] = tiles[x][y];
			}
		if (dist == 0)
			for (int x = borderwidth; x < width - borderwidth; x++)
				for (int y = borderwidth; y < height - borderwidth; y++)
				{
					if (tiles[x][y] == wallId)
					{
						int notcount = 0;
						int count = 0;
						if (tiles[x - 1][y] == wallId) count++;
						if (tiles[x + 1][y] == wallId) count++;
						if (tiles[x][y - 1] == wallId) count++;
						if (tiles[x][y + 1] == wallId) count++;
						if (tiles[x - 1][y] == notwallId) notcount++;
						if (tiles[x + 1][y] == notwallId) notcount++;
						if (tiles[x][y - 1] == notwallId) notcount++;
						if (tiles[x][y + 1] == notwallId) notcount++;
						if (count == 0 || notcount / (double) count > ratiotochange)
						{
							newtiles[x][y] = notwallId;
						}
					}
				}
		else
		{

			for (int x = dist + borderwidth; x < width - dist - borderwidth; x++)
			{
				for (int y = dist + borderwidth; y < height - dist - borderwidth; y++)
				{
					if (tiles[x][y] == wallId)
					{
						int count = 0;
						int notcount = 0;
						for (int x2 = x - dist; x2 < x + dist + 1; x2++)
						{
							for (int y2 = y - dist; y2 < y + dist + 1; y2++)
							{
								if (tiles[x2][y2] == notwallId)
								{
									notcount++;
								}
								if (tiles[x2][y2] == wallId)
								{
									count++;
								}
							}
						}
						if (count == 0 || notcount / (double) count > ratiotochange)
						{
							newtiles[x][y] = notwallId;
						}
					}
				}
			}

		}
		tiles = newtiles;
	}

	int total = 0;

	protected void branch(int x, int y, int dist)
	{
		branch(x, y, dist, r.nextInt(4));
	}

	protected void branch(int x, int y, int dist, int dir)
	{

		while (total < width * height / 2 && dist > 0)
		{
			dist--;
			total++;
			setTile(x, y, GRASS_ID);
			int dirtemp = (r.nextInt(3) + dir + 3) % 4;
			switch (dirtemp)
			{
				case 0:
					if (x > borderwidth)
					{
						x--;
					}
					break;
				case 1:
					if (x < width - borderwidth - 1)
					{
						x++;
					}
					break;
				case 2:
					if (y > borderwidth)
					{
						y--;
					}
					break;
				case 3:
					if (y < height - borderwidth - 1)
					{
						y++;
					}
			}
			setTile(x, y, GRASS_ID);
			if (r.nextInt(60) == 0)
			{

				explode(x, y, r.nextDouble() * 3);
			}
		}
	}

}
