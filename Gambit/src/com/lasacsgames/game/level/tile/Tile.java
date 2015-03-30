package com.lasacsgames.game.level.tile;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public abstract class Tile
{

	public int x, y;
	public Sprite sprite;

	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile grass = new GrassTile(Sprite.grass);

	public Tile(Sprite sprite)
	{
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen)
	{
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid()
	{
		return false;
	}

}
