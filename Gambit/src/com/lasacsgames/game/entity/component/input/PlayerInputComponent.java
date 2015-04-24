package com.lasacsgames.game.entity.component.input;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.input.Mouse;

public class PlayerInputComponent extends InputComponent
{

	@Override
	public void update(Entity ent, Keyboard key, Mouse mouse)
	{
		ent.vector.x = 0;
		ent.vector.y = 0;
		
		if (key.UP) ent.vector.y--;
		if (key.DOWN) ent.vector.y++;
		if (key.LEFT) ent.vector.x--;
		if (key.RIGHT) ent.vector.x++;
		if (key.BACKSLASH && !key.tempCodeFix) ent.collidable = !ent.collidable;
		
	}

}
