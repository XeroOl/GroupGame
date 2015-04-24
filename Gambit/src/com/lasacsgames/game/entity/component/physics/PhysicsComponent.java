package com.lasacsgames.game.entity.component.physics;

import com.lasacsgames.game.entity.Entity;

public abstract class PhysicsComponent
{
	public PhysicsComponent()
	{
	}

	public abstract void update(Entity ent);
}
