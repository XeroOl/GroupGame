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
	
	public void render(Screen screen) {
		screen.renderPellet(location.x, location.y, sprite, drawable);
	}

}
