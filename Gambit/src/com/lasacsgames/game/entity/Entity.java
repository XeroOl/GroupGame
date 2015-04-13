package com.lasacsgames.game.entity;

import java.awt.Dimension;
import java.util.Random;

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
	protected boolean moveable = true;
	protected boolean moving = false;
	protected boolean collidable = true;
	public int dir = 0;

	public void update()
	{
	}

	public void render()
	{
	}

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
}
