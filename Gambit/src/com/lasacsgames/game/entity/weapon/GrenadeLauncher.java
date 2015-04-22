package com.lasacsgames.game.entity.weapon;

import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.entity.projectile.Grenade;
import com.lasacsgames.game.entity.projectile.Projectile;

public class GrenadeLauncher extends Gun
{

	public GrenadeLauncher(Mob owner)
	{
		super(owner);
		bullets = new Projectile[clipMax];
		for (int i = 0; i < bullets.length; i++)
		{
			bullets[i] = new Grenade(this.owner, 1.0);
			bullets[i].remove();
		}
	}

}
