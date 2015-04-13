package com.lasacsgames.game.graphics;

import com.lasacsgames.game.level.tile.Tile;

public class Screen
{
	public int[] pixels;
	public int width, height;
	public int xOffSet, yOffSet;

	public Screen(int width, int height)
	{
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear()
	{
		for (int i = 0; i < pixels.length; i++)
		{
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile)
	{
		xp -= xOffSet;
		yp -= yOffSet;
		for (int y = 0; y < tile.sprite.SIZE; y++)
		{
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++)
			{
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void renderEntity(int xp, int yp, Sprite sprite)
	{
		xp -= xOffSet;
		yp -= yOffSet;
		for (int y = 0; y < sprite.SIZE; y++)
		{
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++)
			{
				int xa = x + xp;

				if (xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite, int flip)
	{
		xp -= xOffSet;
		yp -= yOffSet;
		for (int y = 0; y < sprite.SIZE; y++)
		{
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3) ys = sprite.SIZE - 1 - y;
			for (int x = 0; x < sprite.SIZE; x++)
			{
				int xa = x + xp;
				int xs = x;
				if (flip == 1 || flip == 3) xs = sprite.SIZE - 1 - x;
				if (xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[xs + ys * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void setOffSet(int xOffSet, int yOffSet)
	{
		this.xOffSet = xOffSet;
		this.yOffSet = yOffSet;
	}

}
