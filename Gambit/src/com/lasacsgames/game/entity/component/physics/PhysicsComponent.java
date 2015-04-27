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

		if (!collision(ent, ent.vector.x, 0))
		{
			ent.location.x += ent.vector.x;
		}
		if (!collision(ent, 0, ent.vector.y))
		{
			ent.location.y += ent.vector.y;
		}
	}
	
	public boolean collision(Entity ent, double xa, double ya)
	{
		if (!ent.collidable) return false;
		boolean b = false;
		for (int i = 0; i < 4; i++)
		{
			int x = (i / 2) * (ent.size.width - 1);
			int y = (i % 2) * (ent.size.height - 1);
			if (ent.level.getTile((((int) (ent.location.x + xa - ent.size.width / 2 + x)) >> 4), (((int) (ent.location.y + ya - ent.size.height / 2 + y) >> 4))).solid()) b = true;
		}
		return b;
	}
}
