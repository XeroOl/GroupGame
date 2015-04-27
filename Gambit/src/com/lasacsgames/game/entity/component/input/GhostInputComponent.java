package com.lasacsgames.game.entity.component.input;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.input.Mouse;

public class GhostInputComponent extends InputComponent
{
	private int walkTime = 0;

	@Override
	public void update(Entity ent, Keyboard key, Mouse mouse)
	{
		if (ent.collision(ent.vector.x, ent.vector.y)) walkTime = 0;
		if (walkTime == 0)
		{
			walkTime = ent.random.nextInt(120) + 30;
			ent.dir++;
			if (ent.dir > 3) ent.dir = 0;

			switch (ent.dir)
			{
				case 0:
					ent.vector.x = 1;
					ent.vector.y = 0;
					break;
				case 1:
					ent.vector.x = 0;
					ent.vector.y = -1;
					break;
				case 2:
					ent.vector.x = -1;
					ent.vector.y = 0;
					break;
				case 3:
					ent.vector.x = 0;
					ent.vector.y = 1;
			}
		}
		else
			walkTime--;
		ent.move();
	}

}
