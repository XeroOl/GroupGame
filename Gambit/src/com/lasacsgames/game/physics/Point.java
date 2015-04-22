package com.lasacsgames.game.physics;

public class Point
{

	public double x, y;

	public Point()
	{
		x = 0;
		y = 0;
	}

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	// Takes an actual Point and makes a point out of it
	public Point(java.awt.Point pos)
	{
		this((int) pos.getX(), (int) pos.getY());
	}

	public static Point add(Point p1, Point p2)
	{
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	public void add(Point p)
	{
		x += p.x;
		y += p.y;
	}

	public static Point subtract(Point p1, Point p2)
	{
		return new Point(p1.x - p2.x, p1.y - p2.y);
	}

	public void subtract(Point p)
	{
		x -= p.x;
		y -= p.y;
	}

	public Point clone()
	{
		return new Point(x, y);
	}

	public Vector towards(Point p, double speed)
	{
		Vector v = new Vector(p.x - x, p.y - y);
		v.multiply(speed / v.length());
		return v;
	}

}
