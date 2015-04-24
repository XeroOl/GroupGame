package com.lasacsgames.game.entity;

import java.awt.Dimension;
import java.util.Random;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.physics.Point;
import com.lasacsgames.game.physics.Vector;

public abstract class Entity
{

	public Point location;
	public Vector vector;
	public Level level;
	protected final Random random = new Random();
	public Dimension size;

	// Entity properties
	private boolean removed = false;
	public boolean drawable = true;
	public boolean moveable = true;
	protected boolean moving = false;
	public boolean collidable = true;
	public int dir = 0;

	public abstract void update();
	public abstract void render(Screen screen);


	public void remove()
	{
		// Remove from level
		removed = true;
	}

	public void recreate()
	{
		removed = false;
	}

	public boolean isRemoved()
	{
		return removed;
	}

	public Point getLocation()
	{
		return location;
	}

	public void setLocation(Point location)
	{
		this.location = location;
	}
	
	public boolean collision(double xa, double ya)
	{
		if (!collidable) return false;
		boolean b = false;
		for (int i = 0; i < 4; i++)
		{
			int x = (i / 2) * (size.width - 1);
			int y = (i % 2) * (size.height - 1);
			if (level.getTile((((int) (location.x + xa - size.width / 2 + x)) >> 4), (((int) (location.y + ya - size.height / 2 + y) >> 4))).solid()) b = true;
		}
		return b;
	}
}
