package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.entity.component.input.GhostInputComponent;
import com.lasacsgames.game.entity.component.input.InputComponent;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.level.Level;

public class GhostEnemy extends Mob
{
	private InputComponent input;

	public GhostEnemy(int x, int y, Level level)
	{
		super(level);
		setLocation(x, y);
		sprite = Sprite.ghost;
		input = new GhostInputComponent();
	}

	public void render(Screen screen)
	{
		if (drawable) screen.renderEntity((int) location.x - 8, (int) location.y - 8, sprite);
	}

	public void update()
	{
		input.update(this, null, null);
	}
}
