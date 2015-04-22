package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.level.Level;

public class GhostEnemy extends Mob
{
	private int dir;
	private int walkTime = 0;

	public GhostEnemy(int x, int y, Level level)
	{
		super(level);
		setLocation(x, y);
		sprite = Sprite.ghost;
	}

	public void render(Screen screen)
	{
		if (drawable) screen.renderEntity((int) location.x - 8, (int) location.y - 8, sprite);
	}

	public void update()
	{
		if (collision(vector.x, vector.y)) walkTime = 0;
		if (walkTime == 0)
		{
			walkTime = random.nextInt(120) + 30;
			dir++;
			if (dir > 3) dir = 0;

			switch (dir)
			{
				case 0:
					vector.x = 1;
					vector.y = 0;
					break;
				case 1:
					vector.x = 0;
					vector.y = -1;
					break;
				case 2:
					vector.x = -1;
					vector.y = 0;
					break;
				case 3:
					vector.x = 0;
					vector.y = 1;
			}
		}
		else
			walkTime--;
		move();
	}
}
