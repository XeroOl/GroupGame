package com.lasacsgames.game.entity.projectile;

import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public class Grenade extends Projectile
{

	public Grenade(Mob owner, double d)
	{
		super(owner, d);
		sprite = Sprite.bullet;
	}

	public void remove()
	{
		super.remove();
		level.explode((int) location.x / 16, (int) location.y / 16, 4.1);

	}

	public void render(Screen screen)
	{
		if (drawable) screen.renderEntity((int) location.x - 8, (int) location.y - 8, sprite);

	}

}