package com.lasacsgames.game.entity.component.graphics;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.graphics.Screen;

public abstract class GraphicsComponent
{
	public GraphicsComponent()
	{
	}

	public abstract void update(Entity ent, Screen screen);
	
	public abstract void render(Entity ent, Screen screen);
}
