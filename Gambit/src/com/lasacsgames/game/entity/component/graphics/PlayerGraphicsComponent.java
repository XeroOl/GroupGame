package com.lasacsgames.game.entity.component.graphics;

import com.lasacsgames.game.entity.Entity;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public class PlayerGraphicsComponent extends GraphicsComponent
{
	boolean walking = false;
	int anim = 0;
	
	public void update(Entity ent)
	{
		walking = (ent.vector.x != 0 || ent.vector.y != 0) ? true : false;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
	}

	public void render(Entity ent, Screen screen)
	{
		int flip = 0;
		if (ent.dir == 0)
		{
			sprite = Sprite.player_forward;
			if (walking)
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_forward_1;
				}
				else
					sprite = Sprite.player_forward_2;
			}
		}
		if (ent.dir == 1 || ent.dir == 3)
		{
			sprite = Sprite.player_side;
			if (walking)
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_side_1;
				}
				else
					sprite = Sprite.player_side_2;
			}
		}
		if (ent.dir == 2)
		{
			sprite = Sprite.player_backward;
			if (walking)
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_backward_1;
				}
				else
					sprite = Sprite.player_backward_2;
			}
		}
		if (ent.dir == 3) flip = 1;
		if (drawable) screen.renderPlayer((int) ent.location.x - 16, (int) ent.location.y - 16, sprite, flip);
	}

}
