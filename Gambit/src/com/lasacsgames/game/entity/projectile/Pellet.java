package com.lasacsgames.game.entity.projectile;

import com.lasacsgames.game.entity.mob.Mob;
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

}
