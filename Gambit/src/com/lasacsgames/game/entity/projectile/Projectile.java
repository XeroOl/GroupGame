package com.lasacsgames.game.entity.projectile;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.physics.Point;
import com.lasacsgames.game.physics.Vector;

public abstract class Projectile extends Entity
{

	private Mob owner;
	protected Sprite sprite;
	double speed;

	public Projectile(Mob owner)
	{
		this.owner = owner;
		level = owner.level;
		location = owner.getLocation().clone();
		vector = new Vector();
		chooseDirection();
		vector.add(owner.vector);

	}

	public void update()
	{
		if (isRemoved()) return;
		move();
		if (collision()) remove();
	}

	public void move()
	{
		location.x += vector.x;
		location.y += vector.y;
	}
	@Deprecated
	public void respawn()
	{
		location = owner.getLocation().clone();
		vector = new Vector();
		chooseDirection();
		recreate();
	}
@Deprecated
	public void chooseDirection()
	{

		if (owner.dir == 0) vector.y = -speed;
		if (owner.dir == 1) vector.x = speed;
		if (owner.dir == 2) vector.y = speed;
		if (owner.dir == 3) vector.x = -speed;
	}

	public boolean collision()
	{
		if (!collidable) return false;
		boolean b = false;
		for (int i = 0; i < 4; i++)
		{
			int x = (i / 2) * 3;
			int y = (i % 2) * 3;
			if (level.getTile((((int) (location.x - 2 + x)) >> 4), (((int) (location.y - 2 + y) >> 4))).solid()) b = true;
		}
		return b;
	}

	public void respawn(Point target)
	{
		location = owner.getLocation().clone();
		vector = location.towards(target,speed);

		
		recreate();
		
	}
}
