package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.entity.weapon.Rifle;
import com.lasacsgames.game.entity.weapon.Weapon;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.input.Mouse;
import com.lasacsgames.game.level.Level;

public class Player extends Mob
{
	private Keyboard key;
	private Mouse mouse;
	private Weapon weapon;
	private boolean walking = false;
	private int anim = 0;

	public Player(Keyboard input, Level level)
	{
		super(level);
		this.key = input;
		sprite = Sprite.player_forward;
		setSize(2, 2);
		weapon = new Rifle(this);
	}

	public Player(int x, int y, Keyboard input, Level level)
	{
		this(input, level);
		setLocation(x, y);
	}

	public Player(Keyboard input, Mouse inputt, Level level)

	{
		this(input, level);
		this.mouse = inputt;
	}

	public void update()
	{
		vector.x = 0;
		vector.y = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (key.UP) vector.y--;
		if (key.DOWN) vector.y++;
		if (key.LEFT) vector.x--;
		if (key.RIGHT) vector.x++;
		if (key.BACKSLASH && !key.tempCodeFix) collidable = !collidable;
		if (mouse.mouse[1]) weapon.shoot(mouse.getLocation());

		if (moveable && (vector.x != 0 || vector.y != 0))
		{
			if (!collidable) vector.multiply(3.0);
			move();
			walking = true;
		}
		else
			walking = false;
		weapon.update();
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
				}
				else
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
				}
				else
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
				}
				else
					sprite = Sprite.player_backward_2;
			}
		}
		if (dir == 3) flip = 1;
		if (drawable) screen.renderPlayer(location.x - 16,  location.y - 16, sprite, flip);
		weapon.render(screen);
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
		if (!collidable) return false;
		boolean b = false;
		for (int i = 0; i < 4; i++)
		{
			int x = (i / 2) * 3;
			int y = (i % 2) * 3;
			if (level.getTile((((int) (location.x + xa - 2 + x)) >> 4), (((int) (location.y + ya - 2 + y) >> 4))).solid()) b = true;
		}
		return b;
	}
}
