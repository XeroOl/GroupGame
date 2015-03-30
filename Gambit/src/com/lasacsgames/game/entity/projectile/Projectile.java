package com.lasacsgames.game.entity.projectile;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.physics.Vector;

public abstract class Projectile extends Entity
{

	public Mob owner;

	public Projectile(Mob owner, int speed)
	{
		level = owner.level;
		location = owner.location.clone();
		vector = new Vector();
		if (owner.dir == 0)
		{
			vector.x = speed;
		}
		if (owner.dir == 1)
		{
			vector.y = -speed;
		}
		if (owner.dir == 2)
		{
			vector.x = -speed;
		}
		if (owner.dir == 3)
		{
			vector.y = speed;
		}
		vector.add(owner.vector);

	}

	public void update()
	{
		move();
	}

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

		location.x += vector.x;
		location.y += vector.y;

	}
}
