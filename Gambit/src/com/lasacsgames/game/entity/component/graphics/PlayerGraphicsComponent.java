package com.lasacsgames.game.entity.component.graphics;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.graphics.Screen;

public class PlayerGraphicsComponent extends GraphicsComponent
{
	boolean walking = false;
	
	public void update(Entity ent, Screen screen)
	{
		walking = (ent.vector.x != 0 || ent.vector.y != 0) ? true : false;
	}

	public void render(Entity ent, Screen screen)
	{
		// TODO Auto-generated method stub
		
	}

}
