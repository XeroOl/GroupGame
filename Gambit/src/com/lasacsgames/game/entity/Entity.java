package com.lasacsgames.game.entity;

import java.awt.Dimension;
import java.util.Random;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.physics.Point;
import com.lasacsgames.game.physics.Vector;

public abstract class Entity
{

	protected Point location;
	public Vector vector;
	public Level level;
	protected final Random random = new Random();
	public Dimension size;

	// Entity properties
	private boolean removed = false;
	public boolean drawable = true;
	protected boolean moveable = true;
	protected boolean moving = false;
	protected boolean collidable = true;
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
}
