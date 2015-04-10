package com.lasacsgames.game.entity.projectile;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.physics.Vector;

public abstract class Projectile extends Entity
{

	private Mob owner;
	protected Sprite sprite;
	int speed;

	public Projectile(Mob owner, int speed)
	{
		this.speed = speed;
		this.owner = owner;
		level = owner.level;
		location = owner.location.clone();
		vector = new Vector();

		if (owner.dir == 0)
		{
			vector.y = -speed;
		}
		if (owner.dir == 1)
		{
			vector.x = speed;
		}
		if (owner.dir == 2)
		{
			vector.y = speed;
		}
		if (owner.dir == 3)
		{
			vector.x = -speed;
		}
		vector.add(owner.vector);

	}

	public void update()
	{
		if (isRemoved())
			return;
		move();
		if (collision())
			remove();

	}

	public void render(Screen screen)
	{

	}

	public void move()
	{
		/*
		 * if (vector.y > 0) dir = 2; if (vector.y < 0) dir = 0; if (vector.x >
		 * 0) dir = 1; if (vector.x < 0) dir = 3;
		 */
		location.x += vector.x;
		location.y += vector.y;

	}

	public void respawn()
	{
		location = owner.location.clone();
		vector = new Vector();
		if (owner.dir == 0)
		{
			vector.y = -speed;
		}
		if (owner.dir == 1)
		{
			vector.x = speed;
		}
		if (owner.dir == 2)
		{
			vector.y = speed;
		}
		if (owner.dir == 3)
		{
			vector.x = -speed;
		}
		recreate();
	}

	public boolean collision()
	{
		if (!collidable)
			return false;
		boolean b = false;
		for (int i = 0; i < 4; i++)
		{
			int x = (i / 2) * 7;
			int y = (i % 2) * 7;
			if (getLevel().getTile((((int) (location.x - 4 + x)) >> 4), (((int) (location.y - 4 + y) >> 4))).solid())
				b = true;
		}
		return b;

	}
}
