package com.lasacsgames.game.entity.particle;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.input.Mouse;

public class CrossHair extends Particle
{

	Mouse m;
	Sprite mySprite = Sprite.CROSSHAIR_SPRITE;
	private int xoffset;
	private int yoffset;
	public CrossHair(Mouse myMouse)
	{
		xoffset=8;
		yoffset=8;
		m = myMouse;
	}

	public void update()
	{
	}

	public void render(Screen screen)
	{
		location = m.getLocation();
		screen.renderEntity((location.x-xoffset),( location.y-yoffset),mySprite);
	}

}
