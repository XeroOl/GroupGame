package com.lasacsgames.game.graphics;

import java.awt.Graphics;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.entity.mob.Creature;
import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.entity.projectile.Projectile;
import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.level.tile.Tile;

public class Screen
{
	public int[] pixels;
	public int width, height;
	public int xOffSet, yOffSet;
	int scale;

	public Screen(int width, int height, int scale)
	{
		this.scale = scale;
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

	public void renderLevel(Level l, Graphics g)
	{

		for (int x = xOffSet / Tile.SIZE / scale - 1; x <= (xOffSet + width) / Tile.SIZE / scale; x++)
		{
			for (int y = yOffSet / Tile.SIZE / scale - 1; y <= (yOffSet + height) / Tile.SIZE / scale; y++)
			{
				g.drawImage(l.getTile(x, y).sprite.myImage, x * Tile.SIZE * scale - xOffSet, y * Tile.SIZE * scale - yOffSet, Tile.SIZE * scale, Tile.SIZE * scale, null);
			}
		}

	}

	public void renderSprite(double x, double y, Sprite sprite, Graphics g)
	{
		g.drawImage(sprite.myImage, (int) ((x * scale) - xOffSet), (int) ((y * scale) - yOffSet), sprite.SIZE * scale, sprite.SIZE * scale, null);
	}

	public void renderEntity(Entity e, Graphics g)
	{
		g.drawImage(e.sprite.myImage, (int) ((e.getLocation().x * scale) - xOffSet), (int) ((e.getLocation().y * scale) - yOffSet), e.sprite.SIZE * scale, e.sprite.SIZE * scale, null);
	}

	public void renderCreature(Creature e, Graphics g)
	{
		renderMob(e,g);
		for (Projectile p : e.weapon.getBullets())
		{
			if (!p.isRemoved()) renderEntity(p, g);
		}
	}

	public void renderMob(Mob e, Graphics g)
	{
		g.drawImage(e.sprite.myImage, (int) (((e.getLocation().x-e.spriteOffset.x )* scale) - xOffSet), (int) (((e.getLocation().y-e.spriteOffset.y)* scale) - yOffSet), e.sprite.SIZE * scale, e.sprite.SIZE * scale, null);
	}

	public void setOffSet(int xOffSet, int yOffSet)
	{
		this.xOffSet = xOffSet;
		this.yOffSet = yOffSet;
	}

}
