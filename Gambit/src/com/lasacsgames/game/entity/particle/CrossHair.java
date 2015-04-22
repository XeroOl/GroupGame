package com.lasacsgames.game.entity.particle;

import com.lasacsgames.game.graphics.Screen;
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
	}

	public void render(Screen screen)
	{
		location = m.getLocation();
		screen.renderEntity((int) (location.x - 8), (int) (location.y - 8), sprite);
	}

}
