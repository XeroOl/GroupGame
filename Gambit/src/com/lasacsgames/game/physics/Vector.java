package com.lasacsgames.game.physics;

public class Vector
{

	public double x, y;

	public Vector(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void add(Vector v)
	{
		this.x += v.x;
		this.y += v.y;
	}
}
