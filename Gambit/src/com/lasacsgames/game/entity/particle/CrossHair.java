package com.lasacsgames.game.entity.particle;

import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.input.Mouse;
import com.lasacsgames.game.physics.Point;

public class CrossHair extends Particle
{

	Mouse m;

	public CrossHair(Mouse myMouse)
	{
		m = myMouse;
		sprite = Sprite.CROSSHAIR_SPRITE;
		location = m.getLocation();
	}

	public Point getLocation()
	{
		return m.getLocation();
	}

	public void update()
	{
	}
}
