package com.lasacsgames.game.entity.component.graphics;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public abstract class GraphicsComponent
{
	protected Sprite sprite;
	
	public GraphicsComponent()
	{
	}

	public abstract void update(Entity ent);
	
	public abstract void render(Entity ent, Screen screen);
}
