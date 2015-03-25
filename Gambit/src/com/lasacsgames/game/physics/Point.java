package com.lasacsgames.game.physics;

public class Point
{

	public int x, y;

	public Point()
	{
		x = 0;
		y = 0;
	}

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
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
}
