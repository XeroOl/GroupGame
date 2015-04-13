package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.physics.Point;

public class GhostEnemy extends Mob
{

	public GhostEnemy(int x, int y, Level level)
	{
		location = new Point(x, y);
		this.level = level;
	}

	public void render(Screen screen)
	{
		if (drawable) screen.renderEntity(location.x - 8, location.y - 8, Sprite.ghost);
	}
}
