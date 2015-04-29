package com.lasacsgames.game.entity.particle;

import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.physics.Point;
import com.lasacsgames.game.physics.Vector;

public class Explosion extends Particle
{
	
	int decay = 15;

	public Explosion(double x, double y, Vector sped)
	{
		location = new Point(x,y);
		vector = sped;
		sprite=Sprite.BRICK_SPRITE;
	}

	public void update()
	{
		location.add(vector);
		vector.x*=decay/15.0;
		vector.y*=decay/15.0;
		decay--;
		if(decay==5){
			remove();
		}
	}


}
