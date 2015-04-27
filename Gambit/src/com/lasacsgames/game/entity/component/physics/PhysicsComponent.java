package com.lasacsgames.game.entity.component.physics;

import com.lasacsgames.game.entity.Entity;

public abstract class PhysicsComponent
{
	public abstract void update(Entity ent);

	public void move(Entity ent)
	{
		if (ent.vector.y > 0) ent.dir = 2;
		if (ent.vector.y < 0) ent.dir = 0;
		if (ent.vector.x > 0) ent.dir = 1;
		if (ent.vector.x < 0) ent.dir = 3;

		if (!ent.collision(ent.vector.x, 0))
		{
			ent.location.x += ent.vector.x;
		}
		if (!ent.collision(0, ent.vector.y))
		{
			ent.location.y += ent.vector.y;
		}
	}
}
