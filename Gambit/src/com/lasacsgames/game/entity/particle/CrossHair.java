package com.lasacsgames.game.entity.particle;

import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.input.Mouse;

public class CrossHair extends Particle
{

	private Mouse m;

	public CrossHair(Mouse myMouse)
	{
		m = myMouse;
		sprite = Sprite.CROSSHAIR_SPRITE;
	}

	public void update()
	{
		location = m.getLocation();
	}

	

}
