package com.lasacsgames.game.level.tile;

import com.lasacsgames.game.graphics.Sprite;

public class BrickTile extends Tile
{

	public BrickTile(Sprite sprite)
	{
		super(sprite);
		blastResistance=3;
	}
	
	public boolean solid()
	{
		return true;
	}

}
