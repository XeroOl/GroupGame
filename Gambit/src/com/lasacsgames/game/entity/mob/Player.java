package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.entity.component.input.InputComponent;
import com.lasacsgames.game.entity.component.input.PlayerInputComponent;
import com.lasacsgames.game.entity.weapon.GrenadeLauncher;
import com.lasacsgames.game.entity.weapon.Gun;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.input.Mouse;
import com.lasacsgames.game.level.Level;

public class Player extends Mob
{
	private InputComponent input;
	private Keyboard key;
	private Mouse mouse;
	private Gun weapon;
	private boolean walking = false;
	private int anim = 0;

	public Player(Keyboard key, Level level)
	{
		super(level);
		this.key = key;
		sprite = Sprite.player_forward;
		setSize(4, 4);
		this.input = new PlayerInputComponent();
		weapon = new GrenadeLauncher(this);
	}

	public Player(int x, int y, Keyboard key, Level level)
	{
		this(key, level);
		setLocation(x, y);
	}

	public Player(Keyboard key, Mouse mouse, Level level)
	{
		this(key, level);
		this.mouse = mouse;
	}

	public void update()
	{
		input.update(this, key, mouse);
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (mouse.mouse[1]) weapon.fire(mouse.getLocation());
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
		if (drawable) screen.renderPlayer((int) location.x - 16, (int) location.y - 16, sprite, flip);
		weapon.render(screen);
	}
}
