package com.lasacsgames.game.entity.projectile;

import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public class Pellet extends Projectile
{

	public Pellet(Mob owner, int speed)
	{
		super(owner, speed);
		sprite = Sprite.bullet;
	}

	public void remove()
	{
		super.remove();
	}

	public void render(Screen screen)
	{
		if (drawable) screen.renderEntity((int) location.x - 8, (int) location.y - 8, sprite);
	}
}
