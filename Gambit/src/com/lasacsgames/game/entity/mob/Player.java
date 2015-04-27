package com.lasacsgames.game.entity.mob;

import com.lasacsgames.game.entity.component.graphics.GraphicsComponent;
import com.lasacsgames.game.entity.component.graphics.PlayerGraphicsComponent;
import com.lasacsgames.game.entity.component.input.InputComponent;
import com.lasacsgames.game.entity.component.input.PlayerInputComponent;
import com.lasacsgames.game.entity.component.physics.PhysicsComponent;
import com.lasacsgames.game.entity.component.physics.PlayerPhysicsComponent;
import com.lasacsgames.game.entity.weapon.GrenadeLauncher;
import com.lasacsgames.game.entity.weapon.Gun;
import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;
import com.lasacsgames.game.input.Keyboard;
import com.lasacsgames.game.input.Mouse;
import com.lasacsgames.game.level.Level;

public class Player extends Mob
{
	private GraphicsComponent graphics;
	private PhysicsComponent physics;
	private InputComponent input;
	private Keyboard key;
	private Mouse mouse;
	private Gun weapon;

	public Player(Keyboard key, Level level)
	{
		super(level);
		this.key = key;
		sprite = Sprite.player_forward;
		setSize(4, 4);
		this.input = new PlayerInputComponent();
		this.physics = new PlayerPhysicsComponent();
		this.graphics = new PlayerGraphicsComponent();
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
		physics.update(this);
		graphics.update(this);
		if (mouse.mouse[1]) weapon.fire(mouse.getLocation());
		weapon.update();
	}

	public void render(Screen screen)
	{
		graphics.render(this, screen);
		weapon.render(screen);
	}
}
