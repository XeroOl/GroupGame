package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.level.Level;
import com.lasacsgames.game.physics.Point;
import com.lasacsgames.game.physics.Vector;

public class Player extends Mob
{

	public Keyboard input;
	private Sprite sprite;
	private boolean walking = false;
	private int anim = 0;

	public Player(Keyboard input, Level level)
	{
		location = new Point(0, 0);
		this.input = input;
		this.setLevel(level);
		sprite = Sprite.player_forward;
		vector = new Vector(0, 0);
	}

	public Player(int x, int y, Keyboard input, Level level)
	{
		this.location = new Point(x, y);
		vector = new Vector(0, 0);
		this.input = input;
		this.setLevel(level);
		sprite = Sprite.player_forward;
	}

	public void update()
	{
		vector.x = 0;
		vector.y = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (input.UP)
			vector.y--;
		if (input.DOWN)
			vector.y++;
		if (input.LEFT)
			vector.x--;
		if (input.RIGHT)
			vector.x++;

		if (vector.x != 0 || vector.y != 0)
		{
			move();
			walking = true;
		} else
			walking = false;
	}

	public void render(Screen screen)
	{
		int flip = 0;
		if (dir == 0)
		{
			sprite = Sprite.player_forward;
			if (walking)
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_forward_1;
				} else
					sprite = Sprite.player_forward_2;
			}
		}
		if (dir == 1 || dir == 3)
		{
			sprite = Sprite.player_side;
			if (walking)
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_side_1;
				} else
					sprite = Sprite.player_side_2;
			}
		}
		if (dir == 2)
		{
			sprite = Sprite.player_backward;
			if (walking)
			{
				if (anim % 20 > 10)
				{
					sprite = Sprite.player_backward_1;
				} else
					sprite = Sprite.player_backward_2;
			}
		}
		if (dir == 3)
			flip = 1;
		screen.renderPlayer((int) location.x - 16, (int) location.y - 16, sprite, flip);
	}

	public void spawnRandomly()
	{
		while (collision(0, 0))
		{
			location.x = random.nextInt(level.width) * 16 + 2;
			location.y = random.nextInt(level.height) * 16 + 2;
		}
	}

	public boolean collision(double xa, double ya)
	{
		boolean b = false;
		for (int i = 0; i < 4; i++)
		{
			int x = (i / 2) * 3;
			int y = (i % 2) * 3;
			if (getLevel().getTile((((int) (location.x + xa - 2 + x)) >> 4), (((int) (location.y + ya - 2 + y) >> 4))).solid())
				b = true;
		}
		return b;
	}

}
