package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.graphics.Sprite;

public abstract class Mob extends Entity
{

	public Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move()
	{
		if (vector.y > 0)
			dir = 2;
		if (vector.y < 0)
			dir = 0;
		if (vector.x > 0)
			dir = 1;
		if (vector.x < 0)
			dir = 3;

		if (!collision(vector.x, 0))
		{
			location.x += vector.x;
		}
		if (!collision(0, vector.y))
		{
			location.y += vector.y;
		}

	}

	public void update()
	{
	}

	public boolean collision(double xa, double ya)
	{
		boolean b = false;
		for (int i = 0; i < 4; i++)
		{
			int x = (i / 2) * 7;
			int y = (i % 2) * 7;
			if (getLevel().getTile((((int) (location.x + xa - 4 + x)) >> 4), (((int) (location.y + ya - 4 + y) >> 4))).solid())
				b = true;
		}
		return b;
	}

	public void render()
	{
	}

	public boolean aabbCollision(Mob obj)
	{
		return false;

	}
}
