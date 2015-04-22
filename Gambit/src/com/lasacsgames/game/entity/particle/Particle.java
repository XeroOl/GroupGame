package com.lasacsgames.game.entity.particle;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.graphics.Sprite;

public abstract class Particle extends Entity
{
	protected Sprite sprite;

	public Particle()
	{
		collidable = false;
	}
}
