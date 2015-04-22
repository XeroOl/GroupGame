package com.lasacsgames.game.level.tile;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public class VoidTile extends Tile
{

	public VoidTile(Sprite sprite)
	{
		super(sprite);
	}


	public boolean solid()
	{
		return true;
	}

}
