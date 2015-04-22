package com.lasacsgames.game.level.tile;

import com.lasacsgames.game.graphics.Screen;
import com.lasacsgames.game.graphics.Sprite;

public abstract class Tile
{

	public int x, y; // X and Y are unused;
	public Sprite sprite;
	public double blastResistance;
	public static Tile VOID_TILE = new VoidTile(Sprite.VOID_SPRITE);
	public static Tile GRASS_TILE[] = {new GrassTile(Sprite.GRASS_SPRITE[0]),new GrassTile(Sprite.GRASS_SPRITE[1]),new GrassTile(Sprite.GRASS_SPRITE[2]),new GrassTile(Sprite.GRASS_SPRITE[3]),new GrassTile(Sprite.GRASS_SPRITE[4]),new GrassTile(Sprite.GRASS_SPRITE[5]),new GrassTile(Sprite.GRASS_SPRITE[6])};
	public static Tile ROCK_TILE = new RockTile(Sprite.ROCK_SPRITE);
	public static Tile BRICK_TILE = new BrickTile(Sprite.BRICK_SPRITE);
public static int SIZE = 16;
	public Tile(Sprite sprite)
	{
		this.sprite = sprite;
	}



	public boolean solid()
	{
		return false;
	}

}
