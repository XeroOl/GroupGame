package com.lasacsgames.game.level.tile;

import com.lasacsgames.game.graphics.Sprite;

public class RockTile extends Tile
{

	public RockTile(Sprite sprite)
	{
		super(sprite);
	}
	
	public boolean solid()
	{
		return true;
	}

}
