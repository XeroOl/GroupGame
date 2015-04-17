package com.lasacsgames.game.physics;

public class Vector
{

	public double x, y;

	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public Vector()
	{
		x = 0;
		y = 0;
	}

	public void add(Vector v)
	{
		this.x += v.x;
		this.y += v.y;
	}

	public void multiply(double factor)
	{
		this.x *= factor;
		this.y *= factor;
	}
	public double length(){
		return java.awt.Point.distance(0, 0, x, y);
	}
}
