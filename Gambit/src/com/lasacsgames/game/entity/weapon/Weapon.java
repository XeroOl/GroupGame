package com.lasacsgames.game.entity.weapon;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.entity.projectile.Grenade;
import com.lasacsgames.game.entity.projectile.Projectile;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.physics.Point;

public abstract class Weapon extends Entity
{
	private Mob owner;
	private int clipMax, clipCurrent;
	private int reserve;
	private int reloadSpeed, recoil, recoilCurrent;
	// stored in 60ths of a second
	protected Projectile[] bullets;

	// allows player to only store certain amounts of bullets
	// eventually add a sprite to show in the player's hand and/or the HUD

	public Weapon(Mob owner)
	{
		super();
		this.owner = owner;
		clipMax = clipCurrent = 8;
		reserve = 16;
		reloadSpeed = 45;
		recoil = 15;
		recoilCurrent = 0;
		bullets = new Projectile[clipMax];
		for (int i = 0; i < bullets.length; i++)
		{
			bullets[i] = new Grenade(this.owner, 7);
			bullets[i].remove();
		}
	}

	public void update()
	{
		if (recoilCurrent > 0) recoilCurrent--;
		if (clipCurrent == 0) reload();

		for (int i = 0; i < bullets.length; i++)
		{
			if (!bullets[i].isRemoved()) bullets[i].update();
		}
	}

	public void render(Screen screen)
	{
		for (int i = 0; i < bullets.length; i++)
		{
			if (!bullets[i].isRemoved()) bullets[i].render(screen);
		}
	}

	public void shoot(Point loc)
	{
		if (recoilCurrent != 0) return;
		for (int i = 0; i < bullets.length; i++)
		{
			if (bullets[i].isRemoved())
			{
				bullets[i].respawn(loc);
				recoilCurrent = recoil;
				// clipCurrent--;
				return;
			}
		}
	}

	public void reload()
	{
		recoil = reloadSpeed;
		if (reserve == 0) return;
		if (reserve > clipMax)
		{
			clipCurrent = clipMax;
			reserve -= clipMax;
		}
		else
		{
			clipCurrent = reserve;
			reserve = 0;
		}
	}
}
