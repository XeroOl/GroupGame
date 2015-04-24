package com.lasacsgames.game.entity.component.input;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.input.Mouse;

public abstract class InputComponent
{
	public InputComponent()
	{
	}

	public abstract void update(Entity ent, Keyboard key, Mouse mouse);
}
