package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.entity.projectile.Grenade;
import com.lasacsgames.game.entity.projectile.Projectile;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.input.Mouse;
import com.lasacsgames.game.level.Level;

public class Player extends Mob
{
	public Keyboard input;
	public Mouse inputt;// this is really dumb
	private boolean walking = false;
	private int anim = 0;
	private int recoil = 0;
	private Projectile[] bullets;

	public Player(Keyboard input, Level level)
	{
		super(level);
		this.input = input;
		sprite = Sprite.player_forward;
		setSize(2, 2);
		bullets = new Projectile[10];
		for (int i = 0; i < bullets.length; i++)
		{
			bullets[i] = new Grenade(this, 0.8);
			bullets[i].remove();
		}
	}

	public Player(int x, int y, Keyboard input, Level level)
	{
		this(input, level);
		setLocation(x, y);
	}

	public Player(Keyboard input, Mouse inputt, Level level)

	{
		this(input, level);
		this.inputt = inputt;
	}

	public void update()
	{
		vector.x = 0;
		vector.y = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (input.UP) vector.y--;
		if (input.DOWN) vector.y++;
		if (input.LEFT) vector.x--;
		if (input.RIGHT) vector.x++;
		if (input.BACKSLASH && !input.tempCodeFix) collidable = !collidable;

		if (moveable && (vector.x != 0 || vector.y != 0))
		{
			if (!collidable) vector.multiply(3.0);
			move();
			walking = true;
		}
		else
			walking = false;
		handleShooting();
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
		if (drawable) screen.renderPlayer((int)location.x - 16, (int)location.y - 16, sprite, flip);
		for (int i = 0; i < bullets.length; i++)
		{
			if (!bullets[i].isRemoved()) bullets[i].render(screen);
		}
	}

	public void shoot()
	{
		for (int i = 0; i < bullets.length; i++)
		{
			if (bullets[i].isRemoved())
			{
				bullets[i].respawn(inputt.getLocation());
				recoil = 15;
				return;
			}
		}
	}

	public void handleShooting()
	{
		if (recoil > 0) recoil--;
		if (inputt.mouse[1] && recoil == 0) shoot();
		for (int i = 0; i < bullets.length; i++)
		{
			if (!bullets[i].isRemoved()) bullets[i].update();
		}
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
