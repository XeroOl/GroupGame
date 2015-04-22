package com.lasacsgames.game.entity.weapon;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.entity.mob.Mob;
import com.lasacsgames.game.physics.Point;

public abstract class Weapon extends Entity
{
	protected Mob owner;
	protected int reloadSpeed, recoilSpeed, recoilCurrent;

	// stored in 60ths of a second

	public abstract void fire(Point loc);
}
