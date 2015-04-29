package com.lasacsgames.game.entity.particle;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.physics.Point;

public abstract class Particle extends Entity
{
	protected Sprite sprite;

	public Particle()
	{
		location = new Point(0,0);
		collidable = false;
	}
	public void render(Screen screen)
	{
		int offset = sprite.SIZE/2;
		screen.renderEntity((int) (
				location.x-offset),
				(int) (location.y - offset)
				, sprite);
	}
}
