package com.lasacsgames.game.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lasacsgames.game.level.tile.Tile;

public class Screen
{
	public int[] pixels;
	public int width, height;
	public int xOffSet, yOffSet;
public BufferedImage me;
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

	public void renderTile(int xp, int yp, Tile tile,Graphics g)
	{
		xp -= xOffSet;
		yp -= yOffSet;
		g.drawImage(tile.sprite., , dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
	}

	public void renderEntity(double d, double e, Sprite sprite)
	{
		d -= xOffSet;
		e -= yOffSet;
		for (int y = 0; y < sprite.SIZE; y++)
		{
			int ya = y + e;
			for (int x = 0; x < sprite.SIZE; x++)
			{
				int xa = x + d;

				if (xa < -16 || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}

	public void renderPlayer(double d, double e, Sprite sprite, int flip)
	{
		d -= xOffSet;
		e -= yOffSet;
		for (int y = 0; y < sprite.SIZE; y++)
		{
			int ya = y + e;
			int ys = y;
			if (flip == 2 || flip == 3) ys = sprite.SIZE - 1 - y;
			for (int x = 0; x < sprite.SIZE; x++)
			{
				int xa = x + d;
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
