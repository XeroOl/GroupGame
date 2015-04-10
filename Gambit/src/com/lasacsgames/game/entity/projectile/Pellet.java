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

	public void render(Screen screen)
	{
		if(drawable) screen.renderPellet(location.x - 8, location.y - 8, sprite);
	}
}
